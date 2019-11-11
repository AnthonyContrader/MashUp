package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Album;
import it.contrader.model.Track;

@Repository
@Transactional
public interface TrackRepository extends CrudRepository<Track, Long> {

public List<Track> findAllByAlbum(Album album);

}
