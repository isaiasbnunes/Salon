package net.bragadev.salon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.bragadev.salon.model.CategoryProduct;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Long>{
	List<CategoryProduct> findByEnabledTrueOrderByNameAsc();
}
