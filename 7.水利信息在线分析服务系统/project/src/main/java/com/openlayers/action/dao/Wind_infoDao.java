package com.openlayers.action.dao;

import com.openlayers.action.entity.Wind_info;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//台风详细信息表
@Repository
@Mapper
public interface Wind_infoDao {

    //查询所有
    List<Wind_info> findAll();

    //查询时间，风力和风速
    List<Wind_info> findTmWindStrongWindspeed();
}
