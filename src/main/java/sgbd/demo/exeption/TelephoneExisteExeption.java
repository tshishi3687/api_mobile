package sgbd.demo.exeption;

import sgbd.demo.business.dto.TelephoneDTO;

public class TelephoneExisteExeption extends ElementExisteExeption{
    public TelephoneExisteExeption (int id) { super(id, TelephoneDTO.class);}
}
