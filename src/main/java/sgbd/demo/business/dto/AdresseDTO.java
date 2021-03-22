package sgbd.demo.business.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdresseDTO implements identifiedDTO<Integer>{

    private Integer id;
    private String ville;
    private String rue;
    private int nrue;
    private int cpostal;
    private int nboitelettre;
}
