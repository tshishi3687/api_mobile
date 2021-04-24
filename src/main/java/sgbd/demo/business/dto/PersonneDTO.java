package sgbd.demo.business.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonneDTO implements identifiedDTO<Integer>{

    private Integer id;
    private String nompersonne;
    private String prenompersonne;
    private String genrepersonne;
    private LocalDate datenaisspersonne;
    private String nregistrenational;
    private String civilitepersonne;
    private AdresseDTO adressepersonne;
}
