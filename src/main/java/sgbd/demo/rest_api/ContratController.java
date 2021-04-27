package sgbd.demo.rest_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sgbd.demo.business.dto.ContratDTO;
import sgbd.demo.business.dto.PersonneDTO;
import sgbd.demo.business.service.ContratService;
import sgbd.demo.business.service.CrudService;
import sgbd.demo.business.service.PersonneService;
import sgbd.demo.exeption.ElementExisteExeption;

import java.util.List;

@RestController
@RequestMapping("contrat")
public class ContratController extends AbstractCrudController<ContratDTO, Integer>{
    public ContratController(CrudService<ContratDTO, Integer> service){super(service);}

    @PostMapping("/selonnnational")
    @ResponseStatus(HttpStatus.OK)
    public List<ContratDTO> seloNompersonne(@RequestBody PersonneDTO personneDTO){
        return ((ContratService)service).selonPers(personneDTO);
    }
}
