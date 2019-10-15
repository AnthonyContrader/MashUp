package it.contrader.service;


import java.util.List;


import it.contrader.converter.TrackConverter;
import it.contrader.dao.TrackDAO;
import it.contrader.dto.TrackDTO;

/**
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class TrackService {
	
	private TrackDAO trackDAO;
	private TrackConverter trackConverter;
	
	//Istanzio DAO  e Converter specifici.
	public TrackService(){
		this.trackDAO = new TrackDAO();
		this.trackConverter = new TrackConverter();
	}
	

	public List<TrackDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return trackConverter.toDTOList(trackDAO.getAll());
	}


	public TrackDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return trackConverter.toDTO(trackDAO.read(id));
	}


	public boolean insert(TrackDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return trackDAO.insert(trackConverter.toEntity(dto));
	}


	public boolean update(TrackDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return trackDAO.update(trackConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo metodo chiama direttamente il DAO
		return trackDAO.delete(id);
	}
	

}
