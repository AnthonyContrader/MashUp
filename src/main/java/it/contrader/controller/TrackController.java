package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import it.contrader.dto.TrackDTO;
import it.contrader.service.TrackService;
import it.contrader.service.AlbumService;

@Controller
@RequestMapping("/track")
public class TrackController {

	@Autowired
	private TrackService service;
	@Autowired
	private AlbumService albumService;


	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		request.getSession().setAttribute("albumlist", albumService.getAll());
		return "trackfolder/tracks";
	}
	
	
	@GetMapping("/gettracks")
	public String getTracks (HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("tracklist", service.getAllByAlbum_id(id));
		return "albumfolder/readalbum";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		 service.delete(id);
		 setAll(request);
		return "trackfolder/tracks";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "trackfolder/updatetrack";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("title") String title,
			@RequestParam("author") String author) {

		TrackDTO dto = new TrackDTO();
		dto.setId(id);
		dto.setTitle(title);
		dto.setAuthor(author);
		service.update(dto);
		setAll(request);
		return "trackfolder/tracks";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("title") String title,
			@RequestParam("author") String author,@RequestParam("album") Long idalbum) {
		TrackDTO dto = new TrackDTO();
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setAlbumDTO(albumService.read(idalbum));
		service.insert(dto);
		setAll(request);
		return "trackfolder/tracks";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "trackfolder/readtrack";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
	
}
