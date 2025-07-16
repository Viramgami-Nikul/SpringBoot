//Repository ka use ham database ko entity ke sath connect karne ke liye use karte hai
package com.nikul.product.repository;

import com.nikul.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
