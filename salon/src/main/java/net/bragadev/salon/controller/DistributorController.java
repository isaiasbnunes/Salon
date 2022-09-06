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

import net.bragadev.salon.model.Distributor;
import net.bragadev.salon.service.DistributorService;

@CrossOrigin("*")
@RestController
@RequestMapping("fornecedor")
public class DistributorController {

	private DistributorService service;

	public DistributorController(DistributorService service) {
		this.service = service;
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Distributor> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Distributor>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Distributor> create(@RequestBody Distributor d){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(d));
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Distributor> update(@PathVariable Long id, @RequestBody Distributor d){
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.update(id, d));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
