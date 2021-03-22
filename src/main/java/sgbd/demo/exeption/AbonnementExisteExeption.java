package sgbd.demo.exeption;

import sgbd.demo.business.dto.AbonnementDTO;

public class AbonnementExisteExeption extends ElementExisteExeption{
    public AbonnementExisteExeption(int id){
        super(id, AbonnementDTO.class);
    }
}
