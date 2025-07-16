package com.nikul.product.controller;

import com.nikul.product.dto.ProductDTO;
import com.nikul.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //RestApi banane ke liye hame RestController banana padta hai
@RequestMapping("/api/products") //matlab url me ye hoga tab ye controller or ye class execute hoga //laravel me web.php ki tarah path set
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    //get AllProduct
    @GetMapping
    public List<ProductDTO> getAllCategory(){
       return productService.getAllProduct();
    }
    //create Product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
            ProductDTO createdProduct= productService.createProduct(productDTO);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED); //ye httpStatus me jab create karenge tab api me 201 dikhan chahiy niche ish liye ye use kiya
    }

    //get product by id
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductId(id);

    }
    //update Product
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO){
    return productService.updateProduct(id,productDTO);
    }
    //delete product

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
    return   productService.deleteProduct(id);
    }

}
