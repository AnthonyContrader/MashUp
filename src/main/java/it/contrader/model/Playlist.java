package it.contrader.model;

/*definisco gli attributi di Playlist*/

public class Playlist{
	
	private int id;
	
	private String name;
	
	private String genre;
	
	
public Playlist(){
		
	}


	public Playlist(int id, String name, String genre) {
	this.id = id;
	this.name = name;
	this.genre = genre;
}



	public Playlist(String name, String genre) {
	this.name = name;
	this.genre = genre;
}

/*definisco i metodi di Plylist*/
	
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


	public String getGenre() {
		return this.genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		return  id + "\t"  + name +"\t\t" + genre;
	}


	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlist other = (Playlist) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if(other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (genre == null) {
			if(other.genre != null)
				return false;
			} else if (!genre.equals(other.genre))
				return false;
		return true;
		
}

	
}


