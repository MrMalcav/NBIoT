package NBIoT.services.implementations;

import NBIoT.services.*;
import NBIoT.services.dto.entities.ConfigurationDto;
import NBIoT.services.dto.entities.MessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutomaticProcessServiceImpl implements AutomaticProcessService {

    @Inject
    private ReaderService readerService;

    @Inject
    private ParseService parseService;

    @Inject
    private MessageVisitorService messageVisitorService;

    @Inject
    private CheckConfigurationService checkConfigurationService;

    @Override
    public List<String> process(String json, HttpServletRequest httpServletRequest) throws IOException {
        List<String> res = new ArrayList<>();
        List<String> jsonList = readerService.jsonToList(json);
        List<MessageDto> messageDtoList= parseService.listParse(jsonList);
        ObjectMapper objectMapper = new ObjectMapper();
        for(MessageDto messageDto:messageDtoList) {
            res.add(messageDto.accept(messageVisitorService));
            if(checkConfigurationService.pending(Long.parseLong(messageDto.sn,16))){
                ConfigurationDto configurationDto =checkConfigurationService.getConfig(Long
                        .parseLong(messageDto.sn,16),httpServletRequest);
                res.add(objectMapper.writeValueAsString(configurationDto));
                checkConfigurationService.delete(configurationDto.id);
            }
        }
        return res;
    }
}
