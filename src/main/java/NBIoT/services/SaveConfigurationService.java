package NBIoT.services;

import NBIoT.services.dto.entities.ConfigurationDto;

import javax.servlet.http.HttpServletRequest;

public interface SaveConfigurationService {

    ConfigurationDto save(ConfigurationDto configurationDto, HttpServletRequest httpServletRequest);

}
