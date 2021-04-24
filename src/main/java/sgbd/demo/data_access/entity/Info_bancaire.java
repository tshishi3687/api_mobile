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
public class Info_bancaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "appartient")
    private Personne appartient;

    @Column
    private String compte;

    @Column
    private int domiciliation;

    @Column
    private String statusdomiciliation;

    @Column
    private String banque;

    @Column
    private String Credit;

    @Column
    private LocalDate expiration;
}
