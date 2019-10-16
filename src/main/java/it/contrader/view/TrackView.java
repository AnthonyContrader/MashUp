package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.TrackDTO;
import it.contrader.main.MainDispatcher;


public class TrackView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public TrackView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("\n------------------- Gestione tracce ----------------\n");
			System.out.println("ID\tTitle\tAuthor\t");
			System.out.println("----------------------------------------------------\n");
		
			@SuppressWarnings("unchecked")
			List<TrackDTO> tracks = (List<TrackDTO>) request.get("users");
			for (TrackDTO t: tracks) 
				System.out.println(t);
			System.out.println();
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
	
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Track", "doControl", this.request);
	}
}