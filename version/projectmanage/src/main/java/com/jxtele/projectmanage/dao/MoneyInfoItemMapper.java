package com.jxtele.projectmanage.dao;

import com.jxtele.projectmanage.entity.MoneyInfoItem;

import java.util.List;

public interface MoneyInfoItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MoneyInfoItem record);

    int insertSelective(MoneyInfoItem record);

    MoneyInfoItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MoneyInfoItem record);

    int updateByPrimaryKey(MoneyInfoItem record);

    List<MoneyInfoItem> findMoneyInfoItemByMoneyInfoId(Integer moneyinfoid);

    List<MoneyInfoItem> findMoneyInfoItemByProjid(Integer projid);

    int deleteByMoneyInfoId(Integer moneyinfoid);
}