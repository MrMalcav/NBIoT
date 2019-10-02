package NBIoT.services.dto.assemblers;

import NBIoT.entities.Configuration;
import NBIoT.services.dto.entities.ConfigurationDto;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ConfigurationDtoAssembler {

    Configuration dtoToConfiguration(ConfigurationDto configurationDto);

    ConfigurationDto configurationToDto(Configuration configuration, HttpServletRequest httpRequest);

    List<Configuration> dtoToList(List<ConfigurationDto> dtoList);

    List<ConfigurationDto> listToDto(List<Configuration> configurations, HttpServletRequest httpRequest);

}
