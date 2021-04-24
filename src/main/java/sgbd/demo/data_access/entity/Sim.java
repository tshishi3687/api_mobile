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
public class Sim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDate dateactivation;

    @Column
    private String statussim;

    @Column
    private int codepin;

    @Column
    private int codepuk;

    @Column
    private int codepuk2;

    @Column
    private LocalDate datetermination;

    @Column
    private String typecarte;
}
