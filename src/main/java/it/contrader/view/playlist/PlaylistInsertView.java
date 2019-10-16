package it.contrader.view.playlist;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PlaylistInsertView extends AbstractView {
	private Request request;
	
	private String name;
	private String genre;
	private final String mode = "INSERT";
	
	public PlaylistInsertView(){
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Playlist", null);
		}
	}
	
	@Override
	public void showOptions() {
			System.out.println("Inserisci nome Playlist:");
			name = getInput();
			System.out.println("Inserisci genere Playlist:");
			genre = getInput();
		}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("genre", genre);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Playlist", "doControl", request);
	}
	
	
}