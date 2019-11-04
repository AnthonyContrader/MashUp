package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.PlaylistDTO;
import it.contrader.dto.TPDTO;
import it.contrader.dto.TrackDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Track;
import it.contrader.service.PlaylistService;
import it.contrader.service.TPService;
import it.contrader.service.TrackService;

@Controller
@RequestMapping("/tp")
public class TPController {

	@Autowired
	private PlaylistService playlistService;
	@Autowired
	private TPService tpService;

	

	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", playlistService.read(id));
		PlaylistDTO p = (PlaylistDTO) request.getSession().getAttribute("dto");
		request.getSession().setAttribute("playlisttrackslist", tpService.getByPlaylist(p));
		return "playlistfolder/guest_readplaylist";
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("album") Long id) {
		TrackDTO t = (TrackDTO) request.getSession().getAttribute("dto");
		TPDTO tp = new TPDTO();
		tp.setTrackDTO(t);
		tp.setPlaylistDTO(playlistService.read(id));
		tpService.insert(tp);
		guestPlaylists(request);
		return "trackfolder/tracks";
		
			
		
		
		/*TrackDTO dto = new TrackDTO();
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setAlbumDTO(albumService.read(idalbum));
		service.insert(dto);
		setAll(request);*/
		
	}
	
	private void guestPlaylists (HttpServletRequest request) {
		UserDTO u = (UserDTO) request.getSession().getAttribute("user");
		request.getSession().setAttribute("userplaylists", playlistService.getAllByUser_id(u.getId()));	
		
	}


}

