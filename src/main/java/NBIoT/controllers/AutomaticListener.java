package NBIoT.controllers;

import NBIoT.services.AutomaticProcessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/nbiot")
public class AutomaticListener {

    @Inject
    private AutomaticProcessService automaticProcessService;

    @PostMapping("/save")
    public ResponseEntity<?> automaticInput(@RequestBody String jsons, HttpServletRequest httpServletRequest) throws IOException {

        return new ResponseEntity<>(automaticProcessService.process(jsons, httpServletRequest), HttpStatus.OK);

    }

}
