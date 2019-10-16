package it.contrader.view.track;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TrackDeleteView extends AbstractView {
	private Request request;

	private int id;
	private final String mode = "DELETE";

	public TrackDeleteView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Track", null);
		}
	}
	
	@Override
	public void showOptions() {
			System.out.println("Inserisci id del brano:");
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