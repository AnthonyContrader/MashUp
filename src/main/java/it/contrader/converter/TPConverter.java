package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TPDTO;
import it.contrader.model.TP;

@Component
public class TPConverter extends AbstractConverter<TP, TPDTO>{
	
	@Override
	public TP toEntity(TPDTO tpDTO) {
		TP tp = null;
		if (tpDTO!=null) {
			tp = new TP(tpDTO.getId(), tpDTO.getIdplaylist(), tpDTO.getIdtrack());
		}
		return tp;
	}
	
	@Override
	public TPDTO toDTO(TP tp) {
		TPDTO tpDTO = null;
		if(tp!=null) {
	
			tpDTO = new TPDTO(tp.getId(), tp.getIdplaylist(), tp.getIdtrack());
		}
		return tpDTO;
	}
	
}