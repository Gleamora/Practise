package com.jxtele.projectmanage.service.impl;

import com.jxtele.projectmanage.dao.CommunicationMapper;
import com.jxtele.projectmanage.entity.AttachmentFile;
import com.jxtele.projectmanage.entity.Communication;
import com.jxtele.projectmanage.entity.ResponseModel;
import com.jxtele.projectmanage.service.IAttachmentFileService;
import com.jxtele.projectmanage.service.ICommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommunicationService implements ICommunicationService {

    @Autowired
    private CommunicationMapper communicationMapper;

    @Autowired
    private IAttachmentFileService attachmentFileService;

    @Override
    public Map<String, Object> deleteByPrimaryKey(Integer id) {
        try {
            if(id == null){
                return ResponseModel.getModel("你请求的是一个冒牌接口", "failed", null);
            }
            attachmentFileService.deleteByrefid(id);
            communicationMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public Map<String, Object> insert(Communication record,MultipartFile file,String locatFolder) {
        try {
            Integer id = communicationMapper.insert(record);
            if(file!= null) {
                AttachmentFile attachmentFile = new AttachmentFile();
                attachmentFile.setRefId(record.getId());
                attachmentFile.setAttachmentModule(Communication.module);
                attachmentFileService.insert(file, attachmentFile,locatFolder);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int insertSelective(Communication record) {
        return 0;
    }

    @Override
    public Communication selectByPrimaryKey(Integer id) {
        return communicationMapper.selectByPrimaryKey(id);
    }

    @Override
    public HashMap<String, Object> updateByPrimaryKeySelective(Communication record,MultipartFile file,String locatFolder) {
        try {
            communicationMapper.updateByPrimaryKeySelective(record);
            if(file!= null) {
                AttachmentFile attachmentFile = new AttachmentFile();
                attachmentFile.setRefId(record.getId());
                attachmentFile.setAttachmentModule(Communication.module);
                attachmentFileService.insert(file, attachmentFile,locatFolder);
            }
        } catch (Exception e) {
            /*TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();*/
            e.printStackTrace();

            return ResponseModel.getModel("提交失败", "failed", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int updateByPrimaryKey(Communication record) {
        return 0;
    }

    @Override
    public List<Communication> findCommunicationByProjId(Integer projid) {
        return communicationMapper.findCommunicationByProjId(projid);
    }
}
