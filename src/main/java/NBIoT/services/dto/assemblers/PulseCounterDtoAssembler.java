package NBIoT.services.dto.assemblers;

import NBIoT.entities.PulseCounter;
import NBIoT.services.dto.entities.PulseCounterDto;

import java.util.List;

public interface PulseCounterDtoAssembler {

    PulseCounter dtoToPulseCounter(PulseCounterDto pulseCounterDto);

    PulseCounterDto pulseCounterToDto(PulseCounter pulseCounter);

    List<PulseCounter> dtoToList(List<PulseCounterDto> dtoList);

    List<PulseCounterDto> listToDto(List<PulseCounter> pulseCounterList);
}
