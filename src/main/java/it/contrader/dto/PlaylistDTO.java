package it.contrader.dto;

import it.contrader.model.Playlist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlaylistDTO {

	private Long id;

	private String name;

	private String genre;

}
