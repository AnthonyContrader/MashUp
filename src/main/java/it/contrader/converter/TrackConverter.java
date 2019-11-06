package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.TrackDTO;

import it.contrader.model.Track;

@Component
public class TrackConverter extends AbstractConverter<Track, TrackDTO> {
	
	@Autowired
	private AlbumConverter albumConverter;

	@Override
	public Track toEntity(TrackDTO trackDTO) {
		Track track = null;
		if (trackDTO != null) {
			track = new Track(trackDTO.getId(), trackDTO.getTitle(), trackDTO.getAuthor(), albumConverter.toEntity(trackDTO.getAlbumDTO()));
		}
		return track;
	}

	@Override
	public TrackDTO toDTO(Track track) {
		TrackDTO trackDTO = null;
		if(track != null) {
			trackDTO = new TrackDTO(track.getId(), track.getTitle(), track.getAuthor(), albumConverter.toDTO(track.getAlbum()));
		}
		return trackDTO;
	}
}