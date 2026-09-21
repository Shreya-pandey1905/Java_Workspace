package model;

public class emp {

    private int eId;
    private String eName;
    private Double esal;
    private int mid;

    public emp(int eId, String eName, Double esal, int mid) {
        this.eId = eId;
        this.eName = eName;
        this.esal = esal;
        this.mid = mid;
    }

    public int getEid() {
        return eId;
    }

    public void setEid(int eId) {
        this.eId = eId;
    }

    public String getEname() {
        return eName;
    }

    public void setEname(String eName) {
        this.eName = eName;
    }

    public Double getEsal() {
        return esal;
    }

    public void setEsal(Double esal) {
        this.esal = esal;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }
}