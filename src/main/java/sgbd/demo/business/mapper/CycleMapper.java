package sgbd.demo.business.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.CycleDTO;
import sgbd.demo.business.dto.Info_bancaireDTO;
import sgbd.demo.business.dto.Mode_paiementDTO;
import sgbd.demo.data_access.entity.Cycle_paiement;
import sgbd.demo.data_access.entity.Info_bancaire;
import sgbd.demo.data_access.entity.Mode_paiement;

@Component
public class CycleMapper implements Mapper<CycleDTO, Cycle_paiement>{

    @Autowired
    private Mapper<Mode_paiementDTO, Mode_paiement> mode_paiementMapper;
    @Autowired
    private Mapper<Info_bancaireDTO, Info_bancaire> info_bancaireMapper;
    @Override
    public CycleDTO toDTO(Cycle_paiement cycle) {
        if(cycle==null)
            return null;

        return new CycleDTO(
                cycle.getId(),
                cycle.getTempscycle(),
                mode_paiementMapper.toDTO(cycle.getModepaiement()),
                info_bancaireMapper.toDTO(cycle.getInformation())
        );
    }

    @Override
    public Cycle_paiement toEntity(CycleDTO cycleDTO) {
        if(cycleDTO==null)
            return null;

        Cycle_paiement cycle = new Cycle_paiement();
        cycle.setId(cycleDTO.getId());
        cycle.setTempscycle(cycleDTO.getTempscycle());
        cycle.setModepaiement(mode_paiementMapper.toEntity(cycleDTO.getModepaiement()));
        cycle.setInformation(info_bancaireMapper.toEntity(cycleDTO.getInformation()));
        return cycle;
    }
}
