package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrackDTO {

	private Long id;

	private String title;

	private String author;
	
	private AlbumDTO albumDTO;

}
