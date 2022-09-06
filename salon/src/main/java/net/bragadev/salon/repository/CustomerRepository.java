package net.bragadev.salon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.bragadev.salon.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	List<Customer> findByEnabledTrueOrderByNameAsc();
}
