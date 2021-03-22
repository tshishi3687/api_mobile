package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgbd.demo.data_access.entity.Adresse;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
}
