package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.PlaylistDTO;
import it.contrader.service.PlaylistService;

@Controller
@RequestMapping("playlist")
public class PlaylistController {

	@Autowired
	private PlaylistService service;


	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "playlistfolder/playlists";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "playlistfolder/playlists";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "playlistfolder/updateplaylist";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("genre") String genre) {

		PlaylistDTO dto = new PlaylistDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setGenre(genre);
		service.update(dto);
		setAll(request);
		return "playlistfolder/playlists";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name,
			@RequestParam("genre") String genre) {
		PlaylistDTO dto = new PlaylistDTO();
		dto.setName(name);
		dto.setGenre(genre);
		service.insert(dto);
		setAll(request);
		return "playlistfolder/playlists";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "playlistfolder/readplaylist";
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
