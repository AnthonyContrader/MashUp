package it.contrader.service;

import it.contrader.converter.AlbumConverter;
import it.contrader.dao.AlbumDAO;
import it.contrader.dto.AlbumDTO;
import it.contrader.model.Album;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class AlbumService extends AbstractService<Album, AlbumDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public AlbumService(){
		this.dao = new AlbumDAO();
		this.converter = new AlbumConverter();
	}
	

}
