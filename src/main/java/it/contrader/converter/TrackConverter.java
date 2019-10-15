package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TrackDTO;
import it.contrader.model.Track;

public class TrackConverter   {
	
	/**
	 * Crea un oggetto di tipo TrackDTO e lo riempie con i campi del parametro user di tipo Track.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public TrackDTO toDTO(Track track) {
		TrackDTO trackDTO = new TrackDTO(track.getId(), track.getTitle(), track.getAuthor());
		return trackDTO;
	}

	/**
	 * Crea un oggetto di tipo Track e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Track toEntity(TrackDTO trackDTO) {
		Track track = new Track(trackDTO.getId(), trackDTO.getTitle(), trackDTO.getAuthor());
		return track;
	}
	
	/**
	 * Metodo per convertire le liste di Track.
	 */
	public List<TrackDTO> toDTOList(List<Track> trackList) {
		//Crea una lista vuota.
		List<TrackDTO> trackDTOList = new ArrayList<TrackDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Track track : trackList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge alla lista di DTO
			trackDTOList.add(toDTO(track));
		}
		return trackDTOList;
	}

	
	
}