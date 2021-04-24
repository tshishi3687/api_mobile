package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgbd.demo.data_access.entity.Sim;

public interface SimRepository extends JpaRepository<Sim, Integer> {

}
