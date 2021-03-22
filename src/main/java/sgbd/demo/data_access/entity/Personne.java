package sgbd.demo.data_access.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nompersonne;

    @Column
    private String prenompersonne;

    @Column
    private String genrepersonne;

    @Column
    private LocalDate datenaisspersonne;

    @Column
    private int nregistrenational;

    @Column
    private String civilitepersonne;

    @ManyToOne
    @JoinColumn(name = "adressepersonne")
    private Adresse adressepersonne;

    @Column
    private String statutpersonne;

    @Column
    private String mdp;

    @OneToMany(mappedBy = "appartient")
    private List<Contrat> contratList;
}
