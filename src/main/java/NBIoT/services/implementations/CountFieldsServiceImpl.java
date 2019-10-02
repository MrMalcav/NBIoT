package NBIoT.services.implementations;

import NBIoT.services.CountFieldsService;
import org.springframework.stereotype.Service;

@Service
public class CountFieldsServiceImpl implements CountFieldsService {
    @Override
    public int count(String a) {

        int pos;

        int res = 0;

        pos = a.indexOf(":");
        while (pos != -1) {
            res++;
            pos = a.indexOf(":", pos + 1);
        }
        return res;
    }
}
