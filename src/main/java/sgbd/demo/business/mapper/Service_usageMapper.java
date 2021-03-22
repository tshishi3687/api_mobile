package sgbd.demo.business.mapper;

import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.Service_usageDTO;
import sgbd.demo.data_access.entity.Service_usage;

@Component
public class Service_usageMapper implements Mapper<Service_usageDTO, Service_usage>{
    @Override
    public Service_usageDTO toDTO(Service_usage service_usage) {
        if(service_usage==null)
            return null;

        return new Service_usageDTO(
                service_usage.getId(),
                service_usage.getCreditappelle(),
                service_usage.getCreditdata(),
                service_usage.getCreditsms(),
                service_usage.getCreditmms(),
                service_usage.getCredititinerance()
        );
    }

    @Override
    public Service_usage toEntity(Service_usageDTO service_usageDTO) {
        if(service_usageDTO==null)
            return null;

        Service_usage service_usage = new Service_usage();
        service_usage.setId(service_usageDTO.getId());
        service_usage.setCreditappelle(service_usageDTO.getCreditappelle());
        service_usage.setCreditdata(service_usageDTO.getCreditdata());
        service_usage.setCreditsms(service_usageDTO.getCreditsms());
        service_usage.setCreditmms(service_usageDTO.getCreditmms());
        service_usage.setCredititinerance(service_usageDTO.getCredititinerance());
        return service_usage;
    }
}
