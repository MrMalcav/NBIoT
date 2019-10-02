package NBIoT.services.implementations;

import NBIoT.entities.Configuration;
import NBIoT.repositories.ConfigurationRepository;
import NBIoT.repositories.CounterRepository;
import NBIoT.services.CheckConfigurationService;
import NBIoT.services.dto.assemblers.ConfigurationDtoAssembler;
import NBIoT.services.dto.entities.ConfigurationDto;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CheckConfigurationServiceImpl implements CheckConfigurationService {

    @Inject
    private ConfigurationRepository configurationRepository;

    @Inject
    private ConfigurationDtoAssembler configurationDtoAssembler;

    @Inject
    private CounterRepository counterRepository;

    @Override
    public boolean pending(long sn) {
        List<Configuration> configurationList = configurationRepository.findAllBySn(counterRepository.findById(sn).get());
        if(configurationList == null | configurationList.isEmpty())
            return false;
        else{
            return true;
        }
    }

    @Override
    public ConfigurationDto getConfig(Long sn, HttpServletRequest httpServletRequest) {
        return configurationDtoAssembler.configurationToDto(
                configurationRepository.findAllBySn(counterRepository.findById(sn).get()).get(0),httpServletRequest);
    }

    @Override
    public void delete(Long id) {
        if(configurationRepository.findById(id).isPresent())
            configurationRepository.delete(configurationRepository.findById(id).get());
    }


}
