package NBIoT.services.implementations;

import NBIoT.repositories.RepositoryFactory;
import NBIoT.services.SavePulseCounterService;
import NBIoT.services.dto.assemblers.PulseCounterDtoAssembler;
import NBIoT.services.dto.entities.PulseCounterDto;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SavePulseCounterServiceServiceImpl implements SavePulseCounterService {

    @Inject
    private PulseCounterDtoAssembler pulseCounterDtoAssembler;

    @Inject
    private RepositoryFactory repositoryFactory;

    @Override
    public void salvePulse(PulseCounterDto pulseCounterDto) {
        repositoryFactory.getPulseCounterRepositories()
                .save(pulseCounterDtoAssembler.dtoToPulseCounter(pulseCounterDto));
    }
}
