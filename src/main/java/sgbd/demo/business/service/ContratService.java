package sgbd.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sgbd.demo.business.dto.ContratDTO;
import sgbd.demo.business.dto.PersonneDTO;
import sgbd.demo.business.mapper.Mapper;
import sgbd.demo.data_access.entity.Contrat;
import sgbd.demo.data_access.repository.*;
import sgbd.demo.exeption.ContratExisteexeption;
import sgbd.demo.exeption.ContratFoundExeption;
import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratService implements CrudService<ContratDTO, Integer>{

    @Autowired
    private Mapper<ContratDTO, Contrat> contratMapper;
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private Mode_paiementRepository mode_paiementRepository;
    @Autowired
    private CycleRepository cycleRepository;
    @Autowired
    private SimRepository simRepository;
    @Autowired
    private TelephoneRepository telephoneRepository;
    @Autowired
    private Service_usageRepository service_usageRepository;
    @Autowired
    private Service_activationRepository service_activationRepository;
    @Autowired
    private Abonnementrepository abonnementrepository;

    @Override
    public void creat(ContratDTO toDTO) throws ElementExisteExeption {
        if(contratRepository.existsById(toDTO.getId()))
            throw new ContratExisteexeption(toDTO.getId());

        Contrat entity = contratMapper.toEntity(toDTO);
        mode_paiementRepository.save(entity.getFacturation().getModepaiement());
        cycleRepository.save(entity.getFacturation());
        simRepository.save(entity.getAbonnement().getMsisdn().getSim());
        telephoneRepository.save(entity.getAbonnement().getMsisdn());
        service_usageRepository.save(entity.getAbonnement().getServiceusage());
        service_activationRepository.save(entity.getAbonnement().getServiceactivation());
        abonnementrepository.save(entity.getAbonnement());
        contratRepository.save(entity);
    }

    @Override
    public ContratDTO readOne(Integer integer) throws ElementFoundException {
        Contrat entity = contratRepository.findById(integer)
                .orElseThrow(() -> new ContratFoundExeption(integer));
        return contratMapper.toDTO(entity);
    }

    @Transactional
    public List<ContratDTO> selonPers(PersonneDTO personneDTO){
        return contratRepository.findByFacturation_Information_Appartient_Nregistrenational(personneDTO.getNregistrenational())
                .stream()
                .map(contratMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContratDTO> readAll() {
        return contratRepository.findAll()
                .stream()
                .map(contratMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(ContratDTO toUpdate) throws ElementFoundException {
        if (!contratRepository.existsById(toUpdate.getId()))
            throw new ContratFoundExeption(toUpdate.getId());

        contratRepository.save(contratMapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementFoundException {
        if (!contratRepository.existsById(toDelete))
            throw new ContratFoundExeption(toDelete);

        contratRepository.deleteById(toDelete);
    }
}
