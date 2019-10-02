package NBIoT.services;

import NBIoT.services.dto.entities.ConfigurationDto;

import javax.servlet.http.HttpServletRequest;

public interface CheckConfigurationService {
    boolean pending(long sn);

    ConfigurationDto getConfig(Long sn, HttpServletRequest httpServletRequest);

    void delete(Long sn);
}
