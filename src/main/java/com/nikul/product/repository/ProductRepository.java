package com.nikul.product.repository;

import com.nikul.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository me in build method hot hai to hame database connection karneki jarurt nahi hai

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> { //yahape <entity_name,primarykey_type> pass kiya fetch karne ke liye
}
