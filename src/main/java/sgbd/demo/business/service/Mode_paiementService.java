package sgbd.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgbd.demo.business.dto.Mode_paiementDTO;
import sgbd.demo.business.mapper.Mapper;
import sgbd.demo.data_access.entity.Mode_paiement;
import sgbd.demo.data_access.repository.Mode_paiementRepository;
import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;
import sgbd.demo.exeption.Mode_paiementExisteExeption;
import sgbd.demo.exeption.Mode_paiementFoundExeption;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Mode_paiementService implements CrudService<Mode_paiementDTO, Integer>{

    @Autowired
    private Mapper<Mode_paiementDTO, Mode_paiement> mode_paiementMapper;
    @Autowired
    private Mode_paiementRepository mode_paiementRepository;
    @Override
    public void creat(Mode_paiementDTO toDTO) throws ElementExisteExeption {
        if(mode_paiementRepository.existsById(toDTO.getId()))
            throw new Mode_paiementExisteExeption(toDTO.getId());

        mode_paiementRepository.save(mode_paiementMapper.toEntity(toDTO));
    }

    @Override
    public Mode_paiementDTO readOne(Integer integer) throws ElementFoundException {
        Mode_paiement entity = mode_paiementRepository.findById(integer)
                .orElseThrow(()-> new Mode_paiementFoundExeption(integer));

        return mode_paiementMapper.toDTO(entity);
    }

    @Override
    public List<Mode_paiementDTO> readAll() {
        return mode_paiementRepository.findAll()
                .stream()
                .map(mode_paiementMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Mode_paiementDTO toUpdate) throws ElementFoundException {
        if(!mode_paiementRepository.existsById(toUpdate.getId()))
            throw new Mode_paiementFoundExeption(toUpdate.getId());

        mode_paiementRepository.save(mode_paiementMapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementFoundException {
        if(!mode_paiementRepository.existsById(toDelete))
            throw new Mode_paiementFoundExeption(toDelete);

        mode_paiementRepository.deleteById(toDelete);
    }
}
