package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgbd.demo.data_access.entity.Telephone;

import java.util.Optional;

public interface TelephoneRepository extends JpaRepository<Telephone, Integer> {
    Optional<Telephone> findByNtelephone(String ntelephone);
}
