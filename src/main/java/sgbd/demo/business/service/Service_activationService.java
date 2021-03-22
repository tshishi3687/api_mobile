package sgbd.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgbd.demo.business.dto.Service_activationDTO;
import sgbd.demo.business.mapper.Mapper;
import sgbd.demo.data_access.entity.Service_activation;
import sgbd.demo.data_access.repository.Service_activationRepository;
import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;
import sgbd.demo.exeption.Service_activationExisteExeption;
import sgbd.demo.exeption.Service_activationFoundExeption;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Service_activationService implements CrudService<Service_activationDTO, Integer>{

    @Autowired
    private Mapper<Service_activationDTO, Service_activation> service_activationMapper;
    @Autowired
    private Service_activationRepository service_activationRepository;

    @Override
    public void creat(Service_activationDTO toDTO) throws ElementExisteExeption {
        if(service_activationRepository.existsById(toDTO.getId()))
            throw new Service_activationExisteExeption(toDTO.getId());

        service_activationRepository.save(service_activationMapper.toEntity(toDTO));
    }

    @Override
    public Service_activationDTO readOne(Integer integer) throws ElementFoundException {
        Service_activation entity = service_activationRepository.findById(integer)
                .orElseThrow(() -> new Service_activationFoundExeption(integer));

        return service_activationMapper.toDTO(entity);
    }

    @Override
    public List<Service_activationDTO> readAll() {
        return service_activationRepository.findAll()
                .stream()
                .map(service_activationMapper::toDTO)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public void update(Service_activationDTO toUpdate) throws ElementFoundException {
        if(!service_activationRepository.existsById(toUpdate.getId()))
            throw new Service_activationFoundExeption(toUpdate.getId());

        service_activationRepository.save(service_activationMapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementFoundException {
        if(!service_activationRepository.existsById(toDelete))
            throw new Service_activationFoundExeption(toDelete);

        service_activationRepository.deleteById(toDelete);
    }
}
