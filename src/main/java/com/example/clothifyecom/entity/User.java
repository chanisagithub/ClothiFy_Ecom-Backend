package com.example.clothifyecom.entity;

import com.example.clothifyecom.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @Column(unique = true,nullable = false)
    private String username;
    private String password;

    @Column(nullable = false)
    private UserRole role;

    @Column(unique = true,nullable = false)
    private String email;


}
