package NBIoT.entities;

import javax.persistence.*;

@Entity
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Counter sn;

    private int commInt;

    private int numMeas;

    private int btAdvInt;

    private int tkaUpdate;

    private int userTag;

    private boolean ctUp;

    private boolean ctDown;

    private boolean ctAlr;

    private boolean getStat;

    private int nOper;

    private int band;

    public Configuration() {}

    public Long getId() {
        return id;
    }

    public Counter getSn() {
        return sn;
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

    public int getUserTag() {
        return userTag;
    }

    public boolean isCtUp() {
        return ctUp;
    }

    public boolean isCtDown(){
        return ctDown;
    }

    public boolean isCtAlr() {
        return ctAlr;
    }

    public boolean isGetStat() {
        return getStat;
    }

    public int getNOper() { return  nOper;}

    public int getBand() { return band;}

    public void setId(Long id) {
        this.id = id;
    }

    public void setSn(Counter sn) { this.sn = sn; }

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

    public void setUserTag(int userTag) {
        this.userTag = userTag;
    }

    public void setCtUp(boolean ctUp) {
        this.ctUp = ctUp;
    }

    public void setCtDown(boolean ctDown){
        this.ctDown = ctDown;
    }

    public void setCtAlr(boolean ctAlr) {
        this.ctAlr = ctAlr;
    }

    public void setGetStat(boolean getStat) {
        this.getStat = getStat;
    }

    public void setNOper(int nOper) { this.nOper = nOper;}

    public void setBand(int band) { this.band = band;}
}
