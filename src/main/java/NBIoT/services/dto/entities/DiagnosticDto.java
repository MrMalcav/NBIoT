package NBIoT.services.dto.entities;

import NBIoT.services.MessageVisitorService;

public class DiagnosticDto extends MessageDto{

    public Long id;

    public String mac;

    public int hwVer;

    public int frmVer;

    public Long imei;

    public Long imsi;

    public int ctReset;

    public int ctTx;

    public int ctTxErr;

    public int ctTxRep;

    public int topPw;

    public int commInt;

    public int numMeas;

    public int btAdvInt;

    public int tkaUpdate;

    public int ttgPsm;

    public int userTag;

    @Override
    public String accept(MessageVisitorService messageVisitorService){
       return messageVisitorService.visit(this);
    }

}
