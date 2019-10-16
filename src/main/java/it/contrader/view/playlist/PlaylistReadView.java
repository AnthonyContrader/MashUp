package it.contrader.view.playlist;

import it.contrader.controller.Request;
import it.contrader.dto.PlaylistDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;



public class PlaylistReadView extends AbstractView{
	
	private int id;
	private Request request;
	private final String mode = "READ";
	
	public PlaylistReadView() {
	
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			PlaylistDTO playlist = (PlaylistDTO) request.get("playlist");
			System.out.println(playlist);
			MainDispatcher.getInstance().callView("Playlist", null);
		}
	
	}
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'utente:");
		id = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Playlist", "doControl", request);
	}
}