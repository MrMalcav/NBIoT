package NBIoT.services;

import NBIoT.services.dto.entities.DiagnosticDto;

public interface SaveDiagnosticService {

    String saveDiagnostic(DiagnosticDto diagnosticDto);
}
