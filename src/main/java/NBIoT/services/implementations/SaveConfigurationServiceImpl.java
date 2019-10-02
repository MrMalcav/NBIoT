package NBIoT.services.implementations;

import NBIoT.repositories.RepositoryFactory;
import NBIoT.services.SaveConfigurationService;
import NBIoT.services.dto.assemblers.ConfigurationDtoAssembler;
import NBIoT.services.dto.entities.ConfigurationDto;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Service
public class SaveConfigurationServiceImpl implements SaveConfigurationService {

    @Inject
    private RepositoryFactory repositoryFactory;

    @Inject
    private ConfigurationDtoAssembler configurationDtoAssembler;

    @Override
    public ConfigurationDto save(ConfigurationDto configurationDto, HttpServletRequest httpServletRequest) {
        return configurationDtoAssembler.configurationToDto(repositoryFactory.getConfigurationRepository()
                .save(configurationDtoAssembler.dtoToConfiguration(configurationDto)), httpServletRequest);
    }
}
