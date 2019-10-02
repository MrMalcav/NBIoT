package NBIoT.services;

import NBIoT.services.dto.entities.ConfigurationDto;
import NBIoT.services.dto.entities.MessageDto;

import java.io.IOException;
import java.util.List;

public interface ParseService {

    List<MessageDto> listParse(List<String> stringList) throws IOException;

    ConfigurationDto configurationParse(String json) throws IOException;

}
