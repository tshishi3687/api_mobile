package sgbd.demo.exeption;

import sgbd.demo.business.dto.PersonneDTO;

public class PersonneFoundExeption extends ElementFoundException{
    public PersonneFoundExeption (int id){ super(PersonneDTO.class, id);}
}
