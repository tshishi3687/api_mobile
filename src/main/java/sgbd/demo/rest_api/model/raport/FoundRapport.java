package sgbd.demo.rest_api.model.raport;

public class FoundRapport extends ElementRapport{
    public FoundRapport(Object id, String elementType) {
        super(id, elementType, "Il n'existe pas l'élément ayant cet id");
    }
}
