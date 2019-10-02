package NBIoT.services.dto.assemblers;

import NBIoT.entities.Configuration;
import NBIoT.entities.Counter;
import NBIoT.services.dto.entities.CounterDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterDtoAssembler {

    Counter dtoToCounter(CounterDto counterDto);

    CounterDto counterToDto(Counter counter);

    List<Counter> dtoToCounterList(List<CounterDto> counterDtoList);

    List<CounterDto> counterListToDto(List<Counter> counterList);
}
