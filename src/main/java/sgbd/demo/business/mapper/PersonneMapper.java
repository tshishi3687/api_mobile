package sgbd.demo.business.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.AdresseDTO;
import sgbd.demo.business.dto.PersonneDTO;
import sgbd.demo.data_access.entity.Adresse;
import sgbd.demo.data_access.entity.Personne;

@Component
public class PersonneMapper implements Mapper<PersonneDTO, Personne>{

    @Autowired
    private Mapper<AdresseDTO, Adresse> adresseMapper;

    @Override
    public PersonneDTO toDTO(Personne personne) {
        if (personne==null)
            return null;

        return new PersonneDTO(
                personne.getId(),
                personne.getNompersonne(),
                personne.getPrenompersonne(),
                personne.getGenrepersonne(),
                personne.getDatenaisspersonne(),
                personne.getNregistrenational(),
                personne.getCivilitepersonne(),
                adresseMapper.toDTO(personne.getAdressepersonne())
        );
    }


    @Override
    public Personne toEntity(PersonneDTO personneDTO) {
        if (personneDTO==null)
            return null;

        Personne personne = new Personne();
        personne.setId(personne.getId());
        personne.setNompersonne(personneDTO.getNompersonne());
        personne.setPrenompersonne(personneDTO.getPrenompersonne());
        personne.setGenrepersonne(personneDTO.getGenrepersonne());
        personne.setDatenaisspersonne(personneDTO.getDatenaisspersonne());
        personne.setNregistrenational(personneDTO.getNregistrenational());
        personne.setCivilitepersonne(personneDTO.getCivilitepersonne());
        personne.setAdressepersonne(adresseMapper.toEntity(personneDTO.getAdressepersonne()));
        return personne;
    }
}
