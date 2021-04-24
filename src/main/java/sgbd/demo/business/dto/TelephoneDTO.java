package sgbd.demo.business.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TelephoneDTO implements identifiedDTO<Integer>{

    private Integer id;
    private String ntelephone;
    private SimDTO sim;
}
