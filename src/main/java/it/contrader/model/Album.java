package it.contrader.model;

public class Album {
	
	private int id;
	 
	private String name;
	
	private String author;
	
	private String year;

	
	public Album() {
		
	}
	
	public Album(int id, String name, String author, String year) {
		
		this.id = id;
		this.author = author;
		this.name = name;
		this.year = year;
	}
	
	public Album(String name, String author, String year) {
		
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
	
	@Override
	public String toString() {
		return id + "\t" + name + "\t\t" +  author + "\t\t" + year;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) 
			return true;
		if(obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if(other.name == null)
				return false;
		} else if(!name.equals(other.name))
			return false;
		if(author == null) {
			if(other.author == null)
				return false;
		} else if(!author.equals(other.author))
			return false;
		return true;
	 
	}
	
}
