package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgbd.demo.data_access.entity.Info_bancaire;
import java.util.Optional;


public interface Info_bancaireRepository extends JpaRepository<Info_bancaire, Integer> {
    Optional<Info_bancaire> findByAppartient_Nregistrenational(String nregistrenational);
}
