package sgbd.demo.rest_api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sgbd.demo.business.dto.identifiedDTO;
import sgbd.demo.business.service.CrudService;
import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;
import sgbd.demo.exeption.FoundExeption;
import sgbd.demo.exeption.SimExisteExeption;
import sgbd.demo.rest_api.model.container.ElementsContainer;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractCrudController<DTO extends identifiedDTO<ID>,ID> implements CrudController<DTO, ID> {

    protected final CrudService<DTO, ID> service;

    public AbstractCrudController(CrudService<DTO, ID> service){this.service = service;}

    // CREATE - POST > http://localhost:8081/?
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody @Valid DTO dto) throws ElementExisteExeption {
        service.creat(dto);

    }

    // READ_ONE - GET > http://localhost:8081/?/{id}
    @GetMapping("/{id}")
    public ResponseEntity<DTO> getOne(@PathVariable ID id) throws ElementFoundException, FoundExeption, SimExisteExeption {
        return ResponseEntity.ok( service.readOne(id) );
    }



    // READ_ALL - GET > http://localhost:8081/?
    @GetMapping
    public ResponseEntity<ElementsContainer<DTO>> getAll(){
        List<DTO> list = service.readAll();
        return ResponseEntity.ok( new ElementsContainer<>( list ) );
    }

    // UPDATE - PUT > http://localhost:8081/?
    @PutMapping
    public ResponseEntity<String> update(@RequestBody DTO dto) throws ElementFoundException, FoundExeption {
        service.update(dto);
        return ResponseEntity.ok("Un élément a été modifié" );
    }

    // DELETE - DELETE > http://localhost:8081/?/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<DTO> delete(@PathVariable ID id) throws ElementFoundException, FoundExeption, SimExisteExeption {
        DTO dto = service.readOne(id);
        service.delete(id);
        return ResponseEntity.ok(dto);
    }
}
