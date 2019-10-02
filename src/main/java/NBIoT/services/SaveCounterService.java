package NBIoT.services;

import NBIoT.services.dto.entities.CounterDto;

public interface SaveCounterService {

    String saveCounter(CounterDto counterDto);
}
