package it.contrader.controller;

import java.util.List;
import it.contrader.dto.PlaylistDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.PlaylistService;


public class PlaylistController implements Controller {
	
	private static String sub_package = "playlist.";
	
	private PlaylistService playlistService;
	
	public PlaylistController() {
		this.playlistService = new PlaylistService();
	
		}
	
	public void doControl (Request request) {
		
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");
		
		int id;
		String name;
		String genre;
		
		switch (mode) {
		
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			PlaylistDTO playlistDTO = playlistService.read(id);
			request.put("playlist", playlistDTO);
			MainDispatcher.getInstance().callView(sub_package + "PlaylistRead", request);
			break;
		
		case "INSERT":
			name = request.get("name").toString();
			genre = request.get("genre").toString();
			
			PlaylistDTO playlisttoinsert = new PlaylistDTO (name,genre);
			playlistService.insert(playlisttoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PlaylistInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			playlistService.delete(id);
			request = new Request();
			request.put("mode","mode");
			MainDispatcher.getInstance().callView(sub_package + "PlaylistDelete",  request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			name = request.get("name").toString();
			genre = request.get("genre").toString();
			PlaylistDTO playlisttoupdate = new PlaylistDTO (name, genre);
			playlisttoupdate.setId(id);
			playlistService.update(playlisttoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "PlaylistUpdate", request);
			break;
			
		case "PLAYLISTLIST":
			List<PlaylistDTO> playlistsDTO = playlistService.getAll();
			request.put("playlists", playlistsDTO);
			MainDispatcher.getInstance().callView("Playlist", request);	
			break;
			
		case "GETCHOICE":
			
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "PlaylistRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "PlaylistInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "PlaylistUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "PlaylistDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
				
			}
			
		}
		
}
	
	
