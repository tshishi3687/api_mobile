package sgbd.demo.exeption;

import sgbd.demo.business.dto.SimDTO;

public class SimExisteExeption extends ElementExisteExeption{
    public SimExisteExeption (int id) { super(id, SimDTO.class);}
}
