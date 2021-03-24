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

@CrossOrigin
@RestController
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

    @CrossOrigin
    @PostMapping("/api/auth/signin")
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

    @CrossOrigin
    @PostMapping("/api/auth/signup")
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
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "dev":
                        Role modRole = roleRepository.findByName(ERole.ROLE_DEV)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

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

    @CrossOrigin
    @PostMapping("/releases")
    public String releases(@RequestBody Release release) {
        releaseRepository.save(release);
        return "success";
    }

    @CrossOrigin
    @GetMapping("/view/releases/{role}/{empID}")
    @ResponseBody
    public List<Release> view_releases(@PathVariable("role") String role, @PathVariable("empID") long empID) {
        if (role.equals("developer")) {
            List<Release> releases = releaseRepository.findbyempid(empID);
            return releases;
        } else if (role.equals("admin")) {
            List<Release> releases = releaseRepository.findAll();
            return releases;
        } else if (role.equals("manager")) {
            Optional<User> user = userRepository.findById(empID);
            long teamid = user.get().getPodid();
            List<Release> releases = releaseRepository.findbypodid(teamid);
            return releases;
        } else if(role.equals("qa")){
            Optional<User> user=userRepository.findById(empID);
            String name=user.get().getUsername();
            List<Release> releases = releaseRepository.findbyname(name);
            return releases;
        }
        return null;
    }
}