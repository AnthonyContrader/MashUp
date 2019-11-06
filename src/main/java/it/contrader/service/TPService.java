package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.PlaylistConverter;
import it.contrader.converter.TPConverter;
import it.contrader.dao.TPRepository;
import it.contrader.dto.PlaylistDTO;
import it.contrader.dto.TPDTO;
import it.contrader.model.TP;


@Service
public class TPService extends AbstractService<TP, TPDTO>{
	
	@Autowired
	private PlaylistConverter converter;
	@Autowired
	private TPRepository repository;
	@Autowired
	private TPConverter tpconverter;
	
	public List<TPDTO> getByPlaylist(PlaylistDTO p){
		return tpconverter.toDTOList(repository.findByPlaylist(converter.toEntity(p)));
	}
	
	

}