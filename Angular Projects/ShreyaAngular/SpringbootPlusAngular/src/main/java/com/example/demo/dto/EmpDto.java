
package com.example.demo.dto;

public class EmpDto {

    private Long eid;
    private String ename;
    private Double esalary;
    private String mname;
    private Long managerId;

    public EmpDto(Long eid, String ename, Double esalary, String mname) {
        this.eid = eid;
        this.ename = ename;
        this.esalary = esalary;
        this.mname = mname;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Double getEsalary() {
        return esalary;
    }

    public void setEsalary(Double esalary) {
        this.esalary = esalary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }
}
