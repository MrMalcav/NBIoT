package NBIoT.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Diagnostic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Counter sn;

    @OneToMany(mappedBy = "diagnostic")
    private List<DiagnosticPulseCounter> diagnosticPulseCounter = new ArrayList<>();

    private Long mac;

    private int hwVer;

    private int frmVer;

    private Long imei;

    private Long imsi;

    private int ctReset;

    private int CtTx;

    private int ctTxErr;

    private int ctTxRep;

    private int cellId;

    private int sigPw;

    private int topPw;

    private String alarms;

    private int commInt;

    private int numMeas;

    private int btAdvInt;

    private int tkaUpdate;

    private int ttgPsm;

    private int userTag;

    private int ecl;

    private int snr;

    private String crc;

    public Diagnostic(){}

    public Long getId() {
        return id;
    }

    public Counter getSn() {
        return sn;
    }

    public Long getMac() {
        return mac;
    }

    public int getHwVer() {
        return hwVer;
    }

    public int getFrmVer() {
        return frmVer;
    }

    public Long getImei() {
        return imei;
    }

    public Long getImsi() {
        return imsi;
    }

    public int getCtReset() {
        return ctReset;
    }

    public int getCtTx() {
        return CtTx;
    }

    public int getCtTxErr() {
        return ctTxErr;
    }

    public int getCtTxRep() {
        return ctTxRep;
    }

    public int getCellId() {
        return cellId;
    }

    public int getSigPw() {
        return sigPw;
    }

    public int getTopPw() {
        return topPw;
    }

    public String getAlarms() {
        return alarms;
    }

    public int getCommInt() {
        return commInt;
    }

    public int getNumMeas() {
        return numMeas;
    }

    public int getBtAdvInt() {
        return btAdvInt;
    }

    public int getTkaUpdate() {
        return tkaUpdate;
    }

    public int getTtgPsm() {
        return ttgPsm;
    }

    public int getUserTag() { return userTag; }

    public int getEcl() { return ecl; }

    public int getSnr() { return snr;}

    public String getCrc() {
        return crc;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSn(Counter sn) {
        this.sn = sn;
    }

    public void setMac(Long mac) {
        this.mac = mac;
    }

    public void setHwVer(int hwVer) {
        this.hwVer = hwVer;
    }

    public void setFrmVer(int frmVer) {
        this.frmVer = frmVer;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public void setImsi(Long imsi) {
        this.imsi = imsi;
    }

    public void setCtReset(int ctReset) {
        this.ctReset = ctReset;
    }

    public void setCtTx(int ctTx) {
        CtTx = ctTx;
    }

    public void setCtTxErr(int ctTxErr) {
        this.ctTxErr = ctTxErr;
    }

    public void setCtTxRep(int ctTxRep) {
        this.ctTxRep = ctTxRep;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    public void setSigPw(int sigPw) {
        this.sigPw = sigPw;
    }

    public void setTopPw(int topPw) {
        this.topPw = topPw;
    }

    public void setAlarms(String alarms) {
        this.alarms = alarms;
    }

    public void setCommInt(int commInt) {
        this.commInt = commInt;
    }

    public void setNumMeas(int numMeas) {
        this.numMeas = numMeas;
    }

    public void setBtAdvInt(int btAdvInt) {
        this.btAdvInt = btAdvInt;
    }

    public void setTkaUpdate(int tkaUpdate) {
        this.tkaUpdate = tkaUpdate;
    }

    public void setTtgPsm(int ttgPsm) {
        this.ttgPsm = ttgPsm;
    }

    public void setUserTag(int userTag) {
        this.userTag = userTag;
    }

    public void setEcl(int ecl) { this.ecl = ecl; }

    public void setSnr(int snr) { this.snr = snr; }

    public void setCrc(String crc) {
        this.crc = crc;
    }
}
