package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import it.contrader.dto.PlaylistDTO;
import it.contrader.model.Playlist;

@Component
public class PlaylistConverter extends AbstractConverter<Playlist, PlaylistDTO> {
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public Playlist toEntity(PlaylistDTO playlistDTO) {
		Playlist playlist = null;
		if(playlistDTO != null) {
			playlist  = new Playlist(playlistDTO.getId(), playlistDTO.getName(), playlistDTO.getGenre(), userConverter.toEntity(playlistDTO.getUserDTO()) );
		}
		return playlist;
	}

	@Override
	public PlaylistDTO toDTO(Playlist playlist) {
		PlaylistDTO playlistDTO = null;
		if(playlist != null) {
			playlistDTO = new PlaylistDTO(playlist.getId(), playlist.getName(), playlist.getGenre(), userConverter.toDTO(playlist.getUser()));
		}
		return playlistDTO;
		
	}
}