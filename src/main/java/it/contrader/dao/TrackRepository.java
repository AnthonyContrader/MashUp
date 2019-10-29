package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Track;

@Repository
@Transactional
public interface TrackRepository extends CrudRepository<Track, Long> {

	Track findByTitle(String title);

}
