package it.contrader.view.track;

import it.contrader.controller.Request;
import it.contrader.dto.TrackDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TrackReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public TrackReadView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			TrackDTO track = (TrackDTO) request.get("track");
			System.out.println(track);
			MainDispatcher.getInstance().callView("Track", null);
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del brano:");
		id = Integer.parseInt(getInput());
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Track", "doControl", request);
	}

}