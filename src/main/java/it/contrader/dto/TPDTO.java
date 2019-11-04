package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TPDTO{
	
	private Long id;
	
	private TrackDTO trackDTO;
	
	private PlaylistDTO playlistDTO;
}