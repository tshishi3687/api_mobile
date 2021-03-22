package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgbd.demo.data_access.entity.Cycle;

public interface CycleRepository extends JpaRepository<Cycle, Integer> {
}
