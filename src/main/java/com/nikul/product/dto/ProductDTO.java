package com.nikul.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Dto me sensitive data nahi pass karte jaise userpassword yaha require name,id ishtarh pass karsakte hai
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private  Double price;
    private Long CategoryId;
}
