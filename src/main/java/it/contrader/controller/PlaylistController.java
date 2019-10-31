package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.PlaylistDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.PlaylistService;
import it.contrader.service.UserService;

@Controller
@RequestMapping("playlist")
public class PlaylistController {

	@Autowired
	private PlaylistService service;
	@Autowired
	private UserService userService;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		/* if (utente)
		 else... 
		 */
		setAll(request);
		return "playlistfolder/playlists";
	}
	
	@GetMapping("/getguestplaylist")
	public String getguestplaylist(HttpServletRequest request) {
		UserDTO u = (UserDTO) request.getSession().getAttribute("user");
		request.getSession().setAttribute("userplaylists", service.getAllByUser_id(u.getId()));
		return "playlistfolder/guest_playlists";
		
		
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
			@RequestParam("genre") String genre, @RequestParam("iduser") Long iduser) {
		PlaylistDTO dto = new PlaylistDTO();
		dto.setName(name);
		dto.setGenre(genre);
		dto.setUserDTO(userService.read(iduser));   
		service.insert(dto);
		UserDTO u = (UserDTO) request.getSession().getAttribute("user");
		request.getSession().setAttribute("userplaylists", service.getAllByUser_id(u.getId()));		
		return "playlistfolder/guest_playlists";
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
