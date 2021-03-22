package sgbd.demo.rest_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sgbd.demo.business.dto.TelephoneDTO;
import sgbd.demo.business.service.CrudService;
import sgbd.demo.business.service.TelephoneService;

@RestController
@RequestMapping("telephone")
public class TelephoneController extends AbstractCrudController<TelephoneDTO, Integer>{
    public TelephoneController(CrudService<TelephoneDTO, Integer> service){super(service);}

    @PostMapping("/siExiste")
    @ResponseStatus(HttpStatus.OK)
    public Boolean siExiste(@RequestBody TelephoneDTO dto)  {
        return ((TelephoneService)service).siExiste(dto);
    }
}
