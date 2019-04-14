package org.shu.yzy.ontology.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String username;
    @Column(length = 32)
    private String password;
    @Column(length = 32)
    private String realName;
    @Column(length = 32)
    private String organization;
    @Column(length = 11)
    private String mobilePhone;
    @Column(length = 32)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public User(){

    }
}
