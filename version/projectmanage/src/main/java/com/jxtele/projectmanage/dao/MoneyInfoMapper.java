package com.jxtele.projectmanage.dao;

import com.jxtele.projectmanage.entity.MoneyInfo;

public interface MoneyInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MoneyInfo record);

    int insertSelective(MoneyInfo record);

    MoneyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MoneyInfo record);

    int updateByPrimaryKey(MoneyInfo record);

    MoneyInfo findMoneyInfoByProjId(Integer projid);
}