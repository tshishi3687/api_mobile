package sgbd.demo.exeption;

import sgbd.demo.business.dto.Service_activationDTO;

public class Service_activationFoundExeption extends ElementFoundException{
    public Service_activationFoundExeption (int id) { super(Service_activationDTO.class, id);}
}
