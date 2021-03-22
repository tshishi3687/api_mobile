package sgbd.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgbd.demo.business.dto.AdresseDTO;
import sgbd.demo.business.mapper.Mapper;
import sgbd.demo.data_access.entity.Adresse;
import sgbd.demo.data_access.repository.AdresseRepository;
import sgbd.demo.exeption.AdresseExisteExeption;
import sgbd.demo.exeption.AdressefoundExeption;
import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdresseService implements CrudService<AdresseDTO, Integer>{

    @Autowired
    private Mapper<AdresseDTO, Adresse> adresseMapper;
    @Autowired
    private AdresseRepository adresseRepository;


    @Override
    public void creat(AdresseDTO toDTO) throws ElementExisteExeption {
        if(adresseRepository.existsById(toDTO.getId()))
            throw new AdresseExisteExeption(toDTO.getId());
        adresseRepository.save(adresseMapper.toEntity(toDTO));
    }

    @Override
    public AdresseDTO readOne(Integer integer) throws ElementFoundException {
        Adresse entity = adresseRepository.findById(integer)
                .orElseThrow(() -> new AdressefoundExeption(integer));
        return adresseMapper.toDTO(entity);
    }

    @Override
    public List<AdresseDTO> readAll() {
        return adresseRepository.findAll()
                .stream()
                .map(adresseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(AdresseDTO toUpdate) throws ElementFoundException {
        if (!adresseRepository.existsById(toUpdate.getId()))
            throw new AdressefoundExeption(toUpdate.getId());

        adresseRepository.save(adresseMapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementFoundException {
        if(!adresseRepository.existsById(toDelete))
            throw new AdressefoundExeption(toDelete);

        adresseRepository.deleteById(toDelete);
    }
}
