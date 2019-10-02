package NBIoT.services.dto.assemblers.implementation;

import NBIoT.entities.PulseCounter;
import NBIoT.repositories.RepositoryFactory;
import NBIoT.services.dto.assemblers.PulseCounterDtoAssembler;
import NBIoT.services.dto.entities.PulseCounterDto;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class PulseCounterAssemblerImpl implements PulseCounterDtoAssembler {

    @Inject
    private RepositoryFactory repositoryFactory;


    @Override
    public PulseCounter dtoToPulseCounter(PulseCounterDto pulseCounterDto) {
        PulseCounter pulseCounter = new PulseCounter();
        pulseCounter.setId(pulseCounterDto.id);
        if(repositoryFactory.getCounterRepositories()
                .findById(pulseCounterDto.counter).isPresent())
            pulseCounter.setCounter(repositoryFactory.getCounterRepositories()
                    .findById(pulseCounterDto.counter).get());
        else
            throw new IllegalArgumentException("Lectura de consumo no asociada a contador");
        pulseCounter.setPreviousInterval(pulseCounterDto.previousInterval);
        pulseCounter.setMeasure(pulseCounterDto.measure);
        return pulseCounter;
    }

    @Override
    public PulseCounterDto pulseCounterToDto(PulseCounter pulseCounter) {
        PulseCounterDto pulseCounterDto = new PulseCounterDto();
        pulseCounterDto.id = pulseCounter.getId();
        pulseCounterDto.counter = pulseCounter.getCounter().getSn();
        pulseCounterDto.previousInterval = pulseCounter.getPreviousInterval();
        pulseCounterDto.measure = pulseCounter.getMeasure();
        return pulseCounterDto;
    }

    @Override
    public List<PulseCounter> dtoToList(List<PulseCounterDto> dtoList) {
        List<PulseCounter> pulseCounterList = new ArrayList<>();
        for(PulseCounterDto pulseCounterDto : dtoList)
            pulseCounterList.add(dtoToPulseCounter(pulseCounterDto));
        return pulseCounterList;
    }

    @Override
    public List<PulseCounterDto> listToDto(List<PulseCounter> pulseCounterList) {
        List<PulseCounterDto> pulseCounterDtoList = new ArrayList<>();
        for(PulseCounter pulseCounter : pulseCounterList)
            pulseCounterDtoList.add(pulseCounterToDto(pulseCounter));
        return pulseCounterDtoList;
    }
}
