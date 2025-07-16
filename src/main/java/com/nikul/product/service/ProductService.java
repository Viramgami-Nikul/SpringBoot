//service ka use ham business login likhene ke liye use karte hai
package com.nikul.product.service;

import com.nikul.product.dto.ProductDTO;
import com.nikul.product.entity.Category;
import com.nikul.product.entity.Product;
import com.nikul.product.mapper.ProductMapper;
import com.nikul.product.repository.CategoryRepository;
import com.nikul.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO){
        /**
         * yahape ish dto me name,description,price,categoryId hai
         * yaha pe niche ye logic likhe ge ge koi nai product add kare to vo category hai nahi vo match karenge
         *
         */
        //yahepe vo id check karega Category me hoga to databse ne return karega
     Category category= categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("category not found"));

     //yaha pe ham prductDto ko save nahi karsate ishliye hame dto to entity karna padega vo ProductMapper me method hoga

//        DTO to Entity
        //yahpe method me do argument upperka productdto and category dale ye
       Product product= ProductMapper.toProductEntity(productDTO,category);
       product = productRepository.save(product);


       //yahape product savehua product table me but reponse and return dto me hoga to hame entity to dto karna padega

        //Entity to Dto

        return ProductMapper.toProductDTO(product);
    }

    //get allproduct
    public List<ProductDTO> getAllProduct(){
      return  productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    //get product by id
    public ProductDTO getProductId(Long id){
 Product product= productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
 return ProductMapper.toProductDTO(product);
    }

    //update Product
    public ProductDTO updateProduct(Long id,ProductDTO productDTO){
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        //jab ham update kare tab check hot yai ki vo category productdto me hai ya nahi
     Category category= categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("Category  not found"));

        //update ko database me save karne ke liye

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);



    }

    //delet product
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Prduct "+id+" has been deleted";
    }
}
