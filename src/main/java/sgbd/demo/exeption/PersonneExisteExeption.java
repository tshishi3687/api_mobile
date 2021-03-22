package sgbd.demo.exeption;

import sgbd.demo.business.dto.PersonneDTO;

public class PersonneExisteExeption extends ElementExisteExeption{
    public PersonneExisteExeption (int id){ super(id, PersonneDTO.class);}
}
