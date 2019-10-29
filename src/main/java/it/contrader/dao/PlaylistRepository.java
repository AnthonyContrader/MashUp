package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Playlist;
import it.contrader.model.User;;

@Repository
@Transactional
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {

	Playlist findByName(String name);

}
