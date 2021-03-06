package com.jxtele.projectmanage.service.impl;

import com.jxtele.projectmanage.dao.AlterScheduleMapper;
import com.jxtele.projectmanage.entity.AlterSchedule;
import com.jxtele.projectmanage.entity.AttachmentFile;
import com.jxtele.projectmanage.entity.ResponseModel;
import com.jxtele.projectmanage.service.IAlterScheduleService;
import com.jxtele.projectmanage.service.IAttachmentFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlterScheduleService implements IAlterScheduleService {

    @Autowired
    private AlterScheduleMapper alterScheduleMapper;

    @Autowired
    private IAttachmentFileService attachmentFileService;

    @Override
    public Map<String, Object> deleteByPrimaryKey(Integer id) {
        try {
            if(id == null){
                return ResponseModel.getModel("你请求的是一个冒牌接口", "failed", null);
            }
            attachmentFileService.deleteByrefid(id);
            alterScheduleMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public Map<String, Object> insert(AlterSchedule record, MultipartFile file , String locatFolder) {
        try {
            record.setAlterdate(new Date());
            int id = alterScheduleMapper.insert(record);
            if(file!= null) {
                AttachmentFile attachmentFile = new AttachmentFile();
                attachmentFile.setRefId(record.getId());
                attachmentFile.setAttachmentModule(AlterSchedule.module);
                attachmentFileService.insert(file, attachmentFile,locatFolder);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int insertSelective(AlterSchedule record) {
        return 0;
    }

    @Override
    public AlterSchedule selectByPrimaryKey(Integer id) {
        return alterScheduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public HashMap<String, Object> updateByPrimaryKeySelective(AlterSchedule record, MultipartFile file , String locatFolder) {
        try {
            alterScheduleMapper.updateByPrimaryKeySelective(record);
            if(file!= null) {
                AttachmentFile attachmentFile = new AttachmentFile();
                attachmentFile.setRefId(record.getId());
                attachmentFile.setAttachmentModule(AlterSchedule.module);
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
    public int updateByPrimaryKey(AlterSchedule record) {
        return 0;
    }

    @Override
    public List<AlterSchedule> findAlterScheduleByctScheduleid(Integer ctScheduleid) {
        return alterScheduleMapper.findAlterScheduleByctScheduleid(ctScheduleid);
    }

    @Override
    public List<AlterSchedule> findAlterScheduleBymoneyInfoid(Integer moneyinfoid) {
        return alterScheduleMapper.findAlterScheduleBymoneyInfoid(moneyinfoid);
    }

    @Override
    public List<AlterSchedule> findAlterScheduleByProjId(Integer projid) {
        return alterScheduleMapper.findAlterScheduleByProjId(projid);
    }
}
