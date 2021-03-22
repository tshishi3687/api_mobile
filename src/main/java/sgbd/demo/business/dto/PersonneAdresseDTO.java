package sgbd.demo.business.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonneAdresseDTO implements identifiedDTO<Integer>{

    private Integer id;
    private String nompersonne;
    private String prenompersonne;
    private String genrepersonne;
}
