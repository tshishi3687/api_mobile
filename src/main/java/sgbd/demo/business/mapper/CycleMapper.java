package sgbd.demo.business.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.CycleDTO;
import sgbd.demo.business.dto.Mode_paiementDTO;
import sgbd.demo.data_access.entity.Cycle;
import sgbd.demo.data_access.entity.Mode_paiement;
import sgbd.demo.data_access.repository.Mode_paiementRepository;

@Component
public class CycleMapper implements Mapper<CycleDTO, Cycle>{

    @Autowired
    private Mapper<Mode_paiementDTO, Mode_paiement> mode_paiementMapper;
    @Autowired
    private Mode_paiementRepository mode_paiementRepository;
    @Override
    public CycleDTO toDTO(Cycle cycle) {
        if(cycle==null)
            return null;

        return new CycleDTO(
                cycle.getId(),
                cycle.getTempscycle(),
                mode_paiementMapper.toDTO(cycle.getModepaiement()),
                cycle.getInformation()
        );
    }

    @Override
    public Cycle toEntity(CycleDTO cycleDTO) {
        if(cycleDTO==null)
            return null;

        Cycle cycle = new Cycle();
        cycle.setId(cycleDTO.getId());
        cycle.setTempscycle(cycleDTO.getTempscycle());
        cycle.setModepaiement(mode_paiementRepository.getOne(cycleDTO.getModepaiement().getId()));
        cycle.setInformation(cycleDTO.getInformation());
        return cycle;
    }
}
