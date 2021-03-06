package com.mv.release.controller;

import com.mv.release.entity.ERole;
import com.mv.release.entity.Release;
import com.mv.release.entity.Role;
import com.mv.release.entity.User;
import com.mv.release.jwt.JwtUtils;
import com.mv.release.payload.JwtResponse;
import com.mv.release.payload.LoginRequest;
import com.mv.release.payload.MessageResponse;
import com.mv.release.payload.SignupRequest;
import com.mv.release.repository.ReleaseRepository;
import com.mv.release.repository.RoleRepository;
import com.mv.release.repository.UserRepository;
import com.mv.release.service.MailService;
import com.mv.release.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    ReleaseRepository releaseRepository;

    @Autowired
    MailService service;

    @PostMapping("/api/auth/signin")
    @CrossOrigin()
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getPodid(),
                roles));
    }

    @PostMapping("/api/auth/signup")
    @CrossOrigin
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getEid(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPodid(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Role not specified"));

        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.admin)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "developer":
                        Role modRole = roleRepository.findByName(ERole.developer)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        break;

                    case "manager":
                        Role managerRole = roleRepository.findByName(ERole.manager)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(managerRole);
                        break;

                    case "devops":
                        Role devopsRole = roleRepository.findByName(ERole.devops)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(devopsRole);
                        break;

                    case "release_manager":
                        Role release_managerRole = roleRepository.findByName(ERole.release_manager)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(release_managerRole);
                        break;

                    case "qa":
                        Role qaRole = roleRepository.findByName(ERole.qa)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(qaRole);

                        break;
                    default:
                        throw (new RuntimeException("Role not found"));
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PutMapping("/releases")
//    @CrossOrigin(origins = "http://localhost:3000/")
    @CrossOrigin
    public String releases(@RequestBody Release release) {
        releaseRepository.save(release);
        String name = release.getDevpoc();
        Long empid = release.getEmpID();
        String eemail = userRepository.findById(empid).get().getEmail();
        ArrayList<String> mails = new ArrayList<>();
        mails.add(eemail);
        triggermail(mails, "Your Release has been accepted with devPOC " + name, "Release Manager Portal");
        return "success";
    }

    @GetMapping("/view/releases/{role}/{empID}")
    @CrossOrigin
    @ResponseBody
    public List<Release> view_releases(@PathVariable("role") String role, @PathVariable("empID") long empID) {
        if (role.equals("developer")) {
            List<Release> releases = releaseRepository.findByEmpID(empID);
            return releases;
        } else if (role.equals("admin")) {
            List<Release> releases = releaseRepository.findAll();
            return releases;
        } else if (role.equals("manager")) {
            Optional<User> user = userRepository.findById(empID);
            long teamid = user.get().getPodid();
            List<Release> releases = releaseRepository.findByPodid(teamid);
            return releases;
        } else if (role.equals("qa")) {
            Optional<User> user = userRepository.findById(empID);
            String name = user.get().getUsername();
            List<Release> releases = releaseRepository.findByQapoc(name);
            return releases;
        } else if (role.equals("release_manager")) {
            List<Release> releases = releaseRepository.findByRelease_status();
            return releases;
        } else if (role.equals("devops")) {
            List<Release> releases = releaseRepository.findByReleasestatus();
            return releases;
        }
        return null;
    }

    @PutMapping("/releases/{rel_id}")
    @CrossOrigin
    public String update_releases(@RequestBody Release release, @PathVariable("rel_id") long rel_id) {
        release.setRelease_id(rel_id);
        release = releaseRepository.save(release);
        Long pid = release.getPodid();
        System.out.println(pid);
        Long eid = release.getEmpID();
        System.out.println(eid);
        String release_status = release.getRelease_status();
        String qapoc = release.getQapoc();
        String qamail = userRepository.findbyqaname(qapoc,pid);
//        System.out.println(qamail);
        String demail = userRepository.findById(eid).get().getEmail();
        ArrayList<String> mails = new ArrayList<>();
        mails.add(qamail);
        mails.add(demail);
        if (release_status.equals("RM_Approved")){
            mails.add("avanti.gada@moneyview.in");
        }
        if (release_status.equals("Released")){
            mails.add("avanti.gada@moneyview.in");
        }
        triggermail(mails,"Your release is at stage" + release_status , "Release Status");
        return "success";
    }
    public String triggermail(ArrayList<String> k, String emailbody, String emailsubject) {
        for (int i = 0; i < k.size(); i++) {
            System.out.println("krkrk");
            service.sendSimpleEmail(k.get(i), emailbody, emailsubject);
        }
        return "sent";
    }

    @PutMapping("/users/edit")
    @CrossOrigin
    public String update_users(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "success";
    }
}

