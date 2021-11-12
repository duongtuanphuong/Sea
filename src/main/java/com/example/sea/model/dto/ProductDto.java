package com.example.sea.model.dto;

import java.util.ArrayList;

import com.example.sea.entity.Brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
    private long id;

    private String name;

    private String slug;
    
    private String description;

    private Brand brand;

    private long price;

    private int totalSold;

    private String productImage;

    private ArrayList<String> sliderImage;
}
