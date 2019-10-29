package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.TrackConverter;
import it.contrader.dao.TrackRepository;
import it.contrader.dto.TrackDTO;
import it.contrader.model.Track;

@Service
public class TrackService extends AbstractService<Track, TrackDTO> {

	@Autowired
	private TrackConverter converter;
	@Autowired
	private TrackRepository repository;

	public TrackDTO findByTitle(String title) {
		return converter.toDTO(repository.findByTitle(title));
	}

}
