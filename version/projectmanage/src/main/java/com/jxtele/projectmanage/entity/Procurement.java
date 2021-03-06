package com.jxtele.projectmanage.entity;

import java.util.Date;
import java.util.List;

public class Procurement {
    private Integer id;

    private Integer projectId;

    private String contractName;

    private String purchasingMaufacturer;

    private String purchasingContent;

    private Date purchasingTime;

    private Integer status;

    private List<ProcurementItem> procurementItems;

    public List<ProcurementItem> getProcurementItems() {
        return procurementItems;
    }

    public void setProcurementItems(List<ProcurementItem> procurementItems) {
        this.procurementItems = procurementItems;
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

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public String getPurchasingMaufacturer() {
        return purchasingMaufacturer;
    }

    public void setPurchasingMaufacturer(String purchasingMaufacturer) {
        this.purchasingMaufacturer = purchasingMaufacturer == null ? null : purchasingMaufacturer.trim();
    }

    public String getPurchasingContent() {
        return purchasingContent;
    }

    public void setPurchasingContent(String purchasingContent) {
        this.purchasingContent = purchasingContent == null ? null : purchasingContent.trim();
    }

    public Date getPurchasingTime() {
        return purchasingTime;
    }

    public void setPurchasingTime(Date purchasingTime) {
        this.purchasingTime = purchasingTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}