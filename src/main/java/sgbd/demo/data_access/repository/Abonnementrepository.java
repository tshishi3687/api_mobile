package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgbd.demo.data_access.entity.Abonnement;

public interface Abonnementrepository extends JpaRepository<Abonnement, Integer> {
}
