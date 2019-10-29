package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TrackDTO;

import it.contrader.model.Track;

@Component
public class TrackConverter extends AbstractConverter<Track, TrackDTO> {

	@Override
	public Track toEntity(TrackDTO trackDTO) {
		Track track = null;
		if (trackDTO != null) {
			track = new Track(trackDTO.getId(), trackDTO.getTitle(), trackDTO.getAuthor());
		}
		return track;
	}

	@Override
	public TrackDTO toDTO(Track track) {
		TrackDTO trackDTO = null;
		if(track != null) {
			trackDTO = new TrackDTO(track.getId(), track.getTitle(), track.getAuthor());
		}
		return trackDTO;
	}
}