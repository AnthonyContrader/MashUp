package it.contrader.dto;

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
	
	private UserDTO userDTO;

}
