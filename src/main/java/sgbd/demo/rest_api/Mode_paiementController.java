package sgbd.demo.rest_api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgbd.demo.business.dto.Mode_paiementDTO;
import sgbd.demo.business.service.CrudService;

@RestController
@RequestMapping("mode_paiement")
public class Mode_paiementController extends AbstractCrudController<Mode_paiementDTO, Integer>{
    public Mode_paiementController(CrudService<Mode_paiementDTO, Integer> service){super(service);}
}
