package NBIoT.repositories;

import NBIoT.entities.Configuration;
import NBIoT.entities.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfigurationRepository extends JpaRepository<Configuration,Long> {

    List<Configuration> findAllBySn(Counter sn);
}
