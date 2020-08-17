package com.openlayers.action.dao;

import com.openlayers.action.entity.Wind_forecast;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//台风预测信息表
@Repository
@Mapper
public interface Wind_forecastDao {

    //查询所有
    List<Wind_forecast> findAll();
}
