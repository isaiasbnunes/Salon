package net.bragadev.salon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.bragadev.salon.exceptions.MyException;
import net.bragadev.salon.model.Distributor;
import net.bragadev.salon.repository.DistributorRepository;

@Service
public class DistributorService {

	private DistributorRepository repository;

	public DistributorService(DistributorRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Distributor findById(Long id) {
		 Optional<Distributor> c = repository.findById(id);
		return c.orElseThrow(() -> new MyException("Distribuidor não encontrado! Id: "+id));
	}
	
	public List<Distributor> findAll(){
		return repository.findByEnabledTrueOrderByNameAsc();
	}

	public Distributor create(Distributor c) {
		return repository.save(c);
	}
	
	public Distributor update(Long id, Distributor c) {
		findById(id);
		c.setId(id);
		return repository.save(c);
	}
	
	public void delete(Long id) {
		Distributor c = findById(id);
		c.setEnabled(false);
		repository.save(c);
	}
}
