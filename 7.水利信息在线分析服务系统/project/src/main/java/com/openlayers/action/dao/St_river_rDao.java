package com.openlayers.action.dao;

import com.openlayers.action.entity.St_river_r;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface St_river_rDao {
    //查询所有河流信息,,先根据站码进行排序（即分组），再在站码分组中按日期排序，方便前端Echart对数据的可视化
    List<St_river_r> findAll();



    //根据站码查询河流信息
    List<St_river_r> findSt_river_rByZhanma(String zhanma);

}
