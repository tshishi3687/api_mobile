package sgbd.demo.data_access.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cycle {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int id;

    @Column
    private String tempscycle;

    @ManyToOne
    @JoinColumn(name = "modepaiement")
    private Mode_paiement modepaiement;

    @Column
    private String information;
}
