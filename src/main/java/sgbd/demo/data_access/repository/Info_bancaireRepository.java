package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sgbd.demo.data_access.entity.Adresse;
import sgbd.demo.data_access.entity.Info_bancaire;

import java.util.List;
import java.util.Optional;


public interface Info_bancaireRepository extends JpaRepository<Info_bancaire, Integer> {
    Optional<Info_bancaire> findByAppartient_Nregistrenational(String nregistrenational);
}
