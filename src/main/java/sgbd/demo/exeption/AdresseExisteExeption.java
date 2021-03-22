package sgbd.demo.exeption;

import sgbd.demo.business.dto.AdresseDTO;

public class AdresseExisteExeption extends ElementExisteExeption{
    public AdresseExisteExeption(int id){ super(id, AdresseDTO.class);}
}
