package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgbd.demo.data_access.entity.Mode_paiement;

public interface Mode_paiementRepository extends JpaRepository<Mode_paiement, Integer> {
}
