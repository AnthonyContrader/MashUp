package it.contrader.dto;

public class AlbumDTO {
	
	private int id;
	 
	private String name;
	
	private String author;
	
	private String year;

	
	public AlbumDTO() {
		
	}
	
	public AlbumDTO(int id, String name, String author, String year) {
		
		this.id = id;
		this.author = author;
		this.name = name;
		this.year = year;
	}
	
	public AlbumDTO(String name, String author, String year) {
		
		this.author = author;
		this.name = name;
		this.year = year;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getYear() {
		return this.year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
}