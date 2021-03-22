package sgbd.demo.exeption;

import sgbd.demo.business.dto.Mode_paiementDTO;

public class Mode_paiementFoundExeption extends ElementFoundException{
    public Mode_paiementFoundExeption (int id) { super(Mode_paiementDTO.class, id);}
}
