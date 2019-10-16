package it.contrader.dto;

public class PlaylistDTO{
	
	private int id;
	
	private String name;
	
	private String genre;
	
	
public PlaylistDTO(){
		
	}


	public PlaylistDTO(int id, String name, String genre) {
	this.id = id;
	this.name = name;
	this.genre = genre;
}



	public PlaylistDTO(String name, String genre) {
	this.name = name;
	this.genre = genre;
}


	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return id + "\t"  + name +"\t\t" + genre;
	}
	
}
