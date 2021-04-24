package sgbd.demo.business.dto;

import lombok.*;
import sgbd.demo.data_access.entity.Mode_paiement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CycleDTO implements identifiedDTO<Integer>{

    private Integer id;
    private String tempscycle;
    private Mode_paiementDTO modepaiement;
    private Info_bancaireDTO information;
}
