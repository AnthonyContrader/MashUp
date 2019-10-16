package it.contrader.controller;

import java.util.List;

import it.contrader.dto.TrackDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.TrackService;


public class TrackController implements Controller {
	
	private static String sub_package = "track.";
	
	private TrackService trackService;
	
	public TrackController() {
		
		this.trackService = new TrackService();
		
	}
	
	@Override
	public void doControl(Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		
		
		int id;
		String title;
		String author;
		
		switch (mode) {
		
		case"READ":
			id = Integer.parseInt(request.get("id").toString());
			TrackDTO trackDTO = trackService.read(id);
			request.put("track", trackDTO);
			MainDispatcher.getInstance().callView(sub_package + "TrackRead", request);
			break;
			
		case "INSERT":
			title = request.get("title").toString();
			author = request.get("author").toString();
			
			TrackDTO tracktoinsert = new TrackDTO(title, author);
			trackService.insert(tracktoinsert);
			request = new Request();
			request.put("mode","mode");
			
			MainDispatcher.getInstance().callView(sub_package + "TrackInsert", request);
		    break;
		    
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			
			trackService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TrackDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			title = request.get("title").toString();
			author = request.get("author").toString();
			
			TrackDTO tracktoupdate = new TrackDTO(title, author);
			tracktoupdate.setId(id);
			trackService.update(tracktoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TrackUpdate", request);
			break;
			
		case "TRACKLIST":
			List<TrackDTO> tracksDTO = trackService.getAll();
			
			request.put("tracks", tracksDTO);
			MainDispatcher.getInstance().callView("Track" , request);
			break;
			
		case "GETCHOICE":
			
			switch(choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "TrackRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "TrackInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "TrackUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "TrackDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView(sub_package + "Login", null);
				break;
				
			case "B":
				MainDispatcher.getInstance().callView(sub_package + "HomeAdmin", null);
				break;
				
				default:
					MainDispatcher.getInstance().callView("Login", null);
			}
			default:
				MainDispatcher.getInstance().callView("Login", null);
		}
	}	
}