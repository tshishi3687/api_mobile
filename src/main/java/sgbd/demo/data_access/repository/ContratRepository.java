package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgbd.demo.data_access.entity.Contrat;
import sgbd.demo.data_access.entity.Personne;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    Contrat findByAppartient(Personne personne);
}
