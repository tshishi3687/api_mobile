package sgbd.demo.business.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.AbonnementDTO;
import sgbd.demo.business.dto.ContratDTO;
import sgbd.demo.business.dto.CycleDTO;
import sgbd.demo.business.dto.PersonneAdresseDTO;
import sgbd.demo.data_access.entity.Abonnement;
import sgbd.demo.data_access.entity.Contrat;
import sgbd.demo.data_access.entity.Cycle_paiement;
import sgbd.demo.data_access.entity.Personne;
import sgbd.demo.data_access.repository.Abonnementrepository;
import sgbd.demo.data_access.repository.PersonnneRepository;

@Component
public class ContratMapper implements Mapper<ContratDTO, Contrat>{

    @Autowired
    private Mapper<AbonnementDTO, Abonnement> abonnementMapper;
    @Autowired
    private Mapper<CycleDTO, Cycle_paiement> cycleMapper;
    @Autowired
    private Mapper<PersonneAdresseDTO, Personne> personneMapper;
    @Autowired
    private Abonnementrepository abonnementRepository;
    @Autowired
    private PersonnneRepository personnneRepository;

    @Override
    public ContratDTO toDTO(Contrat contrat) {
        if(contrat==null)
            return null;
        return new ContratDTO(
                contrat.getId(),
                contrat.getDatesignature(),
                contrat.getDatedebut(),
                contrat.getDatefin(),
                abonnementMapper.toDTO(contrat.getAbonnement()),
                cycleMapper.toDTO(contrat.getFacturation())
        );
    }

    @Override
    public Contrat toEntity(ContratDTO contratDTO) {
        if(contratDTO==null)
            return null;
        Contrat contrat = new Contrat();
        contrat.setId(contratDTO.getId());
        contrat.setDatesignature(contratDTO.getDatesignature());
        contrat.setDatedebut(contratDTO.getDatedebut());
        contrat.setDatefin(contratDTO.getDatefin());
        contrat.setAbonnement(abonnementMapper.toEntity(contratDTO.getAbonnement()));
        contrat.setFacturation(cycleMapper.toEntity(contratDTO.getFacturation()));
        return contrat;
    }
}
