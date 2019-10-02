package NBIoT.services.implementations;

import NBIoT.services.CorrectorService;
import org.springframework.stereotype.Service;

@Service
public class CorrectorServiceImpl implements CorrectorService {


    @Override
    public String numberToEmptyList(String json) {
        json = json.replaceFirst("\"ctUp\":\"0\"", "\"ctUp\":[]");
        return json;
    }
}
