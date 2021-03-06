package com.jxtele.projectmanage.dao;

import com.jxtele.projectmanage.entity.CommunicationRecord;

import java.util.List;

public interface CommunicationRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommunicationRecord record);

    int insertSelective(CommunicationRecord record);

    CommunicationRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommunicationRecord record);

    int updateByPrimaryKey(CommunicationRecord record);

    List<CommunicationRecord> findCommunicationRecordByProjId(Integer projid);
}