package sgbd.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgbd.demo.business.dto.Info_bancaireDTO;
import sgbd.demo.business.dto.PersonneDTO;
import sgbd.demo.business.mapper.Mapper;
import sgbd.demo.data_access.entity.Info_bancaire;
import sgbd.demo.data_access.entity.Personne;
import sgbd.demo.data_access.repository.AdresseRepository;
import sgbd.demo.data_access.repository.Info_bancaireRepository;
import sgbd.demo.data_access.repository.PersonnneRepository;
import sgbd.demo.exeption.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Info_bancaireService implements CrudService<Info_bancaireDTO, Integer>{

    @Autowired
    private Mapper<PersonneDTO, Personne> personneMapper;
    @Autowired
    private PersonnneRepository personneRepository;
    @Autowired
    private AdresseRepository adresseRepository;
    @Autowired
    private Info_bancaireRepository info_bancaireRepository;
    @Autowired
    private Mapper<Info_bancaireDTO, Info_bancaire> info_bancaireMapper;

    @Override
    public void creat(Info_bancaireDTO toDTO) throws ElementExisteExeption {
        if(info_bancaireRepository.existsById(toDTO.getId()))
            throw new Info_bancaireExisteExeption(toDTO.getId());

        info_bancaireRepository.save(info_bancaireMapper.toEntity(toDTO));
    }

    @Transactional
    public void creatnewPersonne(Info_bancaireDTO toDTO) throws ElementExisteExeption {
        if(info_bancaireRepository.existsById(toDTO.getId()))
            throw new Info_bancaireExisteExeption(toDTO.getId());

        Info_bancaire entity = info_bancaireMapper.toEntity(toDTO);
        adresseRepository.save(entity.getAppartient().getAdressepersonne());
        personneRepository.save(entity.getAppartient());
        info_bancaireRepository.save(entity);
    }

    @Transactional
    public Info_bancaireDTO selonRNational(Info_bancaireDTO rNational) {
        Optional<Info_bancaire> info_bancaire = info_bancaireRepository.findByAppartient_Nregistrenational(rNational.getAppartient().getNregistrenational());
        return info_bancaire.map(infoBancaire -> info_bancaireMapper.toDTO(infoBancaire)).orElse(null);

    }

    @Override
    public Info_bancaireDTO readOne(Integer integer) throws ElementFoundException, SimExisteExeption {
        Info_bancaire entity = info_bancaireRepository.findById(integer)
                .orElseThrow(() -> new Info_bancaireFoundExeption(integer));
        return info_bancaireMapper.toDTO(entity);
    }

    @Override
    public List<Info_bancaireDTO> readAll() {
        return info_bancaireRepository.findAll().stream()
                .map(info_bancaireMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Info_bancaireDTO toUpdate) throws ElementFoundException {
        if(!info_bancaireRepository.existsById(toUpdate.getId()))
            throw new Info_bancaireFoundExeption(toUpdate.getId());

        info_bancaireRepository.save(info_bancaireMapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementFoundException {
        if(!info_bancaireRepository.existsById(toDelete))
            throw new Info_bancaireFoundExeption(toDelete);

        info_bancaireRepository.deleteById(toDelete);
    }
}
