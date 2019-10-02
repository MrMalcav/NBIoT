package NBIoT.services.dto.assemblers;

import NBIoT.entities.DiagnosticPulseCounter;
import NBIoT.services.dto.entities.DiagnosticPulseCounterDto;

import java.util.List;

public interface DiagnosticPulseCounterDtoAssembler {

    DiagnosticPulseCounter dtoToDPC(DiagnosticPulseCounterDto diagnosticPulseCounterDto);

    DiagnosticPulseCounterDto dPCToDto(DiagnosticPulseCounter diagnosticPulseCounter);

    List<DiagnosticPulseCounter> dtoToList(List<DiagnosticPulseCounterDto> diagnosticPulseCounterDtoList);

    List<DiagnosticPulseCounterDto> listToDto(List<DiagnosticPulseCounter> diagnosticPulseCounterList);
}
