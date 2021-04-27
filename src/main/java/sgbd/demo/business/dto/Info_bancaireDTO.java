package sgbd.demo.business.dto;

import lombok.*;
import sgbd.demo.data_access.entity.Personne;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Info_bancaireDTO  implements identifiedDTO<Integer>{

    private Integer id;
    private PersonneDTO appartient;
    private String compte;
    private int domiciliation;
    private String statusdomiciliation;
    private String banque;
    private String credit;
    private LocalDate expiration;
}
