package com.jxtele.projectmanage.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class StandardDay {
    private Integer id;

    private Integer projectId;

    private String standardwork;

    private String workcategory;

    private BigDecimal workingday;

    private Integer teamfrequency;

    private Integer noteamfrequency;

    private BigDecimal teamtime;

    private BigDecimal noteamtime;

    private String workdescription;

    private String address;

    private Date starttime;

    private Date endtime;

    private String remark;

    private String process;

    private String stardtype;

    List<StandardApply> standardApplies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getStandardwork() {
        return standardwork;
    }

    public void setStandardwork(String standardwork) {
        this.standardwork = standardwork == null ? null : standardwork.trim();
    }

    public String getWorkcategory() {
        return workcategory;
    }

    public void setWorkcategory(String workcategory) {
        this.workcategory = workcategory == null ? null : workcategory.trim();
    }

    public BigDecimal getWorkingday() {
        return workingday;
    }

    public void setWorkingday(BigDecimal workingday) {
        this.workingday = workingday;
    }

    public Integer getTeamfrequency() {
        return teamfrequency;
    }

    public void setTeamfrequency(Integer teamfrequency) {
        this.teamfrequency = teamfrequency;
    }

    public Integer getNoteamfrequency() {
        return noteamfrequency;
    }

    public void setNoteamfrequency(Integer noteamfrequency) {
        this.noteamfrequency = noteamfrequency;
    }

    public BigDecimal getTeamtime() {
        return teamtime;
    }

    public void setTeamtime(BigDecimal teamtime) {
        this.teamtime = teamtime;
    }

    public BigDecimal getNoteamtime() {
        return noteamtime;
    }

    public void setNoteamtime(BigDecimal noteamtime) {
        this.noteamtime = noteamtime;
    }

    public String getWorkdescription() {
        return workdescription;
    }

    public void setWorkdescription(String workdescription) {
        this.workdescription = workdescription == null ? null : workdescription.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getStardtype() {
        return stardtype;
    }

    public void setStardtype(String stardtype) {
        this.stardtype = stardtype;
    }

    public List<StandardApply> getStandardApplies() {
        return standardApplies;
    }

    public void setStandardApplies(List<StandardApply> standardApplies) {
        this.standardApplies = standardApplies;
    }
}