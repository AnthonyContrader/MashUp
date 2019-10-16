package it.contrader.view.playlist;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PlaylistUpdateView extends AbstractView{
	private Request request;
	private int id;
	private String name;
	private String genre;
	private final String mode = "UPDATE";
	
	public PlaylistUpdateView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
		System.out.println("Modifica andata a buon fine.\n");
		MainDispatcher.getInstance().callView("Playlist", null);
		}
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id della playlist:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome della playlist:");
			name = getInput();
			System.out.println("Inserisci genere della playlist:");
			genre = getInput();
		} catch (Exception e) {

		}
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("genre", genre);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Playlist", "doControl", request);
	}

	
	

}