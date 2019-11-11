package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.AlbumDTO;
import it.contrader.dto.TrackDTO;
import it.contrader.service.TrackService;

@RequestMapping("/track")
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TrackController extends AbstractController<TrackDTO> {
	
	@Autowired
	TrackService service;

	@PostMapping(value = "/albumtracks")
	public List<TrackDTO> getAlbumTracks(@RequestBody AlbumDTO album){
		return service.getAllByAlbum(album);

}

}