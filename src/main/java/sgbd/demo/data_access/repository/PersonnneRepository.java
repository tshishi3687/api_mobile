package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgbd.demo.data_access.entity.Personne;

import java.util.List;
import java.util.Optional;

public interface PersonnneRepository extends JpaRepository<Personne, Integer> {
    Optional<Personne> findByNregistrenational(int nregistrenational);
    List<Personne> findAllByNompersonne(Personne personne);
    List<Personne> findAllByAdressepersonne_Cpostal(int adressepersonne);
}
