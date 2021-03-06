package com.jxtele.projectmanage.service.impl;

import com.jxtele.projectmanage.dao.CommunicationRecordMapper;
import com.jxtele.projectmanage.entity.AttachmentFile;
import com.jxtele.projectmanage.entity.CommunicationRecord;
import com.jxtele.projectmanage.entity.ResponseModel;
import com.jxtele.projectmanage.service.IAttachmentFileService;
import com.jxtele.projectmanage.service.ICommunicationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommunicationRecordService implements ICommunicationRecordService {

    @Autowired
    private  CommunicationRecordMapper communicationRecordMapper;


    @Autowired
    private IAttachmentFileService attachmentFileService;

    @Override
    public Map<String, Object> deleteByPrimaryKey(Integer id) {
        try {
            if(id == null){
                return ResponseModel.getModel("你请求的是一个冒牌接口", "failed", null);
            }
            attachmentFileService.deleteByrefid(id);
            communicationRecordMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public Map<String, Object> insert(CommunicationRecord record, MultipartFile file ,String locatFolder) {
        try {
            Integer id = communicationRecordMapper.insert(record);
            if(file!= null) {
                AttachmentFile attachmentFile = new AttachmentFile();
                attachmentFile.setRefId(record.getId());
                attachmentFile.setAttachmentModule(CommunicationRecord.module);
                attachmentFileService.insert(file, attachmentFile,locatFolder);
                }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int insertSelective(CommunicationRecord record) {
        return 0;
    }

    @Override
    public CommunicationRecord selectByPrimaryKey(Integer id) {
        return communicationRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public HashMap<String, Object> updateByPrimaryKeySelective(CommunicationRecord record,MultipartFile file,String locatFolder) {
        try {
            communicationRecordMapper.updateByPrimaryKeySelective(record);
            if(file!= null) {
                AttachmentFile attachmentFile = new AttachmentFile();
                attachmentFile.setRefId(record.getId());
                attachmentFile.setAttachmentModule(CommunicationRecord.module);
                attachmentFileService.insert(file, attachmentFile,locatFolder);
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();

            return ResponseModel.getModel("提交失败", "failed", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int updateByPrimaryKey(CommunicationRecord record) {
        return 0;
    }

    @Override
    public List<CommunicationRecord> findCommunicationRecordByProjId(Integer projid) {
        return communicationRecordMapper.findCommunicationRecordByProjId(projid);
    }
}
