package sgbd.demo.rest_api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgbd.demo.business.dto.Service_activationDTO;
import sgbd.demo.business.service.CrudService;

@RestController
@RequestMapping("service_activation")
public class Service_activationController extends AbstractCrudController<Service_activationDTO, Integer>{
    public Service_activationController(CrudService<Service_activationDTO, Integer> service){super(service);}
}
