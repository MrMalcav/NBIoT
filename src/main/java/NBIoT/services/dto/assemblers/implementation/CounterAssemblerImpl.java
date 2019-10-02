package NBIoT.services.dto.assemblers.implementation;

import NBIoT.entities.Counter;
import NBIoT.services.AlarmService;
import NBIoT.services.dto.assemblers.CounterDtoAssembler;
import NBIoT.services.dto.entities.CounterDto;
import NBIoT.services.implementations.AlarmServiceImpl;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



@Service
public class CounterAssemblerImpl implements CounterDtoAssembler {

    private final AlarmService alarmService = new AlarmServiceImpl();

        private DateTimeFormatter format = DateTimeFormatter.ofPattern("yy/MM/dd,HH:mm:ssX");

    @Override
    public Counter dtoToCounter(CounterDto counterDto) {
        Counter counter = new Counter();
        counter.setSn(Long.parseLong(counterDto.sn,16));
        counter.setBat(counterDto.bat);
        counter.setCtDown(counterDto.ctDown);
        counter.setCtAlr(counterDto.ctAlr);
        counter.setDateTime(LocalDateTime.parse(counterDto.dateTime, format));
        counter.setCtReset(counterDto.ctReset);
        counter.setCtTx(counterDto.ctTx);
        counter.setCellID(counterDto.cellID);
        counter.setSigPw(counterDto.sigPw);
        counter.setTotPw(counterDto.totPw);
        counter.setAlarms(alarmService.getAlarmMessage(counterDto.alarms));
        counter.setEcl(counterDto.ecl);
        counter.setSnr(counterDto.snr);
        counter.setCrc(counterDto.crc);
        return counter;
    }

    @Override
    public CounterDto counterToDto(Counter counter) {
        CounterDto counterDto= new CounterDto();
        counterDto.sn = Long.toHexString(counter.getSn());
        counterDto.bat = counter.getBat();
        counterDto.ctDown = counter.getCtDown();
        counterDto.ctAlr = counter.getCtAlr();
        counterDto.dateTime = counter.getDateTime().toString();
        counterDto.ctReset = counter.getCtReset();
        counterDto.ctTx = counter.getCtTx();
        counterDto.cellID = counter.getCellID();
        counterDto.sigPw = counter.getSigPw();
        counterDto.totPw = counter.getTotPw();
        counterDto.alarms = alarmService.getAlarmNumber(counter.getAlarms());
        counterDto.ecl = counter.getEcl();
        counterDto.snr = counter.getSnr();
        counterDto.crc = counter.getCrc();
        return counterDto;
    }

    @Override
    public List<Counter> dtoToCounterList(List<CounterDto> counterDtoList) {
        List<Counter>counterList = new ArrayList<>();
        for(CounterDto counterDto : counterDtoList)
            counterList.add(dtoToCounter(counterDto));
        return counterList;
    }

    @Override
    public List<CounterDto> counterListToDto(List<Counter> counterList) {
        List<CounterDto> counterDtoList = new ArrayList<>();
        for(Counter counter : counterList)
            counterDtoList.add(counterToDto(counter));
        return counterDtoList;
    }
}
