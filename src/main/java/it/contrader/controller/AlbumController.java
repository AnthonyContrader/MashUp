package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.AlbumDTO;
import it.contrader.service.AlbumService;


@Controller
@RequestMapping("/album")
public class AlbumController{
	
	@Autowired 
	private AlbumService service;
	
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "albumfolder/albums";
	}
	
	
	@GetMapping("/delete")
	public String delete (HttpServletRequest request, @RequestParam("id") Long id ) {
		service.delete(id);
		setAll(request);
		return "albumfolder/albums";
	}
	
	@GetMapping("/preupdate")
	public String preUpdate (HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "albumfolder/updatealbum";
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id")Long id,
			@RequestParam("title") String title, @RequestParam("author") String author,
			@RequestParam("year") String year) {
		AlbumDTO dto = new AlbumDTO();
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setYear(year);
		service.insert(dto);
		setAll(request);
		return "albumfolder/albums";
		
	}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("title") String title,
			@RequestParam("author") String author, @RequestParam("year") String year) {
		AlbumDTO dto = new AlbumDTO();
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setYear(year);
		service.insert(dto);
		setAll(request);
		return "albumfolder/albums";
	}
	
	@GetMapping("/read")
	public String read (HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));	
		return "albumfolder/readalbum";
	
	}
	
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
	
}