package com.jxtele.projectmanage.service.impl;

import com.jxtele.projectmanage.dao.IntegralMapper;
import com.jxtele.projectmanage.entity.Integral;
import com.jxtele.projectmanage.entity.ResponseModel;
import com.jxtele.projectmanage.service.IIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class IntegralService implements IIntegralService {

    @Autowired
    private IntegralMapper integralMapper;
    @Override
    public Map<String, Object> deleteByPrimaryKey(Integer id) {
        try {
            if(id == null){
                return ResponseModel.getModel("你请求的是一个冒牌接口", "failed", null);
            }
            integralMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public Map<String, Object> insert(Integral record) {
        try {
            integralMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int insertSelective(Integral record) {
        return 0;
    }

    @Override
    public Integral selectByPrimaryKey(Integer id) {
        return integralMapper.selectByPrimaryKey(id);
    }

    @Override
    public HashMap<String, Object> updateByPrimaryKeySelective(Integral record) {
        try {
            integralMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();

            return ResponseModel.getModel("提交失败", "failed", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int updateByPrimaryKey(Integral record) {
        return 0;
    }

    @Override
    public List<Integral> findIntegralByProjId(Integer projid) {
        return integralMapper.findIntegralByProjId(projid);
    }


}
