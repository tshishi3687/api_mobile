package sgbd.demo.business.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContratDTO implements identifiedDTO<Integer>{

    private Integer id;
    private LocalDate datesignature;
    private LocalDate datedebut;
    private LocalDate datefin;
    private AbonnementDTO abonnement;
    private CycleDTO facturation;
}
