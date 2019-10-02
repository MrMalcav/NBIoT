package NBIoT.services;

import NBIoT.services.dto.entities.MessageDto;

import java.util.List;

public interface ReaderService {

    List<String> jsonToList(String json);

}
