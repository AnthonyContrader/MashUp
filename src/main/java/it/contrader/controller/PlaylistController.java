package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PlaylistDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.PlaylistService;

@RequestMapping("/playlist")
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class PlaylistController extends AbstractController<PlaylistDTO> {
	
	@Autowired
	PlaylistService playlistService;
	
	@PostMapping(value = "/userplaylist")
	public List<PlaylistDTO> getByUser(@RequestBody UserDTO user){
		return playlistService.getAllByUser(user);
	}
	

}
