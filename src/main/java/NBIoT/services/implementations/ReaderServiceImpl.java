package NBIoT.services.implementations;

import NBIoT.services.ReaderService;
import NBIoT.services.dto.entities.MessageDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> jsonToList(String json) {
        List<String > stringList = new ArrayList<>();
        int i = 0;
        int aux=0;
        if (json.charAt(0) =='{')
            i++;
        while (i < json.length()){
            if(json.charAt(i) == '{')
                aux = i;
            if(json.charAt(i) == '}')
                stringList.add(json.substring(aux,i+1));
            i++;
        }
        return stringList;
    }
}
