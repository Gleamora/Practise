package com.jxtele.projectmanage.entity;

import java.math.BigDecimal;
import java.util.List;

public class Xmpercentage {
    private Integer id;

    private BigDecimal commissionMoney;

    private String reason;

    private Integer projectId;

    //进度名称
    private String process;

    //进度百分比
    private double processPercent;

    private List<XmpercentageItem> xmpercentageItems;

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public double getProcessPercent() {
        return processPercent;
    }

    public void setProcessPercent(double processPercent) {
        this.processPercent = processPercent;
    }

    private List<XmpercentageItem> xmperLists;

    public List<XmpercentageItem> getXmperLists() {
        return xmperLists;
    }

    public void setXmperLists(List<XmpercentageItem> xmperLists) {
        this.xmperLists = xmperLists;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCommissionMoney() {
        return commissionMoney;
    }

    public void setCommissionMoney(BigDecimal commissionMoney) {
        this.commissionMoney = commissionMoney;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public List<XmpercentageItem> getXmpercentageItems() {
        return xmpercentageItems;
    }

    public void setXmpercentageItems(List<XmpercentageItem> xmpercentageItems) {
        this.xmpercentageItems = xmpercentageItems;
    }
}