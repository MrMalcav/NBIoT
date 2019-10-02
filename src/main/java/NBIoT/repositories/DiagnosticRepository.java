package NBIoT.repositories;

import NBIoT.entities.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticRepository extends JpaRepository<Diagnostic,Long> {
}
