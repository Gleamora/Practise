package com.jxtele.projectmanage.entity;

import java.math.BigDecimal;
import java.util.List;

public class Integral {
    private Integer id;

    private Integer projectId;

    private Integer moninfoId;

    private BigDecimal integralmoney;

    private String reason;

    private String process;

    private List<IntegralItem> integralItems;

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

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

    public Integer getMoninfoId() {
        return moninfoId;
    }

    public void setMoninfoId(Integer moninfoId) {
        this.moninfoId = moninfoId;
    }

    public BigDecimal getIntegralmoney() {
        return integralmoney;
    }

    public void setIntegralmoney(BigDecimal integralmoney) {
        this.integralmoney = integralmoney;
    }

    public String getReason() {
        return reason;
    }

    public List<IntegralItem> getIntegralItems() {
        return integralItems;
    }

    public void setIntegralItems(List<IntegralItem> integralItems) {
        this.integralItems = integralItems;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}