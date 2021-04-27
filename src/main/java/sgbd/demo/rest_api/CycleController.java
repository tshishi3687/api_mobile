package sgbd.demo.rest_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sgbd.demo.business.dto.CycleDTO;
import sgbd.demo.business.dto.Info_bancaireDTO;
import sgbd.demo.business.service.CrudService;
import sgbd.demo.business.service.CycleService;
import sgbd.demo.business.service.Info_bancaireService;

@RestController
@RequestMapping("cycle")
public class CycleController extends AbstractCrudController<CycleDTO, Integer>{
    public CycleController(CrudService<CycleDTO, Integer> service){super(service);}
}
