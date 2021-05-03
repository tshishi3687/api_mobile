package sgbd.demo.business.mapper;

import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.AdresseDTO;
import sgbd.demo.data_access.entity.Adresse;

@Component
public class AdresseMapper implements Mapper<AdresseDTO, Adresse>{

    @Override
    public AdresseDTO toDTO(Adresse adresse) {
        if (adresse==null)
            return null;
        return new AdresseDTO(
                adresse.getId(),
                adresse.getVille(),
                adresse.getRue(),
                adresse.getNrue(),
                adresse.getCpostal(),
                adresse.getNboitelettre()
        );
    }

    @Override
    public Adresse toEntity(AdresseDTO adresseDTO) {
        if (adresseDTO==null)
            return null;
        Adresse adresse = new Adresse();
        adresse.setId(adresse.getId());
        adresse.setVille(adresseDTO.getVille());
        adresse.setRue(adresseDTO.getRue());
        adresse.setNrue(adresseDTO.getNrue());
        adresse.setCpostal(adresseDTO.getCpostal());
        adresse.setNboitelettre(adresseDTO.getNboitelettre());
        return adresse;
    }
}
