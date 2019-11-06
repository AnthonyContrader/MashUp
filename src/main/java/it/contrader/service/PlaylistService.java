package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.PlaylistConverter;
import it.contrader.dao.PlaylistRepository;
import it.contrader.dto.PlaylistDTO;
import it.contrader.model.Playlist;

@Service
public class PlaylistService extends AbstractService<Playlist, PlaylistDTO> {
	
	@Autowired
	private PlaylistConverter playlistConverter;
	@Autowired
	private PlaylistRepository playlistRepository;
	
	public List<PlaylistDTO> getAllByUser_id (Long id){
		return playlistConverter.toDTOList(playlistRepository.findByUser_id(id));
	}


}
