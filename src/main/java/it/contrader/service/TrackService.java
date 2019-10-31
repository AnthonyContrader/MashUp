package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.TrackConverter;
import it.contrader.dao.TrackRepository;
import it.contrader.dto.TrackDTO;
import it.contrader.model.Track;

@Service
public class TrackService extends AbstractService<Track, TrackDTO> {
	
	@Autowired
	private TrackRepository trackRepository;
	@Autowired
	private TrackConverter trackConverter;

	public List<TrackDTO> getAllByAlbum_id(Long id) {
		return trackConverter.toDTOList(trackRepository.findAllByAlbum_id(id));
	}
}


