package sgbd.demo.business.service;

import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;
import sgbd.demo.exeption.SimExisteExeption;

import java.util.List;

public interface CrudService<DTO, ID> {
    //Creat
    void creat(DTO toDTO) throws ElementExisteExeption;

    // read
    DTO readOne(ID id) throws ElementFoundException, SimExisteExeption;
    List<DTO> readAll();

    // update
    void update(DTO toUpdate) throws ElementFoundException;

    // delete
    void delete(ID toDelete) throws ElementFoundException;

}
