package com.jxtele.projectmanage.dao;

import com.jxtele.projectmanage.entity.FactSchedule;

import java.util.List;

public interface FactScheduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FactSchedule record);

    int insertSelective(FactSchedule record);

    FactSchedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FactSchedule record);

    int updateByPrimaryKey(FactSchedule record);

    List<FactSchedule> findFactScheduleleByctScheduleid(Integer ctScheduleid);

    List<FactSchedule> findFactScheduleleByProjid(Integer projid);
}