package NBIoT.entities;

import javax.persistence.*;
import java.util.*;
import java.time.LocalDateTime;

@Entity
public class Counter {

    @Id
    private Long sn;

    @OneToMany(mappedBy = "sn")
    private Set<Diagnostic> diagnostics = new HashSet<>();

    private int bat;

    @OneToMany(mappedBy ="counter")
    private List<PulseCounter> ctUp = new ArrayList<>();

    @OneToOne
    private Configuration configuration;

    private int ctDown;

    private int ctAlr;

    private LocalDateTime dateTime;

    private int ctReset;

    private int ctTx;

    private int cellID;

    private int sigPw;

    private int totPw;

    private String alarms;

    private int ecl;

    private int snr;

    private String crc;

    public Counter(){}

    public Long getSn() {
        return sn;
    }

    public int getBat() {
        return bat;
    }

    public int getCtDown() {
        return ctDown;
    }

    public int getCtAlr() {
        return ctAlr;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getCtReset() {
        return ctReset;
    }

    public int getCtTx() {
        return ctTx;
    }

    public int getCellID() {
        return cellID;
    }

    public int getSigPw() {
        return sigPw;
    }

    public int getTotPw() {
        return totPw;
    }

    public String getAlarms() {
        return alarms;
    }

    public String getCrc() {
        return crc;
    }

    public void setSn(Long sn) {
        this.sn = sn;
    }

    public void setBat(int bat) {
        this.bat = bat;
    }

    public void setCtDown(int ctDown) {
        this.ctDown = ctDown;
    }

    public void setCtAlr(int ctAlr) {
        this.ctAlr = ctAlr;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setCtReset(int ctReset) {
        this.ctReset = ctReset;
    }

    public void setCtTx(int ctTx) {
        this.ctTx = ctTx;
    }

    public void setCellID(int cellID) {
        this.cellID = cellID;
    }

    public void setSigPw(int sigPw) {
        this.sigPw = sigPw;
    }

    public void setTotPw(int totPw) {
        this.totPw = totPw;
    }

    public void setAlarms(String alarms) {
        this.alarms = alarms;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    public int getEcl() { return ecl; }

    public int getSnr() { return snr; }

    public void setEcl(int ecl) { this.ecl = ecl; }

    public void setSnr(int snr) { this.snr = snr; }
}