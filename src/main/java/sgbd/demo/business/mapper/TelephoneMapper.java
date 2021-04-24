package sgbd.demo.business.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.SimDTO;
import sgbd.demo.business.dto.TelephoneDTO;
import sgbd.demo.data_access.entity.Sim;
import sgbd.demo.data_access.entity.Telephone;
import sgbd.demo.data_access.repository.SimRepository;

import java.util.stream.Collectors;

@Component
public class TelephoneMapper implements Mapper<TelephoneDTO, Telephone>{

    @Autowired
    private Mapper<SimDTO, Sim> simMapper;
    @Autowired
    private SimRepository simRepository;

    @Override
    public TelephoneDTO toDTO(Telephone telephone) {
        if(telephone==null)
            return null;

        return new TelephoneDTO(
                telephone.getId(),
                telephone.getNtelephone(),
                simMapper.toDTO((telephone.getSim()))
        );
    }

    @Override
    public Telephone toEntity(TelephoneDTO telephoneDTO) {
        if(telephoneDTO==null)
            return null;

        Telephone telephone = new Telephone();
        telephone.setId(telephoneDTO.getId());
        telephone.setNtelephone(telephoneDTO.getNtelephone());
        telephone.setSim(simMapper.toEntity(telephoneDTO.getSim()));
        return telephone;
    }
}
