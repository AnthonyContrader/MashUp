package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.PlaylistDTO;
import it.contrader.model.Playlist;

@Component
public class PlaylistConverter extends AbstractConverter<Playlist, PlaylistDTO> {

	@Override
	public Playlist toEntity(PlaylistDTO playlistDTO) {
		Playlist playlist = null;
		if(playlistDTO != null) {
			playlist  = new Playlist(playlistDTO.getId(), playlistDTO.getName(), playlistDTO.getGenre());
		}
		return playlist;
	}

	@Override
	public PlaylistDTO toDTO(Playlist playlist) {
		PlaylistDTO playlistDTO = null;
		if(playlist != null) {
			playlistDTO = new PlaylistDTO(playlist.getId(), playlist.getName(), playlist.getGenre());
		}
		return playlistDTO;
		
	}
}