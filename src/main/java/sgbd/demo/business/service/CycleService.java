package sgbd.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgbd.demo.business.dto.CycleDTO;
import sgbd.demo.business.mapper.Mapper;
import sgbd.demo.data_access.entity.Cycle;
import sgbd.demo.data_access.repository.CycleRepository;
import sgbd.demo.exeption.CycleExisteExeption;
import sgbd.demo.exeption.CycleFoundExeption;
import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CycleService implements CrudService<CycleDTO, Integer>{

    @Autowired
    private Mapper<CycleDTO, Cycle> cycleMapper;
    @Autowired
    private CycleRepository cycleRepository;

    @Override
    public void creat(CycleDTO toDTO) throws ElementExisteExeption {
        if(cycleRepository.existsById(toDTO.getId()))
            throw new CycleExisteExeption(toDTO.getId());

        cycleRepository.save(cycleMapper.toEntity(toDTO));
    }

    @Override
    public CycleDTO readOne(Integer integer) throws ElementFoundException {
        Cycle entity = cycleRepository.findById(integer)
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
