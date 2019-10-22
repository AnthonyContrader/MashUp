package it.contrader.service;

import it.contrader.converter.TrackConverter;
import it.contrader.dao.TrackDAO;
import it.contrader.dto.TrackDTO;
import it.contrader.model.Track;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class TrackService extends AbstractService<Track, TrackDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public TrackService(){
		this.dao = new TrackDAO();
		this.converter = new TrackConverter();
	}
	

}
