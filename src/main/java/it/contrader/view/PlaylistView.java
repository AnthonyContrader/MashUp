package it.contrader.view;

import java.util.List;
import it.contrader.controller.Request;
import it.contrader.dto.PlaylistDTO;
import it.contrader.main.MainDispatcher;

public class PlaylistView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public PlaylistView() {
		
	}
	
	@Override
	public void showResults (Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Playlist ----------------\n");
			System.out.println("ID\tName\tGenre");
			System.out.println("----------------------------------------------------\n");
		
			@SuppressWarnings("unchecked")
			List<PlaylistDTO> playlists = (List<PlaylistDTO>)request.get("playlists");
			for (PlaylistDTO u: playlists)
				System.out.println(u);
			System.out.println();
			 
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
		
		this.choice = getInput ();
		
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice",choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Playlist", "doControl", this.request);
	}
}