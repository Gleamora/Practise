package com.jxtele.projectmanage.service.impl;

import com.jxtele.projectmanage.dao.StandardApplyMapper;
import com.jxtele.projectmanage.entity.ResponseModel;
import com.jxtele.projectmanage.entity.StandardApply;
import com.jxtele.projectmanage.service.IStandardApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StandardApplyService implements IStandardApplyService {

    @Autowired
    private StandardApplyMapper standardApplyMapper;

    @Override
    public Map<String, Object> deleteByPrimaryKey(Integer id) {
        try {
            if(id == null){
                return ResponseModel.getModel("你请求的是一个冒牌接口", "failed", null);
            }
            standardApplyMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public Map<String, Object> insert(StandardApply record) {
        try {
            standardApplyMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int insertSelective(StandardApply record) {
        return 0;
    }

    @Override
    public StandardApply selectByPrimaryKey(Integer id) {
        return standardApplyMapper.selectByPrimaryKey(id);
    }

    @Override
    public HashMap<String, Object> updateByPrimaryKeySelective(StandardApply record) {
        try {
            standardApplyMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();

            return ResponseModel.getModel("提交失败", "failed", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int updateByPrimaryKey(StandardApply record) {
        return 0;
    }

    @Override
    public List<StandardApply> findStandardApplyByProjId(Integer projid) {
        return standardApplyMapper.findStandardApplyByProjId(projid);
    }
    @Override
    public List<StandardApply> findStandardDayId(Integer dayid){
        return standardApplyMapper.findStandardDayId(dayid);
    }
}
