package net.bragadev.salon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.bragadev.salon.exceptions.MyException;
import net.bragadev.salon.model.Brand;
import net.bragadev.salon.repository.BrandRepository;

@Service
public class BrandService {

	private BrandRepository repository;

	public BrandService(BrandRepository repository) {
		this.repository = repository;
	}
	
	public Brand findById(Long id) {
		 Optional<Brand> c = repository.findById(id);
		return c.orElseThrow(() -> new MyException("Marca não encontrada! Id: "+id));
	}
	
	public List<Brand> findAll(){
		return repository.findByEnabledTrueOrderByNameAsc();
	}

	public Brand create(Brand c) {
		return repository.save(c);
	}
	
	public Brand update(Long id, Brand c) {
		findById(id);
		c.setId(id);
		return repository.save(c);
	}
	
	public void delete(Long id) {
		Brand c = findById(id);
		c.setEnabled(false);
		repository.save(c);
	}
}
