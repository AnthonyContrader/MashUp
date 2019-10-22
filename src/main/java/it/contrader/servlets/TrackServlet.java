package it.contrader.servlets;

import java.util.List;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.TrackDTO;

import it.contrader.service.Service;
import it.contrader.service.TrackService;








public class TrackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public TrackServlet() {}
	
	public void updateList(HttpServletRequest request) {
		
		Service<TrackDTO> service = new TrackService();
		List<TrackDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	
	
	public void service(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	Service <TrackDTO>	service = new TrackService();
	String mode = request.getParameter("mode");
	TrackDTO dto;
	int id ;
	boolean ans;
	
	
	
	switch (mode.toUpperCase()) {
	
	case "TRACKLIST":
		updateList(request);
		getServletContext().getRequestDispatcher("/track/trackmanager.jsp").forward(request, response);
		
		break;
	
	case "READ":
		id = Integer.parseInt(request.getParameter("id"));
		dto = service.read(id);
		request.setAttribute("dto",dto);
		
		if (request.getParameter("update")==null) {
			getServletContext().getRequestDispatcher("/track/readtrack.jsp").forward(request, response); 
	
		}
	
	else getServletContext().getRequestDispatcher("/track/updatetrack.jsp").forward(request, response);
	
	break;
	
	case "INSERT":
		String title = request.getParameter("title").toString();
		String author = request.getParameter("author").toString();
		dto = new TrackDTO (title,author);
		ans = service.insert(dto);
		request.setAttribute("ans", ans);
		updateList(request);
		getServletContext().getRequestDispatcher("/track/trackmanager.jsp").forward(request, response);
		break;
		
	case "UPDATE":
		title = request.getParameter("title");
		author = request.getParameter("author");
		id = Integer.parseInt(request.getParameter("id"));
		dto = new TrackDTO (id,title, author);
		ans = service.update(dto);
		updateList(request);
		getServletContext().getRequestDispatcher("/track/trackmanager.jsp").forward(request, response);
		break;

	case "DELETE":
		id = Integer.parseInt(request.getParameter("id"));
		ans = service.delete(id);
		request.setAttribute("ans", ans);
		updateList(request);
		getServletContext().getRequestDispatcher("/track/trackmanager.jsp").forward(request, response);
		break;
	}

}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

