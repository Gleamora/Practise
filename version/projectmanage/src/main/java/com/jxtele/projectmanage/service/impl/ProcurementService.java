package com.jxtele.projectmanage.service.impl;

import com.jxtele.projectmanage.dao.ProcurementItemMapper;
import com.jxtele.projectmanage.dao.ProcurementMapper;
import com.jxtele.projectmanage.entity.Procurement;
import com.jxtele.projectmanage.entity.ResponseModel;
import com.jxtele.projectmanage.service.IProcurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProcurementService implements IProcurementService {

    @Autowired
    private ProcurementMapper procurementMapper;

    private ProcurementItemMapper procurementItemMapper;

    @Override
    public Map<String, Object> deleteByPrimaryKey(Integer id) {
        try {
            if(id == null){
                return ResponseModel.getModel("你请求的是一个冒牌接口", "failed", null);
            }
            procurementItemMapper.deleteByProcurementId(id);
            procurementMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public Map<String, Object> insert(Procurement record) {
        try {
            procurementMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int insertSelective(Procurement record) {
        return 0;
    }

    @Override
    public Procurement selectByPrimaryKey(Integer id) {
         return procurementMapper.selectByPrimaryKey(id);
    }

    @Override
    public HashMap<String, Object> updateByPrimaryKeySelective(Procurement record) {
        try {
            procurementMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();

            return ResponseModel.getModel("提交失败", "failed", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int updateByPrimaryKey(Procurement record) {
        return 0;
    }

    @Override
    public List<Procurement> findProcurementByProjId(Integer projid) {
        return procurementMapper.findProcurementByProjId(projid);
    }
}
