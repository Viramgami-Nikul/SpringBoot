package com.nikul.product.service;

import com.nikul.product.dto.CategoryDTO;
import com.nikul.product.entity.Category;
import com.nikul.product.mapper.CategoryMapper;
import com.nikul.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    //create category
    //yaha pe create category ko database me dalne ke liye hame dto se nahi hoga to mapper through entity me  karege
    public CategoryDTO createCategory(CategoryDTO categoryDTO){ //ishke matlab ki ye data ko save karega jab category create hogi tab ye response me show karayega

Category category= CategoryMapper.toCategoryEntity(categoryDTO);
category=categoryRepository.save(category);
return   CategoryMapper.toCategoryDTO(category);


    }


    //get all category
    public List<CategoryDTO> getAllCategories(){
        //map ka use data ko transfer karne ke liye yse hota hai ham yaha pe hi entity ko dto me karsakte hai
       return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList(); //repository ka matlab ki database me value fatch karsakte hai
    }
    //get category by id
    public CategoryDTO getCategoryId(Long id){
       Category category= categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        return CategoryMapper.toCategoryDTO(category);

    }
    //delete category

    public String deleteCategory(Long id){
        categoryRepository.deleteById(id);
        return "Category "+id+"has been deleted!";
    }
}
