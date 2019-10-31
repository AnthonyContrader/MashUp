package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Playlist;


@Repository
@Transactional
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
	

	public List<Playlist> findByUser_id(Long id);

}
