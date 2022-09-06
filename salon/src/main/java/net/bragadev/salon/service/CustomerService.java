package net.bragadev.salon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.bragadev.salon.exceptions.MyException;
import net.bragadev.salon.model.Customer;
import net.bragadev.salon.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;

	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}
	
	public Customer findById(Long id) {
		 Optional<Customer> c = repository.findById(id);
		return c.orElseThrow(() -> new MyException("Cliente não encontrado! Id: "+id));
	}
	
	public List<Customer> findAll(){
		return repository.findByEnabledTrueOrderByNameAsc();
	}

	public Customer create(Customer c) {
		return repository.save(c);
	}
	
	public Customer update(Long id, Customer c) {
		findById(id);
		c.setId(id);
		return repository.save(c);
	}
	
	public void delete(Long id) {
			Customer c = findById(id);
			c.setEnabled(false);
			repository.save(c);
	}
}
