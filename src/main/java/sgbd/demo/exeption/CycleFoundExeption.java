package sgbd.demo.exeption;

import sgbd.demo.business.dto.CycleDTO;

public class CycleFoundExeption extends ElementFoundException{
    public CycleFoundExeption (int id) { super(CycleDTO.class, id);}
}
