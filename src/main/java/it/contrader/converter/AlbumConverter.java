package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.AlbumDTO;
import it.contrader.model.Album;

/**
 * 
 * @author Vittorio
 * 
 * Implementando questa l'interfaccia converter la classe AlbumConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class AlbumConverter  implements Converter<Album, AlbumDTO> {
	
	/**
	 * Crea un oggetto di tipo AlbumDTO e lo riempie con i campi del parametro album di tipo Album.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public AlbumDTO toDTO(Album album) {
		AlbumDTO albumDTO = new AlbumDTO(album.getId(), album.getName(), album.getAuthor(), album.getYear());
		return albumDTO;
	}

	/**
	 * Crea un oggetto di tipo Album e lo riempie con i campi del parametro album di tipo AlbumDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Album toEntity(AlbumDTO albumDTO) {
		Album album = new Album(albumDTO.getId(), albumDTO.getName(), albumDTO.getAuthor(), albumDTO.getYear());
		return album;
	}
	
	/**
	 * Metodo per convertire le liste di Album.
	 */
	@Override
	public List<AlbumDTO> toDTOList(List<Album> albumList) {
		//Crea una lista vuota.
		List<AlbumDTO> albumDTOList = new ArrayList<AlbumDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Album album : albumList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			albumDTOList.add(toDTO(album));
		}
		return albumDTOList;
	}
	
}
