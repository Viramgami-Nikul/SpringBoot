package com.nikul.product.controller;

import com.nikul.product.dto.CategoryDTO;
import com.nikul.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
//yaha pe CategoryService ke liye ham autowired na likh ishke badleham allarguconsturctor likh sakte hai
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    //get All categories
    @GetMapping
    public List<CategoryDTO> getAllCategories(){
      return categoryService.getAllCategories();

    }
    //create categories

    //yahpe ham post method use karrahe hai
    @PostMapping

    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    //get category by id

    @GetMapping("/{id}")
    public CategoryDTO getCategoryId(@PathVariable Long id){
        return categoryService.getCategoryId(id);
    }

    //delete category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);

    }
}
