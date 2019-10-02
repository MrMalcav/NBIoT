package NBIoT.services.dto.entities;

import NBIoT.services.MessageVisitorService;

public class CounterDto extends MessageDto{

    public int bat;

    public int ctReset;

    public int cellID;

    @Override
    public String accept(MessageVisitorService messageVisitorService){
       return messageVisitorService.visit(this);
    }
}
