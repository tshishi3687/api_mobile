package sgbd.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgbd.demo.business.dto.AbonnementDTO;
import sgbd.demo.business.mapper.Mapper;
import sgbd.demo.data_access.entity.Abonnement;
import sgbd.demo.data_access.repository.Abonnementrepository;
import sgbd.demo.data_access.repository.Service_activationRepository;
import sgbd.demo.data_access.repository.Service_usageRepository;
import sgbd.demo.data_access.repository.TelephoneRepository;
import sgbd.demo.exeption.AbonnementExisteExeption;
import sgbd.demo.exeption.AbonnementFoundExeption;
import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbonnementService implements CrudService<AbonnementDTO, Integer>{

    @Autowired
    private TelephoneRepository telephoneRepository;
    @Autowired
    private Mapper<AbonnementDTO, Abonnement> abonnementMapper;
    @Autowired
    private Abonnementrepository abonnementRepository;
    @Autowired
    private Service_activationRepository service_activationRepository;
    @Autowired
    private Service_usageRepository service_usageRepository;


    @Override
    public void creat(AbonnementDTO toDTO) throws ElementExisteExeption {
        if(abonnementRepository.existsById(toDTO.getId()))
            throw new AbonnementExisteExeption(toDTO.getId());

        Abonnement entity = abonnementMapper.toEntity(toDTO);
        service_usageRepository.save(entity.getServiceusage());
        service_activationRepository.save(entity.getServiceactivation());
        telephoneRepository.save(entity.getMsisdn());
        abonnementRepository.save(entity);
    }
    @Transactional
    public void creatNT(AbonnementDTO toDTO) throws ElementExisteExeption {
        if(abonnementRepository.existsById(toDTO.getId()))
            throw new AbonnementExisteExeption(toDTO.getId());

        Abonnement entity = abonnementMapper.toEntity(toDTO);
        telephoneRepository.save(entity.getMsisdn());
        abonnementRepository.save(entity);
    }

    @Override
    public AbonnementDTO readOne(Integer integer) throws ElementFoundException {
        Abonnement entity = abonnementRepository.findById(integer)
                .orElseThrow(() -> new AbonnementFoundExeption(integer));

        return abonnementMapper.toDTO(entity);
    }

    @Override
    public List<AbonnementDTO> readAll() {
        return abonnementRepository.findAll().stream()
                .map(abonnementMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(AbonnementDTO toUpdate) throws ElementFoundException {
        if (!abonnementRepository.existsById(toUpdate.getId()))
            throw new AbonnementFoundExeption(toUpdate.getId());

        abonnementRepository.save(abonnementMapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementFoundException {
        if (!abonnementRepository.existsById(toDelete))
            throw new AbonnementFoundExeption(toDelete);

        abonnementRepository.deleteById(toDelete);
    }
}
