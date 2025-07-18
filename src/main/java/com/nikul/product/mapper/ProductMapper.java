package com.nikul.product.mapper;

import com.nikul.product.dto.ProductDTO;
import com.nikul.product.entity.Category;
import com.nikul.product.entity.Product;

public class ProductMapper {

    //entity to DTO

    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
            product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getCategory().getId()

        );


    }
    public static Product toProductEntity(ProductDTO productDTO, Category category){
        Product product= new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;
    }
}
