package sgbd.demo.exeption;

import sgbd.demo.business.dto.AbonnementDTO;

public class AbonnementFoundExeption extends ElementFoundException{
    public AbonnementFoundExeption(int id) {
        super(AbonnementDTO.class, id);
    }
}
