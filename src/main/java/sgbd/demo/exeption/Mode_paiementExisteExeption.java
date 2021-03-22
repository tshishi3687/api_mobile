package sgbd.demo.exeption;

import sgbd.demo.business.dto.Mode_paiementDTO;

public class Mode_paiementExisteExeption extends ElementExisteExeption{
    public Mode_paiementExisteExeption (int id) { super(id, Mode_paiementDTO.class);}
}
