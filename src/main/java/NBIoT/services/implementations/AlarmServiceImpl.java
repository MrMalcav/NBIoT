package NBIoT.services.implementations;

import NBIoT.services.AlarmService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {

    private List<String> messages = new ArrayList<>();

    @Inject
    public AlarmServiceImpl(){
        messages.add("Sin alarma");
        messages.add("Sabotaje por imán externo");
        messages.add("Desmontaje");
        messages.add("Conteo inverso");
        messages.add("Fallo de sensores");
        messages.add("Sin asignar");
        messages.add("Sin asignar");
        messages.add("Sin asignar");
        messages.add("Fallo NBIoT");
    }

    @Override
    public String getAlarmMessage(int number) {
        if(number<messages.size() && number>=0)
            return messages.get(number);
        else
            return "Sin asignar";
    }

    @Override
    public int getAlarmNumber(String message) {
        for(int i = 0 ; i< messages.size() ; i++){
            if(messages.get(i).equals(message))
                return i;
        }
        return -1;
    }
}
