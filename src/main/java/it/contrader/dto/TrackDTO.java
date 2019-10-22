package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "Track".
 */
public class TrackDTO {
	
	private int id;

	private String title;
	
	private String author;
	


	
	public TrackDTO() {
		
	}

	public TrackDTO (String title, String author) {
		this.title = title;
		this.author = author;
		
	}

	public TrackDTO (int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	


	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return  id + "\t"  + title +"\t\t" +   author ;
	}
}
