package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PlaylistDTO;
import it.contrader.model.Playlist;


public class PlaylistConverter{
	
	public PlaylistDTO toDTO(Playlist playlist) {
		PlaylistDTO playlistDTO = new PlaylistDTO(playlist.getId(), playlist.getName(), playlist.getGenre());
		return playlistDTO;
	}
	
	public Playlist toEntity(PlaylistDTO playlistDTO) {
		Playlist playlist = new Playlist(playlistDTO.getId(), playlistDTO.getName(), playlistDTO.getGenre());
		return playlist;
	}
	
	public List<PlaylistDTO> toDTOList(List<Playlist> playlistList){
		
		List<PlaylistDTO> playlistDTOList = new ArrayList<PlaylistDTO>();
		
		for(Playlist playlist : playlistList) {
			
			playlistDTOList.add(toDTO(playlist));
		}
		return playlistDTOList;
}
}