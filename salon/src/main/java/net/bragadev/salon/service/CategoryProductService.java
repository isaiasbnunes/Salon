package net.bragadev.salon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.bragadev.salon.exceptions.MyException;
import net.bragadev.salon.model.CategoryProduct;
import net.bragadev.salon.repository.CategoryProductRepository;

@Service
public class CategoryProductService {

	private CategoryProductRepository repository;

	public CategoryProductService(CategoryProductRepository repository) {
		this.repository = repository;
	}
	
	public CategoryProduct findById(Long id) {
		 Optional<CategoryProduct> c = repository.findById(id);
		return c.orElseThrow(() -> new MyException("Categoria não encontrada! Id: "+id));
	}
	
	public List<CategoryProduct> findAll(){
		return repository.findByEnabledTrueOrderByNameAsc();
	}

	public CategoryProduct create(CategoryProduct c) {
		return repository.save(c);
	}
	
	public CategoryProduct update(Long id, CategoryProduct c) {
		findById(id);
		c.setId(id);
		return repository.save(c);
	}
	
	public void delete(Long id) {
		CategoryProduct c = findById(id);
		c.setEnabled(false);
		repository.save(c);
	}
}
