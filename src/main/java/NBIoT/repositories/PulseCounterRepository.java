package NBIoT.repositories;

import NBIoT.entities.PulseCounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PulseCounterRepository extends JpaRepository<PulseCounter,Long> {
}
