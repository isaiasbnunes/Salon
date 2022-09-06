package net.bragadev.salon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.bragadev.salon.exceptions.MyException;
import net.bragadev.salon.model.Product;
import net.bragadev.salon.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	public Product findById(Long id) {
		 Optional<Product> c = repository.findById(id);
		return c.orElseThrow(() -> new MyException("Produto não encontrado! Id: "+id));
	}
	
	public List<Product> findAll(){
		return repository.findByEnabledTrueOrderByNameAsc();
	}

	public Product create(Product c) {
		return repository.save(c);
	}
	
	public Product update(Long id, Product c) {
		findById(id);
		c.setId(id);
		return repository.save(c);
	}
	
	public void delete(Long id) {
		Product c = findById(id);
		c.setEnabled(false);
		repository.save(c);
	}
}
