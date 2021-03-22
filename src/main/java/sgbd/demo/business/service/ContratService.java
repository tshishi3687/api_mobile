package sgbd.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgbd.demo.business.dto.ContratDTO;
import sgbd.demo.business.mapper.Mapper;
import sgbd.demo.data_access.entity.Contrat;
import sgbd.demo.data_access.repository.ContratRepository;
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

    @Override
    public void creat(ContratDTO toDTO) throws ElementExisteExeption {
        if(contratRepository.existsById(toDTO.getId()))
            throw new ContratExisteexeption(toDTO.getId());

        contratRepository.save(contratMapper.toEntity(toDTO));
    }

    @Override
    public ContratDTO readOne(Integer integer) throws ElementFoundException {
        Contrat entity = contratRepository.findById(integer)
                .orElseThrow(() -> new ContratFoundExeption(integer));
        return contratMapper.toDTO(entity);
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
