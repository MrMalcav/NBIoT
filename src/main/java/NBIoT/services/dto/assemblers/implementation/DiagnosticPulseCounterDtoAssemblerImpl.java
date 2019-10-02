package NBIoT.services.dto.assemblers.implementation;

import NBIoT.entities.DiagnosticPulseCounter;
import NBIoT.repositories.RepositoryFactory;
import NBIoT.services.dto.assemblers.DiagnosticPulseCounterDtoAssembler;
import NBIoT.services.dto.entities.DiagnosticPulseCounterDto;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiagnosticPulseCounterDtoAssemblerImpl implements DiagnosticPulseCounterDtoAssembler {

    @Inject
    private RepositoryFactory repositoryFactory;

    @Override
    public DiagnosticPulseCounter dtoToDPC(DiagnosticPulseCounterDto diagnosticPulseCounterDto) {
        DiagnosticPulseCounter diagnosticPulseCounter = new DiagnosticPulseCounter();
        diagnosticPulseCounter.setId(diagnosticPulseCounterDto.id);
        if(repositoryFactory.getDiagnosticRepositories()
                .findById(diagnosticPulseCounterDto.diagnostic).isPresent())
            diagnosticPulseCounter.setDiagnostic(repositoryFactory.getDiagnosticRepositories()
                .findById(diagnosticPulseCounterDto.diagnostic).get());
        if(repositoryFactory.getCounterRepositories().findById(diagnosticPulseCounterDto.counter).isPresent())
            diagnosticPulseCounter.setCounter(repositoryFactory.getCounterRepositories()
                    .findById(diagnosticPulseCounterDto.counter).get());
        diagnosticPulseCounter.setMeasure(diagnosticPulseCounterDto.measure);
        diagnosticPulseCounter.setPreviousInterval(diagnosticPulseCounterDto.previousInterval);
        return diagnosticPulseCounter;
    }

    @Override
    public DiagnosticPulseCounterDto dPCToDto(DiagnosticPulseCounter diagnosticPulseCounter) {

        DiagnosticPulseCounterDto diagnosticPulseCounterDto = new DiagnosticPulseCounterDto();
        diagnosticPulseCounterDto.id = diagnosticPulseCounter.getId();
        diagnosticPulseCounterDto.measure = diagnosticPulseCounter.getMeasure();
        diagnosticPulseCounterDto.previousInterval = diagnosticPulseCounter.getPreviousInterval();
        if(diagnosticPulseCounter.getCounter() != null)
            diagnosticPulseCounterDto.counter = diagnosticPulseCounter.getCounter().getSn();
        if(diagnosticPulseCounter.getDiagnostic() != null)
            diagnosticPulseCounterDto.diagnostic = diagnosticPulseCounter.getDiagnostic().getId();
        return diagnosticPulseCounterDto;
    }

    @Override
    public List<DiagnosticPulseCounter> dtoToList(List<DiagnosticPulseCounterDto> diagnosticPulseCounterDtoList) {
        List<DiagnosticPulseCounter> diagnosticPulseCounterList = new ArrayList<>();
        for(DiagnosticPulseCounterDto diagnosticPulseCounterDto: diagnosticPulseCounterDtoList){
            diagnosticPulseCounterList.add(dtoToDPC(diagnosticPulseCounterDto));
        }
        return diagnosticPulseCounterList;
    }

    @Override
    public List<DiagnosticPulseCounterDto> listToDto(List<DiagnosticPulseCounter> diagnosticPulseCounterList) {
        List<DiagnosticPulseCounterDto> diagnosticPulseCounterDtoList = new ArrayList<>();
        for(DiagnosticPulseCounter diagnosticPulseCounter : diagnosticPulseCounterList)
            diagnosticPulseCounterDtoList.add(dPCToDto(diagnosticPulseCounter));
        return diagnosticPulseCounterDtoList;
    }
}
