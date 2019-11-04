package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "track")
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column
	private String title;

	private String author;
	
	/*@ManyToOne
	@JoinColumn(name = "idplaylist", referencedColumnName = "id")
	private Playlist playlist;*/
	
	
	/*
relazione tra traccia e album
	 */
	@ManyToOne
	@JoinColumn(name = "id_album", referencedColumnName = "id")
	private Album album;
	
	

}
