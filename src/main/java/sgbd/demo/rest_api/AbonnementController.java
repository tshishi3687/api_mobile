package sgbd.demo.rest_api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgbd.demo.business.dto.AbonnementDTO;
import sgbd.demo.business.service.CrudService;

@RestController
@RequestMapping("abonnement")
public class AbonnementController extends AbstractCrudController<AbonnementDTO, Integer>{
    public AbonnementController(CrudService<AbonnementDTO, Integer> service){ super(service);}
}
