package sgbd.demo.business.dto;

import lombok.*;
import sgbd.demo.data_access.entity.Telephone;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SimDTO implements identifiedDTO<Integer>{

    private Integer id;
    private LocalDate dateactivation;
    private String statussim;
    private int codepin;
    private int codepuk;
    private int codepuk2;
    private LocalDate datetermination;
    private String typecarte;
    private TelephoneDTO msisdn;
}
