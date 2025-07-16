package com.nikul.product.mapper;

import com.nikul.product.dto.CategoryDTO;
import com.nikul.product.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toCategoryDTO(Category category){
        if(category == null)
        {
            return null;
        }
        CategoryDTO categoryDTO =new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());
        return categoryDTO;
    }



// yaha pe CategoryServicefile ke under convert karne ke liye hamne category ko   convert kiya in entity
    public static Category toCategoryEntity(CategoryDTO categoryDTO){
       Category category=new Category();
       category.setName(categoryDTO.getName());
       return category;
    }
}
