package sgbd.demo.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgbd.demo.data_access.entity.Service_usage;

public interface Service_usageRepository extends JpaRepository<Service_usage, Integer> {
}
