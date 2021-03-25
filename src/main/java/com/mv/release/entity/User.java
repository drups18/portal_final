package com.mv.release.entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(    name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eid;
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    private long podid;
    @NotBlank
    @Size(max = 120)
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    public User(Long eid, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email, Long podid, @NotBlank @Size(max = 120) String password) {
        this.eid = eid;
        this.username = username;
        this.email = email;
        this.podid= podid;
        this.password = password;
        this.roles = roles;
    }
    public User() {
        super();
    }
    public Long getEid() {
        return eid;
    }
    public void setEid(Long eid) {
        this.eid = eid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Long getPodid() {
        return podid;
    }
    public void setPodid(Long podid) {
        this.podid = podid;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}