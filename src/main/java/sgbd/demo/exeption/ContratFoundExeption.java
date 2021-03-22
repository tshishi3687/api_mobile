package sgbd.demo.exeption;

import sgbd.demo.business.dto.ContratDTO;

public class ContratFoundExeption extends ElementFoundException{
    public ContratFoundExeption (int id) { super(ContratDTO.class, id);}
}
