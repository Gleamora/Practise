package com.jxtele.projectmanage.service.impl;

import com.jxtele.projectmanage.dao.MoneyInfoItemMapper;
import com.jxtele.projectmanage.entity.MoneyInfoItem;
import com.jxtele.projectmanage.entity.ResponseModel;
import com.jxtele.projectmanage.service.IMoneyInfoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MoneyInfoItemService implements IMoneyInfoItemService {

    @Autowired
    private MoneyInfoItemMapper moneyInfoItemMapper;

    @Override
    public Map<String, Object> deleteByPrimaryKey(Integer id) {
        try {
            if(id == null){
                return ResponseModel.getModel("你请求的是一个冒牌接口", "failed", null);
            }
            moneyInfoItemMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public Map<String, Object> insert(MoneyInfoItem record) {
        try {
            moneyInfoItemMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int insertSelective(MoneyInfoItem record) {
        return 0;
    }

    @Override
    public MoneyInfoItem selectByPrimaryKey(Integer id) {
        return moneyInfoItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public HashMap<String, Object> updateByPrimaryKeySelective(MoneyInfoItem record) {
        try {
            moneyInfoItemMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();

            return ResponseModel.getModel("提交失败", "failed", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int updateByPrimaryKey(MoneyInfoItem record) {
        return 0;
    }

    @Override
    public List<MoneyInfoItem> findMoneyInfoItemByMoneyInfoId(Integer moneyinfoid) {
        return moneyInfoItemMapper.findMoneyInfoItemByMoneyInfoId(moneyinfoid);
    }

    @Override
    public int deleteByMoneyInfoId(Integer moneyinfoid) {
        return  moneyInfoItemMapper.deleteByMoneyInfoId(moneyinfoid);
    }

    @Override
    public List<MoneyInfoItem> findMoneyInfoItemByProjid(Integer projid) {
        return moneyInfoItemMapper.findMoneyInfoItemByProjid(projid);
    }

}
