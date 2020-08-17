package com.openlayers.action.dao;

import com.openlayers.action.entity.Wind_basicInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
//台风基本信息表
public interface Wind_basicInfoDao {

    List<Wind_basicInfo> findAll();
}
