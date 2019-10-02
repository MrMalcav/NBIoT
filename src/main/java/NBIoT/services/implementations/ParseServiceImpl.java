package NBIoT.services.implementations;

import NBIoT.services.CorrectorService;
import NBIoT.services.CountFieldsService;
import NBIoT.services.ParseService;
import NBIoT.services.dto.entities.ConfigurationDto;
import NBIoT.services.dto.entities.CounterDto;
import NBIoT.services.dto.entities.DiagnosticDto;
import NBIoT.services.dto.entities.MessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParseServiceImpl implements ParseService {

    @Inject
    private CountFieldsService countFieldsService;

    @Inject
    private CorrectorService correctorService;

    private final static int COUNTER_LINES = 17;

    private final static int DIAGNOSTIC_LINES = 29;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<MessageDto> listParse(List<String> stringList) throws IOException {
        List<MessageDto> messageDtoList = new ArrayList<>();
        for(String a : stringList){
            switch (countFieldsService.count(a)) {
                case COUNTER_LINES:
                    try {
                        messageDtoList.add(objectMapper.readValue(a, CounterDto.class));
                    }catch (com.fasterxml.jackson.databind.exc.MismatchedInputException e ){
                        messageDtoList.add(objectMapper
                                .readValue(correctorService.numberToEmptyList(a),CounterDto.class));
                    }
                    break;
                case DIAGNOSTIC_LINES:
                    try {
                        messageDtoList.add(objectMapper.readValue(a, DiagnosticDto.class));
                    }catch (com.fasterxml.jackson.databind.exc.MismatchedInputException e){
                        messageDtoList.add(objectMapper
                                .readValue(correctorService.numberToEmptyList(a),DiagnosticDto.class));
                    }
                    break;
                default:
                    throw new IOException("unrecognised enter type");
            }
        }

        return messageDtoList;
    }

    @Override
    public ConfigurationDto configurationParse(String json) throws IOException {
        return objectMapper.readValue(json,ConfigurationDto.class);
    }
}
