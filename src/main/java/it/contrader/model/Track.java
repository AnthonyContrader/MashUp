package it.contrader.model;


public class Track{
	
	
	private int id;
	private String title;
	private String author;

	public Track() {}
	
	
	public Track(String title, String author) {
		
		this.title = title;
		this.author= author;
	}
	
	public Track (int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author= author;
		
		
	}
	
	
	
	public int getId() {
		return this.id;
	}
	
	public void  setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return this.title;
		
		
	}
	
	public void setTitle(String title) {
		
		this.title= title;
	}
	
	public String getAuthor() {
		return this.author;
		
		
	}
	
	public void setAuthor(String author) {
		
		this.author= author;
	}
	
	
	public String toString() {
		return id + "\t" + title +"\t\t" + author ;
		
	}
	
	//Metodo per il confronto degli oggetti
	@Override
	
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj==null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Track other = (Track) obj;
		if(id != other.id)
			return false;
		if(title == null) {
			if(other.title != null)
				return false;
	} 
	else if (!title.equals(other.title))
		return false;
	
	if (author == null) {
		if(other.author != null)
			return false;
}
	else if(!author.equals(other.author))
		return false;
	
	return true;
	}
}