package sgbd.demo.business.mapper;

import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.Service_activationDTO;
import sgbd.demo.data_access.entity.Service_activation;

@Component
public class Service_activationMapper implements Mapper<Service_activationDTO, Service_activation>{
    @Override
    public Service_activationDTO toDTO(Service_activation service_activation) {
        if(service_activation==null)
            return null;

        return new Service_activationDTO(
                service_activation.getId(),
                service_activation.getTranscontacts(),
                service_activation.getTranscredit(),
                service_activation.getActivationsim()
        );
    }

    @Override
    public Service_activation toEntity(Service_activationDTO service_activationDTO) {
        if(service_activationDTO==null)
            return null;
        Service_activation service_activation = new Service_activation();
        service_activation.setId(service_activationDTO.getId());
        service_activation.setTranscontacts(service_activationDTO.getTranscontacts());
        service_activation.setTranscredit(service_activationDTO.getTranscredit());
        service_activation.setActivationsim(service_activationDTO.getActivationsim());
        return service_activation;
    }
}
