package NBIoT.services.dto.assemblers.implementation;

import NBIoT.entities.Configuration;
import NBIoT.repositories.RepositoryFactory;
import NBIoT.services.dto.assemblers.ConfigurationDtoAssembler;
import NBIoT.services.dto.entities.ConfigurationDto;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConfigurationDtoAssemblerImpl implements ConfigurationDtoAssembler {

    @Inject
    private RepositoryFactory repositoryFactory;

    @Override
    public Configuration dtoToConfiguration(ConfigurationDto configurationDto) {
        Configuration configuration = new Configuration();
        if(repositoryFactory.getCounterRepositories()
                .findById(Long.parseLong(configurationDto.sn,16)).isPresent()) {
            configuration.setSn(repositoryFactory.getCounterRepositories()
                    .findById(Long.parseLong(configurationDto.sn, 16)).get());
            configuration.setId(configurationDto.id);
            configuration.setCommInt(configurationDto.commInt);
            configuration.setNumMeas(configurationDto.numMeas);
            configuration.setBtAdvInt(configurationDto.btAdvInt);
            configuration.setTkaUpdate(configurationDto.tkaUpdate);
            configuration.setUserTag(configurationDto.userTag);
            configuration.setCtUp(configurationDto.ctUp);
            configuration.setCtAlr(configurationDto.ctAlr);
            configuration.setCtDown(configurationDto.ctDown);
            configuration.setGetStat(configurationDto.getStat);
            configuration.setBtAdvInt(configurationDto.setBand);
        }
        return configuration;
    }

    @Override
    public ConfigurationDto configurationToDto(Configuration configuration, HttpServletRequest httpRequest) {
        ConfigurationDto configurationDto = new ConfigurationDto();
        if(configuration.getSn() != null) {
            configurationDto.sn = Long.toHexString(configuration.getSn().getSn());
            configurationDto.id = configuration.getId();
            configurationDto.commInt = configuration.getCommInt();
            configurationDto.numMeas = configuration.getNumMeas();
            configurationDto.btAdvInt = configuration.getBtAdvInt();
            configurationDto.tkaUpdate = configuration.getTkaUpdate();
            configurationDto.userTag = configuration.getUserTag();
            configurationDto.ctUp = configuration.isCtUp();
            configurationDto.ctDown = configuration.isCtDown();
            configurationDto.ctAlr = configuration.isCtAlr();
            configurationDto.getStat = configuration.isGetStat();
            configurationDto.setIp = httpRequest.getLocalAddr();
            configurationDto.setPort = httpRequest.getLocalPort();
            configurationDto.setNetOper = configuration.getNOper();
            configurationDto.setBand = configuration.getBand();
            configurationDto.setBand = configuration.getBand();
            configurationDto.updCCfg = 1;
        }
        return configurationDto;
    }

    @Override
    public List<Configuration> dtoToList(List<ConfigurationDto> dtoList) {
        List<Configuration> configurationList = new ArrayList<>();
        for(ConfigurationDto configurationDto : dtoList)
            configurationList.add(dtoToConfiguration(configurationDto));
        return configurationList;
    }

    @Override
    public List<ConfigurationDto> listToDto(List<Configuration> configurations, HttpServletRequest httpRequest) {
        List<ConfigurationDto> configurationDtoList = new ArrayList<>();
        for(Configuration configuration : configurations)
            configurationDtoList.add(configurationToDto(configuration,httpRequest));
        return configurationDtoList;
    }
}
