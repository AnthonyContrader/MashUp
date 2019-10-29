package it.contrader.dto;

import java.util.List;

import it.contrader.model.Track;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AlbumDTO {
	
	private Long id;
	
	private String title;
	
	private String author;
	
	private String year;
	
	private List<Track> tracks;
	
}
