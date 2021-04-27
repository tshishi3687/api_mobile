package sgbd.demo.exeption;

import sgbd.demo.business.dto.Info_bancaireDTO;

public class Info_bancaireExisteExeption extends ElementExisteExeption{
    public Info_bancaireExisteExeption(int id){super(id, Info_bancaireDTO.class);}
}
