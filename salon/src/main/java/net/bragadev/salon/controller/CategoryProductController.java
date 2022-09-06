package net.bragadev.salon.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.bragadev.salon.model.CategoryProduct;
import net.bragadev.salon.service.CategoryProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/categoria-produto")
public class CategoryProductController {
	
	private CategoryProductService service;

	public CategoryProductController(CategoryProductService service) {
		this.service = service;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<CategoryProduct> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryProduct>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<CategoryProduct> create(@RequestBody CategoryProduct c){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(c));
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<CategoryProduct> update(@PathVariable Long id, @RequestBody CategoryProduct c){
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.update(id, c));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
