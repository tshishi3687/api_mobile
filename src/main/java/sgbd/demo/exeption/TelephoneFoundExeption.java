package sgbd.demo.exeption;

import sgbd.demo.business.dto.TelephoneDTO;

public class TelephoneFoundExeption extends ElementFoundException{
    public TelephoneFoundExeption (int id) { super(TelephoneDTO.class, id);}
}
