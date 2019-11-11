package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.AlbumConverter;
import it.contrader.converter.TrackConverter;
import it.contrader.dao.TrackRepository;
import it.contrader.dto.AlbumDTO;
import it.contrader.dto.TrackDTO;
import it.contrader.model.Track;

@Service
public class TrackService extends AbstractService<Track, TrackDTO> {
	
	@Autowired
	private TrackRepository trackRepository;
	@Autowired
	private TrackConverter trackConverter;
	@Autowired
	private AlbumConverter albumConverter;

	public List<TrackDTO> getAllByAlbum(AlbumDTO album) {
		return trackConverter.toDTOList(trackRepository.findAllByAlbum(albumConverter.toEntity(album)));
	}
}


