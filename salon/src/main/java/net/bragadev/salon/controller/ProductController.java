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

import net.bragadev.salon.model.Product;
import net.bragadev.salon.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/produto")
public class ProductController {

	private ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product p){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(p));
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product p){
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.update(id, p));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
