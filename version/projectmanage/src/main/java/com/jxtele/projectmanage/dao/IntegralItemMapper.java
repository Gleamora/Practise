package com.jxtele.projectmanage.dao;

import com.jxtele.projectmanage.entity.IntegralItem;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IntegralItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IntegralItem record);

    int insertSelective(IntegralItem record);

    IntegralItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IntegralItem record);

    int updateByPrimaryKey(IntegralItem record);

    List<IntegralItem> findIntegralByIntegralId(Integer integralId);

    int insert(IntegralItem record, MultipartFile file , String locatFolder);

}