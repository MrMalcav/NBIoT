package NBIoT.services.dto.assemblers.implementation;

import NBIoT.entities.Diagnostic;
import NBIoT.repositories.RepositoryFactory;
import NBIoT.services.AlarmService;
import NBIoT.services.dto.assemblers.DiagnosticDtoAssembler;
import NBIoT.services.dto.entities.DiagnosticDto;
import NBIoT.services.implementations.AlarmServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiagnosticAssemblerImpl implements DiagnosticDtoAssembler {

    @Inject
    private RepositoryFactory repositoryFactory;

    private AlarmService alarmService = new AlarmServiceImpl();

    @Override
    public Diagnostic dtoToDiagnostic(DiagnosticDto diagnosticDto) {
        Diagnostic diagnostic = new Diagnostic();
        diagnostic.setId(diagnostic.getId());
        if(repositoryFactory.getCounterRepositories().findById(Long.parseLong(diagnosticDto.sn,16)).isPresent())
            diagnostic.setSn(repositoryFactory.getCounterRepositories()
                    .findById(Long.parseLong(diagnosticDto.sn,16)).get());
        else
            throw new IllegalArgumentException("Diagnostico sin contador");
        diagnostic.setMac(Long.parseLong(diagnosticDto.mac,16));
        diagnostic.setHwVer(diagnosticDto.hwVer);
        diagnostic.setFrmVer(diagnosticDto.frmVer);
        diagnostic.setImei(diagnosticDto.imei);
        diagnostic.setImsi(diagnosticDto.imsi);
        diagnostic.setCtReset(diagnosticDto.ctReset);
        diagnostic.setCtTx(diagnosticDto.ctTx);
        diagnostic.setCtTxErr(diagnosticDto.ctTxErr);
        diagnostic.setCtTxRep(diagnosticDto.ctTxRep);
        diagnostic.setCellId(diagnosticDto.cellId);
        diagnostic.setSigPw(diagnosticDto.sigPw);
        diagnostic.setTopPw(diagnosticDto.topPw);
        diagnostic.setAlarms(alarmService.getAlarmMessage(diagnosticDto.alarms));
        diagnostic.setCommInt(diagnosticDto.commInt);
        diagnostic.setNumMeas(diagnosticDto.numMeas);
        diagnostic.setBtAdvInt(diagnosticDto.btAdvInt);
        diagnostic.setTkaUpdate(diagnosticDto.tkaUpdate);
        diagnostic.setTtgPsm(diagnosticDto.ttgPsm);
        diagnostic.setUserTag(diagnosticDto.userTag);
        diagnostic.setEcl(diagnosticDto.ecl);
        diagnostic.setSnr(diagnosticDto.snr);
        diagnostic.setCrc(diagnosticDto.crc);
        return diagnostic;
    }

    @Override
    public DiagnosticDto diagnosticToDto(Diagnostic diagnostic) {
        DiagnosticDto diagnosticDto = new DiagnosticDto();
        diagnosticDto.id = diagnostic.getId();
        diagnosticDto.sn = Long.toHexString(diagnostic.getSn().getSn());
        diagnosticDto.mac = Long.toHexString(diagnostic.getMac());
        diagnosticDto.hwVer = diagnostic.getHwVer();
        diagnosticDto.frmVer = diagnostic.getFrmVer();
        diagnosticDto.imei = diagnostic.getImei();
        diagnosticDto.imsi = diagnostic.getImsi();
        diagnosticDto.ctReset = diagnostic.getCtReset();
        diagnosticDto.ctReset = diagnostic.getCtReset();
        diagnosticDto.ctTx = diagnostic.getCtTx();
        diagnosticDto.ctTxErr = diagnostic.getCtTxErr();
        diagnosticDto.ctTxRep = diagnostic.getCtTxRep();
        diagnosticDto.cellId = diagnostic.getCellId();
        diagnosticDto.sigPw = diagnostic.getSigPw();
        diagnosticDto.topPw = diagnostic.getTopPw();
        diagnosticDto.alarms = alarmService.getAlarmNumber(diagnostic.getAlarms());
        diagnosticDto.commInt = diagnostic.getCommInt();
        diagnosticDto.numMeas = diagnostic.getNumMeas();
        diagnosticDto.btAdvInt = diagnostic.getBtAdvInt();
        diagnosticDto.tkaUpdate = diagnostic.getTkaUpdate();
        diagnosticDto.ttgPsm = diagnostic.getTtgPsm();
        diagnosticDto.userTag = diagnostic.getUserTag();
        diagnosticDto.ecl = diagnostic.getEcl();
        diagnosticDto.snr = diagnostic.getSnr();
        diagnosticDto.crc = diagnostic.getCrc();
        return diagnosticDto;
    }

    @Override
    public List<Diagnostic> dtoToDiagnosticList(List<DiagnosticDto> diagnosticDtoList) {
        List<Diagnostic> diagnosticList = new ArrayList<>();
        for(DiagnosticDto diagnosticDto: diagnosticDtoList)
            diagnosticList.add(dtoToDiagnostic(diagnosticDto));
        return diagnosticList;
    }

    @Override
    public List<DiagnosticDto> diagnosticToDtoList(List<Diagnostic> diagnosticList) {
        List<DiagnosticDto> diagnosticDtoList = new ArrayList<>();
        for(Diagnostic diagnostic : diagnosticList)
            diagnosticDtoList.add(diagnosticToDto(diagnostic));
        return diagnosticDtoList;
    }
}
