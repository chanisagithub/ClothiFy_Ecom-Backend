package com.example.clothifyecom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    //@column(unique = true,nullable = false)
    private String username;
    private String password;
    //@Column(nullable = false)
    private String role;
    //@Column(unique = true,nullable = false)
    private String email;


}
