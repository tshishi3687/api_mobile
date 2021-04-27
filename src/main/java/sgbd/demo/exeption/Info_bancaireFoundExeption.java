package sgbd.demo.exeption;

import sgbd.demo.business.dto.Info_bancaireDTO;

public class Info_bancaireFoundExeption extends ElementFoundException{
    public Info_bancaireFoundExeption(int id) {super(Info_bancaireDTO.class, id);}
}
