package sgbd.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgbd.demo.business.dto.SimDTO;
import sgbd.demo.business.mapper.Mapper;
import sgbd.demo.data_access.entity.Sim;
import sgbd.demo.data_access.repository.SimRepository;
import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;
import sgbd.demo.exeption.SimExisteExeption;
import sgbd.demo.exeption.SimFoundExeption;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimService implements CrudService<SimDTO, Integer>{

    @Autowired
    private Mapper<SimDTO, Sim> simMapper;
    @Autowired
    private SimRepository simRepository;

    @Override
    public void creat(SimDTO toDTO) throws ElementExisteExeption {
        if(simRepository.existsById(toDTO.getId()))
            throw  new SimExisteExeption(toDTO.getId());

        simRepository.save(simMapper.toEntity(toDTO));
    }

    @Override
    public SimDTO readOne(Integer integer) throws ElementFoundException, SimExisteExeption {
        Sim entity = simRepository.findById(integer)
                .orElseThrow(()-> new SimExisteExeption(integer));

        return simMapper.toDTO(entity);
    }

    @Override
    public List<SimDTO> readAll() {
        return simRepository.findAll()
                .stream()
                .map(simMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(SimDTO toUpdate) throws ElementFoundException {
        if(!simRepository.existsById(toUpdate.getId()))
            throw new SimFoundExeption(toUpdate.getId());
        simRepository.save(simMapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementFoundException {
        if(!simRepository.existsById(toDelete))
            throw new SimFoundExeption(toDelete);

        simRepository.deleteById(toDelete);
    }
}
