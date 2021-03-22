package sgbd.demo.rest_api.edviser;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sgbd.demo.exeption.ElementExisteExeption;
import sgbd.demo.exeption.ElementFoundException;
import sgbd.demo.rest_api.model.raport.ExisteRapport;
import sgbd.demo.rest_api.model.raport.FoundRapport;

@ControllerAdvice
public class ControlleurAdviser {

    @ExceptionHandler(ElementExisteExeption.class)
    public ResponseEntity<ExisteRapport> elementAlreadyExistsHandler(ElementExisteExeption ex){
        ExisteRapport raport = new ExisteRapport(ex.getId(),ex.getClazz().getSimpleName());
        return ResponseEntity.badRequest().body(raport);
    }

    @ExceptionHandler(ElementFoundException.class)
    public ResponseEntity<FoundRapport> elementNotFoundHandler(ElementFoundException ex )
    {
        FoundRapport report = new FoundRapport(ex.getId(), ex.getClazz().getSimpleName());
        return ResponseEntity.badRequest().body(report);
    }
}
