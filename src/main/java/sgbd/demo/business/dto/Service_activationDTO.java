package sgbd.demo.business.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Service_activationDTO implements identifiedDTO<Integer>{

    private Integer id;
    private String transcontacts;
    private String transcredit;
    private String activationsim;
}
