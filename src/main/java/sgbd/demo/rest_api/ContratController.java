package sgbd.demo.rest_api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgbd.demo.business.dto.ContratDTO;
import sgbd.demo.business.service.CrudService;

@RestController
@RequestMapping("contrat")
public class ContratController extends AbstractCrudController<ContratDTO, Integer>{
    public ContratController(CrudService<ContratDTO, Integer> service){super(service);}
}
