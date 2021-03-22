package sgbd.demo.rest_api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgbd.demo.business.dto.AdresseDTO;
import sgbd.demo.business.service.CrudService;

@RestController
@RequestMapping("adresse")
public class AdresseController extends AbstractCrudController<AdresseDTO, Integer>{
    public AdresseController(CrudService<AdresseDTO, Integer> service){ super(service);}
}
