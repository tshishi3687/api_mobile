package sgbd.demo.data_access.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String ville;

    @Column
    private String rue;

    @Column
    private int nrue;

    @Column
    private int cpostal;

    @Column
    private int nboitelettre;

    @OneToMany(mappedBy = "adressepersonne")
    private List<Personne> quihabite;
}
