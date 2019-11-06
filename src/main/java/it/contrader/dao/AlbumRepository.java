package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Album;

@Repository
@Transactional
public interface AlbumRepository extends CrudRepository<Album, Long>{
	

	
}