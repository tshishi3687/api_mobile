package sgbd.demo.rest_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sgbd.demo.business.dto.Info_bancaireDTO;
import sgbd.demo.business.service.CrudService;
import sgbd.demo.business.service.Info_bancaireService;
import sgbd.demo.exeption.ElementExisteExeption;

@RestController
@RequestMapping("info_bancaire")
public class Info_bancaireController extends AbstractCrudController<Info_bancaireDTO , Integer>{
    public Info_bancaireController(CrudService<Info_bancaireDTO, Integer> service){ super((service));}

    @PostMapping("/n_info_bancaire")
    @ResponseStatus(HttpStatus.OK)
    public void newClient(@RequestBody Info_bancaireDTO info_bancaireDTO) throws ElementExisteExeption {
        ((Info_bancaireService)service).creatnewPersonne(info_bancaireDTO);
    }

    @PostMapping("/rnational")
    @ResponseStatus(HttpStatus.OK)
    public Info_bancaireDTO selonRNational(@RequestBody Info_bancaireDTO info_bancaireDTO){
        return ((Info_bancaireService)service).selonRNational(info_bancaireDTO);
    }
}
