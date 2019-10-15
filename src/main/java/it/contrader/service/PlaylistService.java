package it.contrader.service;

import java.util.List;
import it.contrader.converter.PlaylistConverter;
import it.contrader.dao.PlaylistDAO;
import it.contrader.dto.PlaylistDTO;

public class PlaylistService {
	
	private PlaylistDAO playlistDAO;
	private PlaylistConverter playlistConverter;
	
	//Istanzio DAO  e Converter specifici.
	public PlaylistService(){
		this.playlistDAO = new PlaylistDAO();
		this.playlistConverter = new PlaylistConverter();
	}
	

	public List<PlaylistDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return playlistConverter.toDTOList(playlistDAO.getAll());
	}


	public PlaylistDTO read(int id) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return playlistConverter.toDTO(playlistDAO.read(id));
	}


	public boolean insert(PlaylistDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return playlistDAO.insert(playlistConverter.toEntity(dto));
	}


	public boolean update(PlaylistDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return playlistDAO.update(playlistConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return playlistDAO.delete(id);
	}
	

}
