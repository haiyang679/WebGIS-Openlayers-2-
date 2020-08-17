package com.openlayers.action.dao;

import com.openlayers.action.entity.St_soil_r;
import com.openlayers.action.entity.YuliangStatisticInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
//雨量信息表的dao
public interface St_soil_rDao {

    //查询所有雨量信息  其中一个雨量信息包含属于一个监测站点，，一个监测站点含有多个雨量信息
    List<St_soil_r> findAll();

    //查询最大雨量
    List<St_soil_r> findMaxYuliang();

    //查询雨量各个区间的统计信息
    List<YuliangStatisticInfo> findStatisticsInfo();

}
