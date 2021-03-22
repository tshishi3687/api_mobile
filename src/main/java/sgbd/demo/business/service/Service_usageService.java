package sgbd.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgbd.demo.business.dto.Service_usageDTO;
import sgbd.demo.business.mapper.Mapper;
import sgbd.demo.data_access.entity.Service_usage;
import sgbd.demo.data_access.repository.Service_usageRepository;
import sgbd.demo.exeption.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Service_usageService implements CrudService<Service_usageDTO, Integer>{

    @Autowired
    private Mapper<Service_usageDTO, Service_usage> service_usageMapper;
    @Autowired
    private Service_usageRepository service_usageRepository;

    @Override
    public void creat(Service_usageDTO toDTO) throws ElementExisteExeption {
        if(service_usageRepository.existsById(toDTO.getId()))
            throw new Service_usageExisteExeption(toDTO.getId());

        service_usageRepository.save(service_usageMapper.toEntity(toDTO));
    }

    @Override
    public Service_usageDTO readOne(Integer integer) throws ElementFoundException {
        Service_usage entity = service_usageRepository.findById(integer)
                .orElseThrow(()-> new Service_usageFoundExeption(integer));

        return service_usageMapper.toDTO(entity);
    }

    @Override
    public List<Service_usageDTO> readAll() {
        return service_usageRepository.findAll()
                .stream()
                .map(service_usageMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Service_usageDTO toUpdate) throws ElementFoundException {
        if(!service_usageRepository.existsById(toUpdate.getId()))
            throw new Service_usageFoundExeption(toUpdate.getId());

        service_usageRepository.save(service_usageMapper.toEntity(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementFoundException {
        if(!service_usageRepository.existsById(toDelete))
            throw new Service_usageFoundExeption(toDelete);

        service_usageRepository.deleteById(toDelete);
    }
}
