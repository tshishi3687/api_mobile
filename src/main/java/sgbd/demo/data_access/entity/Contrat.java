package sgbd.demo.data_access.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDate datesignature;

    @Column
    private LocalDate datedebut;

    @Column
    private LocalDate datefin;

    @ManyToOne
    @JoinColumn(name = "abonnement")
    private Abonnement abonnement;

    @ManyToOne
    @JoinColumn(name = "facturation")
    private Cycle facturation;

    @ManyToOne
    @JoinColumn(name = "appartient")
    private Personne appartient;
}
