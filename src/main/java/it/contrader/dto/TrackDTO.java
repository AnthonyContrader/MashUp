package it.contrader.dto;

public class TrackDTO {
	
	private int id;
	
	private String title;
	
	private String author;
	
	

public TrackDTO() {
	
}

	public TrackDTO(String title, String author) {

		this.title = title;
		this.author = author;
	}

	public TrackDTO(int id, String title, String author) {

		this.id = id;
		this.title = title;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return + id	 +"\t"	 + title + "\t\t"	 + author;
	}
}