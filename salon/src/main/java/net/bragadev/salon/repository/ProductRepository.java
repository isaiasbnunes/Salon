package net.bragadev.salon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.bragadev.salon.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	List<Product> findByEnabledTrueOrderByNameAsc();
}
