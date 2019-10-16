package it.contrader.view.user;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TrackUpdateView extends AbstractView {
	
	private Request request;
	
	private int id;
	private String title;
	private String author;
	private final String mode = "UPDATE";
	
	public TrackUpdateView() {
		
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Track", null);
		}
	}
	
	/**
	 * Chiede all'utente di inserire gli attributi del brano da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del brano :");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci il titolo del brano:");
			title = getInput();
			System.out.println("Inserisci l'autore del brano:");
			author = getInput();
		} catch (Exception e) {

		}
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("title", title);
		request.put("author", author);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Track", "doControl", request);
	}
}