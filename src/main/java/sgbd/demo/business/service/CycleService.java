package sgbd.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgbd.demo.business.dto.AdresseDTO;
import sgbd.demo.business.dto.CycleDTO;
import sgbd.demo.business.dto.Info_bancaireDTO;
import sgbd.demo.business.dto.PersonneDTO;
import sgbd.demo.business.mapper.Mapper;
import sgbd.demo.data_access.entity.Cycle_paiement;
import sgbd.demo.data_access.entity.Info_bancaire;
import sgbd.demo.data_access.entity.Personne;
import sgbd.demo.data_access.repository.AdresseRepository;
import sgbd.demo.data_access.repository.CycleRepository;
import sgbd.demo.data_access.repository.Info_bancaireRepository;
import sgbd.demo.data_access.repository.PersonnneRepository;
import sgbd.demo.exeption.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CycleService implements CrudService<CycleDTO, Integer>{

    @Autowired
    private Mapper<CycleDTO, Cycle_paiement> cycleMapper;
    @Autowired
    private CycleRepository cycleRepository;
    @Autowired
    private Info_bancaireRepository info_bancaireRepository;
    @Autowired
    private Mapper<Info_bancaireDTO, Info_bancaire> info_bancaireMapper;
    @Autowired
    private PersonnneRepository personnneRepository;
    @Autowired
    private AdresseRepository adresseRepository;

    @Override
    public void creat(CycleDTO toDTO) throws ElementExisteExeption {
        if(cycleRepository.existsById(toDTO.getId()))
            throw new CycleExisteExeption(toDTO.getId());

        cycleRepository.save(cycleMapper.toEntity(toDTO));
    }

    @Transactional
    public void updatee(CycleDTO toDTO) throws PersonneFoundExeption {
        if(!cycleRepository.existsById(toDTO.getId()))
            throw new PersonneFoundExeption(toDTO.getId());

        Info_bancaire info = info_bancaireMapper.toEntity(toDTO.getInformation());
        adresseRepository.getById(info.getAppartient().getAdressepersonne().getId());
        personnneRepository.getById(info.getAppartient().getId());
        info_bancaireRepository.save(info);

        System.out.println(info);
        cycleRepository.updatee(info_bancaireRepository.save(info).getId(), toDTO.getId());
    }

    @Override
    public CycleDTO readOne(Integer integer) throws ElementFoundException {
        Cycle_paiement entity = cycleRepository.findById(integer)
                .orElseThrow(() -> new CycleFoundExeption(integer));
        return cycleMapper.toDTO(entity);
    }

    @Override
    public List<CycleDTO> readAll() {
        return cycleRepository.findAll()
                .stream()
                .map(cycleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(CycleDTO toUpdate) throws ElementFoundException {
        if(!cycleRepository.existsById(toUpdate.getId()))
            throw new CycleFoundExeption(toUpdate.getId());

        cycleRepository.save(cycleMapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementFoundException {
        if(!cycleRepository.existsById(toDelete))
            throw new CycleFoundExeption(toDelete);

        cycleRepository.deleteById(toDelete);
    }
}
