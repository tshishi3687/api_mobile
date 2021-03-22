package sgbd.demo.business.mapper;

import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.TelephoneDTO;
import sgbd.demo.data_access.entity.Telephone;

@Component
public class TelephoneMapper implements Mapper<TelephoneDTO, Telephone>{
    @Override
    public TelephoneDTO toDTO(Telephone telephone) {
        if(telephone==null)
            return null;

        return new TelephoneDTO(
                telephone.getId(),
                telephone.getNtelephone()
        );
    }

    @Override
    public Telephone toEntity(TelephoneDTO telephoneDTO) {
        if(telephoneDTO==null)
            return null;

        Telephone telephone = new Telephone();
        telephone.setId(telephoneDTO.getId());
        telephone.setNtelephone(telephoneDTO.getNtelephone());
        return telephone;
    }
}
