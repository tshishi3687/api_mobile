package sgbd.demo.rest_api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgbd.demo.business.dto.CycleDTO;
import sgbd.demo.business.service.CrudService;

@RestController
@RequestMapping("cycle")
public class CycleController extends AbstractCrudController<CycleDTO, Integer>{
    public CycleController(CrudService<CycleDTO, Integer> service){super(service);}
}
