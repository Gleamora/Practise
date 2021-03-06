package com.jxtele.projectmanage.entity;

import java.util.Date;
import java.util.List;

public class CommunicationRecord {

    public static final String module="record";

    private Integer id;

    private Integer communicationId;

    private Date communicationtime;

    private String content;

    private String comobject;

    private String comform;

    private String comname;

    private String comresult;

    private String nextwork;

    private Integer effective;

    private Integer projectId;

    private Integer exitfile;

    private List<AttachmentFile> recordattachmentFiles;

    public List<AttachmentFile> getRecordattachmentFiles() {
        return recordattachmentFiles;
    }

    public void setRecordattachmentFiles(List<AttachmentFile> recordattachmentFiles) {
        this.recordattachmentFiles = recordattachmentFiles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(Integer communicationId) {
        this.communicationId = communicationId;
    }

    public Date getCommunicationtime() {
        return communicationtime;
    }

    public void setCommunicationtime(Date communicationtime) {
        this.communicationtime = communicationtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getComobject() {
        return comobject;
    }

    public void setComobject(String comobject) {
        this.comobject = comobject == null ? null : comobject.trim();
    }

    public String getComform() {
        return comform;
    }

    public void setComform(String comform) {
        this.comform = comform == null ? null : comform.trim();
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname == null ? null : comname.trim();
    }

    public String getComresult() {
        return comresult;
    }

    public void setComresult(String comresult) {
        this.comresult = comresult == null ? null : comresult.trim();
    }

    public String getNextwork() {
        return nextwork;
    }

    public void setNextwork(String nextwork) {
        this.nextwork = nextwork == null ? null : nextwork.trim();
    }

    public Integer getEffective() {
        return effective;
    }

    public void setEffective(Integer effective) {
        this.effective = effective;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getExitfile() {
        return exitfile;
    }

    public void setExitfile(Integer exitfile) {
        this.exitfile = exitfile;
    }
}