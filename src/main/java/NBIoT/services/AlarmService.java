package NBIoT.services;

public interface AlarmService {

    String getAlarmMessage(int number);

    int getAlarmNumber(String message);
}
