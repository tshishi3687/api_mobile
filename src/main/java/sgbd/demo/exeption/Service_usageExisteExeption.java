package sgbd.demo.exeption;

import sgbd.demo.business.dto.Service_usageDTO;

public class Service_usageExisteExeption extends ElementExisteExeption{
    public Service_usageExisteExeption (int id) { super(id, Service_usageDTO.class);}
}
