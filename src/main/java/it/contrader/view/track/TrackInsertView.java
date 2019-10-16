package it.contrader.view.track;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TrackInsertView extends AbstractView{
	private Request request;

	private String title;
	private String author;
	private final String mode = "INSERT";

	public TrackInsertView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Track", null);
		}
	}
	
	/**
	 * Chiede all'utente di inserire gli attributi del brano da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci titolo del brano:");
			title = getInput();
			System.out.println("Inserisci autore del brano:");
			author = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("title", title);
		request.put("author", author);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Track", "doControl", request);
	}
}