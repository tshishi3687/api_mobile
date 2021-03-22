package sgbd.demo.rest_api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgbd.demo.business.dto.SimDTO;
import sgbd.demo.business.service.CrudService;

@RestController
@RequestMapping("sim")
public class SimController extends AbstractCrudController<SimDTO, Integer>{
    public SimController(CrudService<SimDTO, Integer> service){super(service);}
}
