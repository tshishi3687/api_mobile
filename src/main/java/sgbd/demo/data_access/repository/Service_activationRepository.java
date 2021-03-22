package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgbd.demo.data_access.entity.Service_activation;

public interface Service_activationRepository extends JpaRepository<Service_activation, Integer> {
}
