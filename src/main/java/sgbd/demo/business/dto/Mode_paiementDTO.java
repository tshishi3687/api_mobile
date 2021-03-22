package sgbd.demo.business.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mode_paiementDTO implements identifiedDTO<Integer>{

    private Integer id;
    private String nom;
}
