package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sgbd.demo.business.dto.CycleDTO;
import sgbd.demo.data_access.entity.Cycle_paiement;
import sgbd.demo.data_access.entity.Personne;

import java.time.LocalDate;

public interface CycleRepository extends JpaRepository<Cycle_paiement, Integer> {

    @Modifying
    @Query("update Cycle_paiement u set u.information=?1 where u.id=?2")
    int updatee(CycleDTO cleDTO, int id);
}
