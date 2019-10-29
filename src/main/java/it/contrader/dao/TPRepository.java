package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.TP;

@Repository
@Transactional
public interface TPRepository extends CrudRepository<TP, Long>{

	
	
}