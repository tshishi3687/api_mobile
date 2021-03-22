package sgbd.demo.rest_api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import sgbd.demo.business.dto.identifiedDTO;
import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;
import sgbd.demo.exeption.FoundExeption;
import sgbd.demo.exeption.SimExisteExeption;
import sgbd.demo.rest_api.model.container.ElementsContainer;

public interface CrudController<DTO extends identifiedDTO<ID>, ID> {
    // Create
    void create(@RequestBody DTO dto) throws ElementExisteExeption;

    // Read
    ResponseEntity<DTO> getOne(@PathVariable ID id) throws ElementFoundException, FoundExeption, SimExisteExeption;
    ResponseEntity<ElementsContainer<DTO>> getAll();

    // Update
    ResponseEntity<String> update(@RequestBody DTO dto) throws ElementFoundException, FoundExeption;

    // Delete
    ResponseEntity<DTO> delete(@PathVariable ID id) throws ElementFoundException, FoundExeption, SimExisteExeption;
}
