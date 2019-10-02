package NBIoT.services;

import NBIoT.services.dto.entities.ConfigurationDto;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface ConfigurationProcessService {

    ConfigurationDto process(String json, HttpServletRequest httpServletRequest) throws IOException;
}
