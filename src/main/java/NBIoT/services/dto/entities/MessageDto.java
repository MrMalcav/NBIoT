package NBIoT.services.dto.entities;

import NBIoT.services.MessageVisitorService;

import java.util.ArrayList;
import java.util.List;

public abstract class MessageDto {

    public String sn;

    public List<Integer> ctUp = new ArrayList<>();

    public int ctDown;

    public int ctAlr;

    public int ctTx;

    public String dateTime;

    public int cellId;

    public int totPw;

    public int sigPw;

    public int alarms;

    public int ecl;

    public int snr;

    public String crc;

    public abstract String accept(MessageVisitorService messageVisitorService);
}
