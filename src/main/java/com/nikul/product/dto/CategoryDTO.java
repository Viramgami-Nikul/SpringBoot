//DTO ka use reponse dene keliye use hota hai
package com.nikul.product.dto;

import lombok.*;

import java.util.List;

@Data   //ishme getter and setter jaise hote hai to direct data likha
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}
