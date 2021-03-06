package com.jxtele.projectmanage.dao;

import com.jxtele.projectmanage.entity.StandardApply;

import java.util.List;

public interface StandardApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StandardApply record);

    int insertSelective(StandardApply record);

    StandardApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StandardApply record);

    int updateByPrimaryKey(StandardApply record);

    List<StandardApply> findStandardApplyByProjId(Integer projid);

    List<StandardApply> findStandardDayId(Integer dayid);
}