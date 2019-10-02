package NBIoT.services.implementations;

import NBIoT.repositories.RepositoryFactory;
import NBIoT.services.CalculatorService;
import NBIoT.services.SaveDiagnosticService;
import NBIoT.services.dto.assemblers.DiagnosticDtoAssembler;
import NBIoT.services.dto.assemblers.DiagnosticPulseCounterDtoAssembler;
import NBIoT.services.dto.entities.DiagnosticDto;
import NBIoT.services.dto.entities.DiagnosticPulseCounterDto;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SaveDiagnosticServiceServiceImpl implements SaveDiagnosticService {

    @Inject
    private RepositoryFactory repositoryFactory;

    @Inject
    private DiagnosticDtoAssembler diagnosticDtoAssembler;

    @Inject
    private DiagnosticPulseCounterDtoAssembler diagnosticPulseCounterDtoAssembler;

    @Inject
    private CalculatorService calculatorService;

    @Override
    public String saveDiagnostic(DiagnosticDto diagnosticDto) {
        repositoryFactory.getDiagnosticRepositories().save(diagnosticDtoAssembler.dtoToDiagnostic(diagnosticDto));
        DiagnosticPulseCounterDto diagnosticPulseCounterDto;
        if(diagnosticDto.ctUp != null)
            if(!diagnosticDto.ctUp.isEmpty())
                if(diagnosticDto.ctUp.size()>=2) {
                    for(int i = 1 ; i < diagnosticDto.ctUp.size(); i++) {
                        if(i == 1) {
                            diagnosticPulseCounterDto = new DiagnosticPulseCounterDto();
                            diagnosticPulseCounterDto.counter = Long.parseLong(diagnosticDto.sn,16);
                            diagnosticPulseCounterDto.diagnostic = diagnosticDto.id;
                            diagnosticPulseCounterDto.previousInterval = diagnosticDto.ctUp.get(0);
                            diagnosticPulseCounterDto.measure = diagnosticDto.ctUp.get(1);
                        } else {
                            diagnosticPulseCounterDto = new DiagnosticPulseCounterDto();
                            diagnosticPulseCounterDto.counter = Long.parseLong(diagnosticDto.sn,16);
                            diagnosticPulseCounterDto.diagnostic = diagnosticDto.id;
                            diagnosticPulseCounterDto.previousInterval = diagnosticDto.ctUp.get(0);
                            diagnosticPulseCounterDto.measure = calculatorService.finalValueCalculator(diagnosticDto.ctUp,i);
                            repositoryFactory.getPulseCounterRepositories()
                                    .save(diagnosticPulseCounterDtoAssembler.dtoToDPC(diagnosticPulseCounterDto));
                        }
                    }
                }
        return diagnosticDto.crc;
    }

}
