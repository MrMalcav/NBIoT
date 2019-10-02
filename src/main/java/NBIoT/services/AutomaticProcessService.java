package NBIoT.services;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface AutomaticProcessService {

    List<String> process(String json, HttpServletRequest httpServletRequest) throws IOException;

}
