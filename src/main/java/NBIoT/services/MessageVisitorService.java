package NBIoT.services;

import NBIoT.services.dto.entities.CounterDto;
import NBIoT.services.dto.entities.DiagnosticDto;

public interface MessageVisitorService {

    String visit (CounterDto counterDto);

    String visit (DiagnosticDto diagnosticDto);
}
