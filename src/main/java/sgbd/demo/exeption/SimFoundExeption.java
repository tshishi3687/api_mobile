package sgbd.demo.exeption;

import sgbd.demo.business.dto.SimDTO;

public class SimFoundExeption extends ElementFoundException{
    public SimFoundExeption (int id) { super(SimDTO.class, id);}
}
