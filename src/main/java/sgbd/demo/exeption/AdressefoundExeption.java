package sgbd.demo.exeption;

import sgbd.demo.business.dto.AdresseDTO;

public class AdressefoundExeption extends ElementFoundException{
    public AdressefoundExeption(int id) { super(AdresseDTO.class, id);}
}
