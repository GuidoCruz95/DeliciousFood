package com.coderoad.deliciousfood.models;

import com.coderoad.deliciousfood.DTOs.UserDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String address;
    private String cellphone;

    private String facebookId;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @Embedded
    private Location location;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles = new HashSet<>();

    public boolean hasRole(String role) {
        return roles.contains(role);
    }

    public UserDTO getDTO() {
        UserDTO dto = new UserDTO();
        dto.setName(this.name);
        dto.setEmail(this.email);
        dto.setAddress(this.address);
        dto.setCellphone(this.cellphone);
        dto.setFacebookId(this.facebookId);
        return dto;
    }
}