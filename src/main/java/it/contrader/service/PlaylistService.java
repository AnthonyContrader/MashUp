package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.PlaylistConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.PlaylistRepository;
import it.contrader.dto.PlaylistDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Playlist;

@Service
public class PlaylistService extends AbstractService<Playlist, PlaylistDTO> {
	
	@Autowired
	private PlaylistConverter playlistConverter;
	@Autowired
	private PlaylistRepository playlistRepository;
	@Autowired
	private UserConverter userConverter;
	
	
	public List<PlaylistDTO> getAllByUser(UserDTO user){
		return playlistConverter.toDTOList(playlistRepository.findAllByUser(userConverter.toEntity(user)));
	}
	
	

}
