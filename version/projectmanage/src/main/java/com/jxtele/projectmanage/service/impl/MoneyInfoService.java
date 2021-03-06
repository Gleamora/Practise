package com.jxtele.projectmanage.service.impl;

import com.jxtele.projectmanage.dao.MoneyInfoItemMapper;
import com.jxtele.projectmanage.dao.MoneyInfoMapper;
import com.jxtele.projectmanage.entity.MoneyInfo;
import com.jxtele.projectmanage.entity.ResponseModel;
import com.jxtele.projectmanage.service.IMoneyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MoneyInfoService implements IMoneyInfoService {


    @Autowired
    private MoneyInfoMapper moneyInfoMappper;

    @Autowired
    private MoneyInfoItemMapper moneyInfoItemMappper;

    @Override
    public Map<String, Object> deleteByPrimaryKey(Integer id) {
        try {
            if(id == null){
                return ResponseModel.getModel("你请求的是一个冒牌接口", "failed", null);
            }
            //删除主从表数据
            moneyInfoItemMappper.deleteByMoneyInfoId(id);
            moneyInfoMappper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public Map<String, Object> insert(MoneyInfo record) {
        try {
            moneyInfoMappper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int insertSelective(MoneyInfo record) {
        return 0;
    }

    @Override
    public MoneyInfo selectByPrimaryKey(Integer id) {
        return moneyInfoMappper.selectByPrimaryKey(id);
    }

    @Override
    public HashMap<String, Object> updateByPrimaryKeySelective(MoneyInfo record) {
        try {
            moneyInfoMappper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();

            return ResponseModel.getModel("提交失败", "failed", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int updateByPrimaryKey(MoneyInfo record) {
        return 0;
    }

    @Override
    public MoneyInfo findMoneyInfoByProjId(Integer projid) {
        return moneyInfoMappper.findMoneyInfoByProjId(projid);
    }
}
