package NBIoT.controllers;

import NBIoT.services.ParseService;
import NBIoT.services.SaveConfigurationService;
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
@RequestMapping("/conf")
public class ConfigurationController {

    @Inject
    private SaveConfigurationService saveConfigurationService;

    @Inject
    private ParseService parseService;

    @PostMapping("/save")
    public ResponseEntity<?> saveConf(@RequestBody String json, HttpServletRequest servletRequest){
        try {
            return new ResponseEntity<>(saveConfigurationService.save(parseService.configurationParse(json)
                    ,servletRequest), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Problema con el json",HttpStatus.BAD_REQUEST);
        }

    }
}