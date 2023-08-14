package com.example.clothifyecom.dto;

import com.example.clothifyecom.enums.ItemCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter

public class ItemRequestDTO {
    private String name;
    private  double price;
    private int Lqty;
    private int Mqty;
    private int Sqty;
    private ItemCategory category;
    private MultipartFile img;
}
