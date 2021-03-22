package sgbd.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgbd.demo.business.dto.TelephoneDTO;
import sgbd.demo.business.mapper.Mapper;
import sgbd.demo.data_access.entity.Telephone;
import sgbd.demo.data_access.repository.TelephoneRepository;
import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;
import sgbd.demo.exeption.TelephoneExisteExeption;
import sgbd.demo.exeption.TelephoneFoundExeption;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TelephoneService implements CrudService<TelephoneDTO, Integer>{

    @Autowired
    private Mapper<TelephoneDTO, Telephone> telephoneMapper;
    @Autowired
    private TelephoneRepository telephoneRepository;

    @Transactional
    public boolean siExiste (TelephoneDTO telephone){
        Optional<Telephone> numero = telephoneRepository.findByNtelephone(telephone.getNtelephone());
        return numero.get().getNtelephone().equals(telephone.getNtelephone());
    }

    @Override
    public void creat(TelephoneDTO toDTO) throws ElementExisteExeption {
        if(telephoneRepository.existsById(toDTO.getId()))
            throw new TelephoneExisteExeption(toDTO.getId());

        telephoneRepository.save(telephoneMapper.toEntity(toDTO));
    }

    @Override
    public TelephoneDTO readOne(Integer integer) throws ElementFoundException {
        Telephone entity = telephoneRepository.findById(integer)
                .orElseThrow(()-> new TelephoneFoundExeption(integer));

        return telephoneMapper.toDTO(entity);
    }

    @Override
    public List<TelephoneDTO> readAll() {
        return telephoneRepository.findAll()
                .stream()
                .map(telephoneMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(TelephoneDTO toUpdate) throws ElementFoundException {
        if(!telephoneRepository.existsById(toUpdate.getId()))
            throw new TelephoneFoundExeption(toUpdate.getId());

        telephoneRepository.save(telephoneMapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementFoundException {
        if(!telephoneRepository.existsById(toDelete))
            throw new TelephoneFoundExeption(toDelete);

        telephoneRepository.deleteById(toDelete);
    }
}
