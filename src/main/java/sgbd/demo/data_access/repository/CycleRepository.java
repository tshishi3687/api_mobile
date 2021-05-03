package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sgbd.demo.data_access.entity.Cycle_paiement;
public interface CycleRepository extends JpaRepository<Cycle_paiement, Integer> {

    @Modifying
    @Query("update Cycle_paiement u set u.information=?1 where u.id=?2")
    void updatee(int info, int id);
}
