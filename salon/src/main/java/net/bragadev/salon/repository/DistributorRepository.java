package net.bragadev.salon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.bragadev.salon.model.Distributor;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long>{
	List<Distributor> findByEnabledTrueOrderByNameAsc();
}
