package sgbd.demo.business.mapper;

import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.SimDTO;
import sgbd.demo.data_access.entity.Sim;

@Component
public class SimMapper implements Mapper<SimDTO, Sim>{

    @Override
    public SimDTO toDTO(Sim sim) {
        if(sim==null)
            return null;

        return new SimDTO(
                sim.getId(),
                sim.getDateactivation(),
                sim.getStatussim(),
                sim.getCodepin(),
                sim.getCodepuk(),
                sim.getCodepuk2(),
                sim.getDatetermination(),
                sim.getTypecarte()
        );
    }

    @Override
    public Sim toEntity(SimDTO simDTO) {
        if(simDTO==null)
            return null;

        Sim sim = new Sim();
        sim.setId(simDTO.getId());
        sim.setDateactivation(simDTO.getDateactivation());
        sim.setStatussim(simDTO.getStatussim());
        sim.setCodepin(simDTO.getCodepin());
        sim.setCodepuk(simDTO.getCodepuk());
        sim.setCodepuk2(simDTO.getCodepuk2());
        sim.setDatetermination(simDTO.getDatetermination());
        sim.setTypecarte(simDTO.getTypecarte());
        return sim;
    }
}
