package com.example.ecom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecom.Model.Category;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Optional<Category> findByCategoryName(String categoryName);
}
