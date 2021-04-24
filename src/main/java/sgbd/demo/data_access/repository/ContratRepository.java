package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgbd.demo.data_access.entity.Contrat;
import sgbd.demo.data_access.entity.Personne;

import java.util.List;
import java.util.Optional;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    List<Contrat> findByFacturation_Information_Appartient_Nregistrenational(String rNational);
}
