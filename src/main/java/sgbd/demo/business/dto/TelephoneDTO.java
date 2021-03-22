package sgbd.demo.business.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TelephoneDTO implements identifiedDTO<Integer>{

    private Integer id;
    private String ntelephone;
}
