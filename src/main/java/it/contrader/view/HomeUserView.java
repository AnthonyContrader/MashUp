package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	String choice;
	
	private Request request;
	
	/*
	 * Se la request non è nulla, mostra il messaggio di benvenuto
	 * 
	 */
	

	//@Override
	public void showResults(Request request) {
		if(request != null)
		System.out.println("\n----Benvenuto in MUSHUP PROJECT.-----"+request.get("username").toString() + "\n");

	}

	/*
	 * Chiede all'utente di effettuare una scelta
	 */
	
	//@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("Seleziona cosa vuoi gestire:");
		System.out.println("[B]rano	  [P]laylist   [E]sci");
		choice = this.getInput();

	}

	//@Overrid
	public void submit() {

		request = new Request();
		
		switch (choice) {

		case "b":
			this.request.put("mode", "TRACKLIST");
			MainDispatcher.getInstance().callAction("Track", "doControl", request);
			break;
			
		case "p":
			this.request.put("mode", "PLAYLISTLIST");
			MainDispatcher.getInstance().callAction("Playlist", "doControl", request);
			break;
			
		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		default:
			request.put("choice", choice);
			MainDispatcher.getInstance().callAction("Login", "doControl", request);
		}
	}

}
