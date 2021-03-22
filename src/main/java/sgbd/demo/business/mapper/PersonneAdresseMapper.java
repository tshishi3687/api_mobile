package sgbd.demo.business.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.ContratDTO;
import sgbd.demo.business.dto.PersonneAdresseDTO;
import sgbd.demo.data_access.entity.Contrat;
import sgbd.demo.data_access.entity.Personne;
import sgbd.demo.data_access.repository.ContratRepository;

@Component
public class PersonneAdresseMapper implements Mapper<PersonneAdresseDTO, Personne>{

    @Autowired
    private Mapper<ContratDTO, Contrat> contratMapper;

    @Autowired
    private ContratRepository contratRepository;

    @Override
    public PersonneAdresseDTO toDTO(Personne personne) {
        if(personne==null)
            return null;

        return new PersonneAdresseDTO(
                personne.getId(),
                personne.getNompersonne(),
                personne.getPrenompersonne(),
                personne.getGenrepersonne()
        );
    }

    @Override
    public Personne toEntity(PersonneAdresseDTO personneAdresseDTO) {
        if(personneAdresseDTO==null)
            return null;

        Personne personne = new Personne();
        personne.setId(personneAdresseDTO.getId());
        personne.setNompersonne(personneAdresseDTO.getNompersonne());
        personne.setGenrepersonne(personneAdresseDTO.getGenrepersonne());
        return personne;
    }
}
