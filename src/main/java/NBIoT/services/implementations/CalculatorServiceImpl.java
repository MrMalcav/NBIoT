package NBIoT.services.implementations;

import NBIoT.services.CalculatorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {


    @Override
    public int finalValueCalculator(List<Integer> counts, int pos) {
        int res = counts.get(1);
        for (int i = 2; i <= pos ; i++){
            res = res - counts.get(i);
        }
        return res;
    }
}
