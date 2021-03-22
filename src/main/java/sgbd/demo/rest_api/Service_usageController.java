package sgbd.demo.rest_api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgbd.demo.business.dto.Service_usageDTO;
import sgbd.demo.business.service.CrudService;

@RestController
@RequestMapping("service_usage")
public class Service_usageController extends AbstractCrudController<Service_usageDTO, Integer>{
    public Service_usageController(CrudService<Service_usageDTO, Integer> service){super(service);}
}
