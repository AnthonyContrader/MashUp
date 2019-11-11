package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PlaylistDTO;
import it.contrader.dto.TPDTO;
import it.contrader.service.TPService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tp")
public class TPController extends AbstractController<TPDTO>{
	
	@Autowired
	TPService service;
	
	@RequestMapping("/trackplaylist")
	public List<TPDTO> getTrackPlaylist (@RequestBody PlaylistDTO playlistDTO){
		
		return service.getByPlaylist(playlistDTO);
		
	}
	
}