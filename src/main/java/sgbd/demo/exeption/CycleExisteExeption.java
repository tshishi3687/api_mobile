package sgbd.demo.exeption;

import sgbd.demo.business.dto.CycleDTO;

public class CycleExisteExeption extends ElementExisteExeption{
    public CycleExisteExeption(int id) { super(id, CycleDTO.class);}
}
