package net.bragadev.salon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.bragadev.salon.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{
	List<Brand> findByEnabledTrueOrderByNameAsc();
}
