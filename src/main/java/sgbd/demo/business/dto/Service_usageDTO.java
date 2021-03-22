package sgbd.demo.business.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Service_usageDTO implements identifiedDTO<Integer>{

    private Integer id;
    private String creditappelle;
    private String creditdata;
    private String creditsms;
    private String creditmms;
    private String credititinerance;
}
