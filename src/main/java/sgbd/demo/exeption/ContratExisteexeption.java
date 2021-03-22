package sgbd.demo.exeption;

import sgbd.demo.business.dto.ContratDTO;

public class ContratExisteexeption extends ElementExisteExeption{
    public ContratExisteexeption(int id) { super(id, ContratDTO.class);}
}
