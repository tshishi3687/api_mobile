package sgbd.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgbd.demo.business.dto.AdresseDTO;
import sgbd.demo.business.dto.PersonneDTO;
import sgbd.demo.business.dto.PersonneDeuxDTO;
import sgbd.demo.business.mapper.Mapper;
import sgbd.demo.data_access.entity.Adresse;
import sgbd.demo.data_access.entity.Personne;
import sgbd.demo.data_access.repository.AdresseRepository;
import sgbd.demo.data_access.repository.PersonnneRepository;
import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;
import sgbd.demo.exeption.PersonneExisteExeption;
import sgbd.demo.exeption.PersonneFoundExeption;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonneService implements CrudService<PersonneDTO, Integer>{

    @Autowired
    private Mapper<PersonneDTO, Personne> personneMapper;
    @Autowired
    private Mapper<PersonneDeuxDTO, Personne> personneDeuxMapper;
    @Autowired
    private PersonnneRepository personneRepository;
    @Autowired
    private AdresseRepository adresseRepository;
    @Autowired
    private AdresseService addrService;
    @Autowired
    private Mapper<AdresseDTO, Adresse> adresseMapper;



    @Transactional
    public PersonneDTO seloNNational(PersonneDTO personne){
        Optional<Personne> user = personneRepository.findByNregistrenational(personne.getNregistrenational());
        return user.map(value -> personneMapper.toDTO(value)).orElse(null);
    }

    @Transactional
    public List<PersonneDTO> seloNompersonne(PersonneDTO personne){
        List<Personne> personneList = personneRepository.findAllByNompersonne(personneMapper.toEntity(personne));
        return personneRepository.findAllByNompersonne(personneMapper.toEntity(personne))
                .stream()
                .map(personneMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PersonneDTO> selonCPostal(PersonneDTO personne){
        List<Personne> personneList = personneRepository.findAllByAdressepersonne_Cpostal(personne.getAdressepersonne().getCpostal());
        return personneRepository.findAllByAdressepersonne_Cpostal(personne.getAdressepersonne().getCpostal())
        .stream()
        .map(personneMapper::toDTO)
        .collect(Collectors.toList());
    }

    @Override
    public void creat(PersonneDTO toDTO) throws ElementExisteExeption {
        if(personneRepository.existsById(toDTO.getId()))
            throw new PersonneExisteExeption(toDTO.getId());

        Personne entity = personneMapper.toEntity(toDTO);
        adresseRepository.save(entity.getAdressepersonne());
        personneRepository.save(entity);
    }

    @Override
    public PersonneDTO readOne(Integer integer) throws ElementFoundException {
        Personne entity = personneRepository.findById(integer)
                .orElseThrow(()-> new PersonneFoundExeption(integer));
        return personneMapper.toDTO(entity);
    }

    @Override
    public List<PersonneDTO> readAll() {
        return personneRepository.findAll()
                .stream()
                .map(personneMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(PersonneDTO toUpdate) throws ElementFoundException {
        if(!personneRepository.existsById(toUpdate.getId()))
            throw new PersonneFoundExeption(toUpdate.getId());

    }

    @Transactional
    public void updatee(PersonneDTO toUpdate) throws ElementFoundException{
        if(!personneRepository.existsById(toUpdate.getId()))
            throw new PersonneFoundExeption(toUpdate.getId());
        System.out.println(toUpdate);
        Personne entity = personneMapper.toEntity(toUpdate);
        personneRepository.updatee(
                toUpdate.getNompersonne(),
                toUpdate.getPrenompersonne(),
                toUpdate.getGenrepersonne(),
                toUpdate.getCivilitepersonne(),
                adresseRepository.save(entity.getAdressepersonne()),
                toUpdate.getId()
                );
    }

    @Override
    public void delete(Integer toDelete) throws ElementFoundException {
        if(!personneRepository.existsById(toDelete))
            throw new PersonneFoundExeption(toDelete);
        personneRepository.deleteById(toDelete);
    }
}
