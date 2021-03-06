package com.jxtele.projectmanage.service.impl;

import com.jxtele.projectmanage.dao.StandardDayMapper;
import com.jxtele.projectmanage.entity.ResponseModel;
import com.jxtele.projectmanage.entity.StandardDay;
import com.jxtele.projectmanage.service.IStandardDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StandardDayService implements IStandardDayService {

    @Autowired
    private StandardDayMapper standardDayMapper;

    @Override
    public Map<String, Object> deleteByPrimaryKey(Integer id) {
        try {
            if(id == null){
                return ResponseModel.getModel("你请求的是一个冒牌接口", "failed", null);
            }
            standardDayMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public Map<String, Object> insert(StandardDay record) {
        try {
            standardDayMapper.insert(record);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseModel.getModel("error", "falied", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int insertSelective(StandardDay record) {
        return 0;
    }

    @Override
    public StandardDay selectByPrimaryKey(Integer id) {
        return standardDayMapper.selectByPrimaryKey(id);
    }

    @Override
    public HashMap<String, Object> updateByPrimaryKeySelective(StandardDay record) {
        try {
            standardDayMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();

            return ResponseModel.getModel("提交失败", "failed", null);
        }
        return ResponseModel.getModel("ok", "success", null);
    }

    @Override
    public int updateByPrimaryKey(StandardDay record) {
        return 0;
    }

    @Override
    public List<StandardDay> findStandardDayByProjId(Integer projid) {
        return standardDayMapper.findStandardDayByProjId(projid);
    }

    //显示所有项目工日
    @Override
    public List<StandardDay> findAllStandardDay(){
        return standardDayMapper.findAllStandardDay();
    }
    //显示部分类别工日
    @Override
    public List<StandardDay> findStandardDayByProjIdAndType(Integer projectId, String stardtype){
        return standardDayMapper.findStandardDayByProjIdAndType(projectId,stardtype);
    }
}
