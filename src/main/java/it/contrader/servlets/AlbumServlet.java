package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.AlbumDTO;
import it.contrader.service.Service;
import it.contrader.service.AlbumService;


public class AlbumServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public AlbumServlet() {
		
	}
	
	public void updateList(HttpServletRequest request) {
		Service<AlbumDTO> service = new AlbumService();
		List<AlbumDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<AlbumDTO> service = new AlbumService();
		String mode = request.getParameter("mode");
		AlbumDTO dto;
		int id;
		boolean ans;
		
		switch(mode.toUpperCase()) {
		
		case "ALBUMLIST":
			updateList(request);
			if(request.getParameter("type").equals("user"))
			getServletContext().getRequestDispatcher("/album/useralbummanager.jsp").forward(request, response);
			else
			getServletContext().getRequestDispatcher("/album/albummanager.jsp").forward(request, response);
	        break;
	        
	        
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if(request.getParameter("update") == null) {
				if(request.getParameter("type").equals("user"))
				getServletContext().getRequestDispatcher("/album/userreadalbum.jsp").forward(request, response);
				else
					getServletContext().getRequestDispatcher("/album/readalbum.jsp").forward(request, response);
			}
			else
				getServletContext().getRequestDispatcher("/album/updatealbum.jsp").forward(request, response);
			
			break;
			
		case "INSERT":
			String name = request.getParameter("name").toString();
			String author = request.getParameter("author").toString();
			String year = request.getParameter("year").toString();
			dto = new AlbumDTO(name,author,year);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/album/albummanager.jsp").forward(request, response);
			
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			author = request.getParameter("author");
			year = request.getParameter("year");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new AlbumDTO (id, name, author, year);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/album/albummanager.jsp").forward(request, response);
			
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/album/albummanager.jsp").forward(request, response);
			
			break;
		}
	}	
}