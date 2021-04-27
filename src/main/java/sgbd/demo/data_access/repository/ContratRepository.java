package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sgbd.demo.data_access.entity.Contrat;
import sgbd.demo.data_access.entity.Info_bancaire;
import sgbd.demo.data_access.entity.Personne;

import java.time.LocalDate;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    List<Contrat> findByFacturation_Information_Appartient_Nregistrenational(String rNational);
}
