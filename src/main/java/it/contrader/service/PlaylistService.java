package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.PlaylistConverter;
import it.contrader.dao.PlaylistRepository;
import it.contrader.dto.PlaylistDTO;
import it.contrader.model.Playlist;

@Service
public class PlaylistService extends AbstractService<Playlist, PlaylistDTO> {

	@Autowired
	private PlaylistConverter converter;
	@Autowired
	private PlaylistRepository repository;
	
	public PlaylistDTO findByName(String name) {
		return converter.toDTO(repository.findByName(name));
	}
}
