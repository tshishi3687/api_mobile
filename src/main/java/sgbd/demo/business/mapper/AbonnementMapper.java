package sgbd.demo.business.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.AbonnementDTO;
import sgbd.demo.business.dto.Service_activationDTO;
import sgbd.demo.business.dto.Service_usageDTO;
import sgbd.demo.business.dto.TelephoneDTO;
import sgbd.demo.data_access.entity.Abonnement;
import sgbd.demo.data_access.entity.Service_activation;
import sgbd.demo.data_access.entity.Service_usage;
import sgbd.demo.data_access.entity.Telephone;
import sgbd.demo.data_access.repository.Service_activationRepository;
import sgbd.demo.data_access.repository.Service_usageRepository;
import sgbd.demo.data_access.repository.TelephoneRepository;

@Component
public class AbonnementMapper implements Mapper<AbonnementDTO, Abonnement>{

    @Autowired
    private Mapper<TelephoneDTO, Telephone> telephoneMapper;
    @Autowired
    private Mapper<Service_usageDTO, Service_usage> service_usageMapper;
    @Autowired
    private Mapper<Service_activationDTO, Service_activation> service_activationMapper;

    @Override
    public AbonnementDTO toDTO(Abonnement abonnement) {
        if(abonnement==null)
            return null;

        return new AbonnementDTO(
                abonnement.getId(),
                telephoneMapper.toDTO(abonnement.getMsisdn()),
                service_usageMapper.toDTO(abonnement.getServiceusage()),
                service_activationMapper.toDTO(abonnement.getServiceactivation()),
                abonnement.getDateactivation()
        );
    }

    @Override
    public Abonnement toEntity(AbonnementDTO abonnementDTO) {
        if(abonnementDTO==null)
            return null;

        Abonnement abonnement = new Abonnement();
                abonnement.setId(abonnementDTO.getId());
                abonnement.setMsisdn(telephoneMapper.toEntity(abonnementDTO.getMsisdn()));
                abonnement.setServiceusage(service_usageMapper.toEntity(abonnementDTO.getServiceusage()));
                abonnement.setServiceactivation(service_activationMapper.toEntity(abonnementDTO.getServiceactivation()));
                abonnement.setDateactivation(abonnementDTO.getDateactivation());
        return abonnement;
    }
}
