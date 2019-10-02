package NBIoT.services.dto.assemblers;

import NBIoT.entities.Diagnostic;
import NBIoT.services.dto.entities.DiagnosticDto;

import java.util.List;

public interface DiagnosticDtoAssembler {

    Diagnostic dtoToDiagnostic(DiagnosticDto diagnosticDto);

    DiagnosticDto diagnosticToDto(Diagnostic diagnostic);

    List<Diagnostic> dtoToDiagnosticList(List<DiagnosticDto> diagnosticDtoList);

    List<DiagnosticDto> diagnosticToDtoList(List<Diagnostic> diagnosticList);
}
