package sgbd.demo.rest_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sgbd.demo.business.dto.PersonneDTO;
import sgbd.demo.business.service.CrudService;
import sgbd.demo.business.service.PersonneService;
import sgbd.demo.exeption.ElementFoundException;

import java.util.List;

@RestController
@RequestMapping("personne")
public class PersonneController extends AbstractCrudController<PersonneDTO, Integer>{
    public PersonneController(CrudService<PersonneDTO, Integer> service){super(service);}



    @PostMapping("/seloNNational")
    @ResponseStatus(HttpStatus.OK)
    public PersonneDTO rechUser(@RequestBody PersonneDTO personneDTO){
        return ((PersonneService)service).seloNNational(personneDTO);
    }

    @PostMapping("/seloNompersonne")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonneDTO> seloNompersonne(@RequestBody PersonneDTO personneDTO){

        return ((PersonneService)service).seloNompersonne(personneDTO);
    }

    @PostMapping("/selonCPostal")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonneDTO> selonCPostal(@RequestBody PersonneDTO personneDTO){
        return ((PersonneService)service).selonCPostal(personneDTO);
    }

    @PutMapping("/modif")
    @ResponseStatus(HttpStatus.OK)
    public void updatee(@RequestBody PersonneDTO personneDTO) throws ElementFoundException {
        ((PersonneService)service).updatee(personneDTO);
    }
}
