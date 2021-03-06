package com.jxtele.projectmanage.service;

import com.jxtele.projectmanage.entity.MoneyInfoItem;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public interface IMoneyInfoItemService {

    Map<String, Object> deleteByPrimaryKey(Integer id);

    Map<String, Object> insert(MoneyInfoItem record);

    int insertSelective(MoneyInfoItem record);

    MoneyInfoItem selectByPrimaryKey(Integer id);

    HashMap<String, Object> updateByPrimaryKeySelective(MoneyInfoItem record);

    int updateByPrimaryKey(MoneyInfoItem record);

    List<MoneyInfoItem> findMoneyInfoItemByMoneyInfoId(Integer moneyinfoid);

    int deleteByMoneyInfoId(Integer moneyinfoid);

    List<MoneyInfoItem> findMoneyInfoItemByProjid(Integer projid);

}
