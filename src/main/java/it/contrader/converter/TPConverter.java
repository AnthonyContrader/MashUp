package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.TPDTO;
import it.contrader.model.TP;

@Component
public class TPConverter extends AbstractConverter<TP, TPDTO>{
	
	@Autowired
	private TrackConverter trackConverter;
	
	@Autowired
	private PlaylistConverter playlistConverter;
	
	@Override
	public TP toEntity(TPDTO tpDTO) {
		TP tp = null;
		if (tpDTO!=null) {
			tp = new TP(tpDTO.getId(), trackConverter.toEntity(tpDTO.getTrackDTO()), playlistConverter.toEntity(tpDTO.getPlaylistDTO()));
		}
		return tp;
	}
	
	@Override
	public TPDTO toDTO(TP tp) {
		TPDTO tpDTO = null;
		if(tp!=null) {
	
			tpDTO = new TPDTO(tp.getId(), trackConverter.toDTO(tp.getTrack()), playlistConverter.toDTO(tp.getPlaylist()));
		}
		return tpDTO;
	}
	
}