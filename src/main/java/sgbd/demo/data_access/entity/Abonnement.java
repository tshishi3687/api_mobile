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
public class Abonnement {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "msisdn")
    private Telephone msisdn;

    @ManyToOne
    @JoinColumn(name = "serviceusage")
    private Service_usage serviceusage;

    @ManyToOne
    @JoinColumn(name = "serviceactivation")
    private Service_activation serviceactivation;

    @Column
    private LocalDate dateactivation;

}
