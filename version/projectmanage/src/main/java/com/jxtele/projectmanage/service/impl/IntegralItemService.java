package com.jxtele.projectmanage.service.impl;

//import com.jxtele.projectmanage.dao.DocumentRecordMapper;
import com.jxtele.projectmanage.dao.IntegralItemMapper;
import com.jxtele.projectmanage.entity.AttachmentFile;
import com.jxtele.projectmanage.entity.IntegralItem;
import com.jxtele.projectmanage.entity.ResponseModel;
import com.jxtele.projectmanage.service.IIntegralItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IntegralItemService implements IIntegralItemService {

    @Autowired
    private IntegralItemMapper integralItemMapper;
    @Autowired
    private AttachmentFileService attachmentFileService;
    @Override
    public Map<String, Object> deleteByPrimaryKey(Integer id) {
        try {
            if(id == null){
                return ResponseModel.getModel("你请求的是一个冒牌接口", "failed", null);
            }
            integralItemMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

//    @Override
//    public HashMap<String, Object> insert(IntegralItem record) {
//        try {
//            integralItemMapper.insert(record);
//        } catch (Exception e) {
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            e.printStackTrace();
//            return ResponseModel.getModel("error", "falied", null);
//        }
//        return ResponseModel.getModel("ok", "success", null);
//    }

    @Override
    public int insertSelective(IntegralItem record) {
        return integralItemMapper.insertSelective(record);
    }

    @Override
    public IntegralItem selectByPrimaryKey(Integer id) {
        return integralItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public HashMap<String, Object> updateByPrimaryKeySelective(IntegralItem record, MultipartFile file, String locatFolder)
    {
        try {
            integralItemMapper.updateByPrimaryKeySelective(record);
            if(file!= null) {
                AttachmentFile attachmentFile = new AttachmentFile();
                attachmentFile.setRefId(record.getId());
                attachmentFile.setAttachmentModule(IntegralItem.module);
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
    public int updateByPrimaryKey(IntegralItem record) {
        return integralItemMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<IntegralItem> findIntegralByIntegralId(Integer integralId) {
        return integralItemMapper.findIntegralByIntegralId(integralId);
    }
    @Override
    public Map<String, Object> insert(IntegralItem record, MultipartFile file , String locatFolder) {
        try {
            Integer id = integralItemMapper.insert(record);
            if (file != null) {
                AttachmentFile attachmentFile = new AttachmentFile();
                attachmentFile.setRefId(record.getId());
                attachmentFile.setAttachmentModule(IntegralItem.module);
                attachmentFileService.insert(file, attachmentFile, locatFolder);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

}
