package it.contrader.converter;

import it.contrader.model.Album;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.AlbumDTO;
import it.contrader.dto.TrackDTO;


@Component 
public class AlbumConverter extends AbstractConverter<Album, AlbumDTO>{
	
	
	
	@Override
	public Album toEntity(AlbumDTO albumDTO) {
		Album album = null;
		if(albumDTO!=null) {
			album = new Album(albumDTO.getId(), albumDTO.getTitle(), albumDTO.getAuthor(), albumDTO.getYear());
			}
		return album;
	}

	@Override
	public AlbumDTO toDTO(Album album) {
		AlbumDTO albumDTO = null;
		if (album != null) {
			albumDTO = new AlbumDTO(album.getId(), album.getTitle(), album.getAuthor(), album.getYear());
			
		}
		return albumDTO;
		
		
	}
	


}
