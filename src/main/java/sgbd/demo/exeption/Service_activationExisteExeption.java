package sgbd.demo.exeption;

import sgbd.demo.business.dto.Service_activationDTO;

public class Service_activationExisteExeption extends ElementExisteExeption{
    public Service_activationExisteExeption (int id) { super(id, Service_activationDTO.class);}
}
