package NBIoT.services.implementations;

import NBIoT.services.MessageVisitorService;
import NBIoT.services.SaveCounterService;
import NBIoT.services.SaveDiagnosticService;
import NBIoT.services.dto.entities.CounterDto;
import NBIoT.services.dto.entities.DiagnosticDto;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MessageVisitorServiceServiceImpl implements MessageVisitorService {

    @Inject
    private SaveCounterService saveCounterService = new SaveCounterServiceServiceImpl();

    @Inject
    private SaveDiagnosticService saveDiagnosticService;

    @Override
    public String visit(CounterDto counterDto) {
        return saveCounterService.saveCounter(counterDto);
    }

    @Override
    public String visit(DiagnosticDto diagnosticDto) { return saveDiagnosticService.saveDiagnostic(diagnosticDto);
    }
}
