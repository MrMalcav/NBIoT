package NBIoT.services.implementations;

import NBIoT.services.ConfigurationProcessService;
import NBIoT.services.ParseService;
import NBIoT.services.SaveConfigurationService;
import NBIoT.services.dto.entities.ConfigurationDto;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Service
public class ConfigurationProcessServiceImpl implements ConfigurationProcessService {

    @Inject
    private ParseService parseService;

    @Inject
    private SaveConfigurationService saveConfigurationService;

    @Override
    public ConfigurationDto process(String json, HttpServletRequest httpServletRequest) throws IOException {
            return saveConfigurationService.save(parseService.configurationParse(json),httpServletRequest);
    }
}
