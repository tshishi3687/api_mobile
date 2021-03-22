package sgbd.demo.business.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AbonnementDTO implements identifiedDTO<Integer> {

    private Integer id;
    private TelephoneDTO msisdn;
    private Service_usageDTO serviceusage;
    private Service_activationDTO serviceactivation;
    private LocalDate dateactivation;
}
