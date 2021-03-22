package sgbd.demo.rest_api.model.raport;

import lombok.Getter;

@Getter
public class ExisteRapport extends ElementRapport{
    public ExisteRapport(Object id, String elementType) {
        super(id, elementType, "Un élément avec l'id mentionné existe déjà");
    }
}
