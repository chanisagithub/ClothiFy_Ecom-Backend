package com.example.clothifyecom.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CrudResponses {
    private boolean isSuccess;
    private String message;
}
