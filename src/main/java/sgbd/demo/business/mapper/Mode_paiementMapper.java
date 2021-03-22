package sgbd.demo.business.mapper;

import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.Mode_paiementDTO;
import sgbd.demo.data_access.entity.Mode_paiement;

@Component
public class Mode_paiementMapper implements Mapper<Mode_paiementDTO, Mode_paiement>{
    @Override
    public Mode_paiementDTO toDTO(Mode_paiement mode_paiement) {
        if(mode_paiement==null)
            return null;

        return new Mode_paiementDTO(
                mode_paiement.getId(),
                mode_paiement.getNom()
        );
    }

    @Override
    public Mode_paiement toEntity(Mode_paiementDTO mode_paiementDTO) {
        if(mode_paiementDTO==null)
            return null;

        Mode_paiement mode_paiement = new Mode_paiement();
        mode_paiement.setId(mode_paiementDTO.getId());
        mode_paiement.setNom(mode_paiementDTO.getNom());
        return mode_paiement;
    }
}
