package sgbd.demo.exeption;

import sgbd.demo.business.dto.Service_usageDTO;

public class Service_usageFoundExeption extends ElementFoundException{
    public Service_usageFoundExeption (int id) {super(Service_usageDTO.class, id);}
}
