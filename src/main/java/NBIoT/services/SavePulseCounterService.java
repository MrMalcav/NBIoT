package NBIoT.services;

import NBIoT.services.dto.entities.PulseCounterDto;

public interface SavePulseCounterService {

    void salvePulse(PulseCounterDto pulseCounterDto);
}
