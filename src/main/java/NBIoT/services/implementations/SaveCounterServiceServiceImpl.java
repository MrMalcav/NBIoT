package NBIoT.services.implementations;

import NBIoT.repositories.RepositoryFactory;
import NBIoT.services.CalculatorService;
import NBIoT.services.SaveCounterService;
import NBIoT.services.dto.assemblers.CounterDtoAssembler;
import NBIoT.services.dto.assemblers.PulseCounterDtoAssembler;
import NBIoT.services.dto.entities.CounterDto;
import NBIoT.services.dto.entities.PulseCounterDto;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class SaveCounterServiceServiceImpl implements SaveCounterService {

    @Inject
    private  RepositoryFactory repositoryFactory;

    @Inject
    private CounterDtoAssembler counterDtoAssembler;

    @Inject
    private PulseCounterDtoAssembler pulseCounterDtoAssembler;

    @Inject
    private CalculatorService calculatorService;

    @Override
    public String saveCounter(CounterDto counterDto) {
        repositoryFactory.getCounterRepositories().save(counterDtoAssembler.dtoToCounter(counterDto));
        PulseCounterDto pulseCounterDto;
        if (counterDto.ctUp != null) {
            if (!counterDto.ctUp.isEmpty())
                if (counterDto.ctUp.size() >= 2) {
                    for (int i = 1; i < counterDto.ctUp.size(); i++) {
                        if (i == 1) {
                            pulseCounterDto = new PulseCounterDto();
                            pulseCounterDto.previousInterval = counterDto.ctUp.get(0);
                            pulseCounterDto.measure = counterDto.ctUp.get(1);
                            pulseCounterDto.counter = Long.parseLong(counterDto.sn,16);
                            repositoryFactory.getPulseCounterRepositories()
                                    .save(pulseCounterDtoAssembler.dtoToPulseCounter(pulseCounterDto));
                        } else {
                            pulseCounterDto = new PulseCounterDto();
                            pulseCounterDto.previousInterval = counterDto.ctUp.get(0);
                            pulseCounterDto.measure = calculatorService.finalValueCalculator(counterDto.ctUp, i);
                            pulseCounterDto.counter = Long.parseLong(counterDto.sn,16);
                            repositoryFactory.getPulseCounterRepositories()
                                    .save(pulseCounterDtoAssembler.dtoToPulseCounter(pulseCounterDto));
                        }
                    }
                }
                if (counterDto.ctUp.size() == 1){
                    pulseCounterDto = new PulseCounterDto();
                    pulseCounterDto.measure = counterDto.ctUp.get(0);
                    repositoryFactory.getPulseCounterRepositories()
                            .save(pulseCounterDtoAssembler.dtoToPulseCounter(pulseCounterDto));
                }
        }
        return counterDto.crc;
    }
}
