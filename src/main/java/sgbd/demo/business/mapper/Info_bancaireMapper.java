package sgbd.demo.business.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgbd.demo.business.dto.Info_bancaireDTO;
import sgbd.demo.business.dto.PersonneDTO;
import sgbd.demo.data_access.entity.Info_bancaire;
import sgbd.demo.data_access.entity.Personne;
import sgbd.demo.data_access.repository.PersonnneRepository;

@Component
public class Info_bancaireMapper implements Mapper<Info_bancaireDTO, Info_bancaire> {

    @Autowired
    private Mapper<PersonneDTO, Personne> personneMapper;

    @Autowired
    private PersonnneRepository personnneRepository;

    @Override
    public Info_bancaireDTO toDTO(Info_bancaire info_bancaire) {
        if(info_bancaire==null)
            return null;
        return new Info_bancaireDTO(
                info_bancaire.getId(),
                personneMapper.toDTO((info_bancaire.getAppartient())),
                info_bancaire.getCompte(),
                info_bancaire.getDomiciliation(),
                info_bancaire.getStatusdomiciliation(),
                info_bancaire.getBanque(),
                info_bancaire.getCredit(),
                info_bancaire.getExpiration()
        );
    }

    @Override
    public Info_bancaire toEntity(Info_bancaireDTO info_bancaireDTO) {
        if(info_bancaireDTO==null)
            return null;

        Info_bancaire info_bancaire =  new Info_bancaire();
            info_bancaire.setId(info_bancaireDTO.getId());
            info_bancaire.setAppartient(personneMapper.toEntity(info_bancaireDTO.getAppartient()));
            info_bancaire.setCompte(info_bancaireDTO.getCompte());
            info_bancaire.setDomiciliation(info_bancaireDTO.getDomiciliation());
            info_bancaire.setStatusdomiciliation(info_bancaireDTO.getStatusdomiciliation());
            info_bancaire.setBanque(info_bancaireDTO.getBanque());
            info_bancaire.setCredit(info_bancaireDTO.getCredit());
            info_bancaire.setExpiration(info_bancaireDTO.getExpiration());
        return info_bancaire;
    }
}
