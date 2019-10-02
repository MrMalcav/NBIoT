package NBIoT.repositories;

import NBIoT.entities.DiagnosticPulseCounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticPulseCounterRepository extends JpaRepository<DiagnosticPulseCounter,Long> {
}
