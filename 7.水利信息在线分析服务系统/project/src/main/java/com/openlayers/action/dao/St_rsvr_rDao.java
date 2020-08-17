package com.openlayers.action.dao;

import com.openlayers.action.entity.St_rsvr_r;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//水库信息
@Repository
@Mapper
public interface St_rsvr_rDao {

    //查询所有水库信息   其中一个水库对应一个监测站点，一个监测站点对应多个水库
    List<St_rsvr_r> findAll();   //查询出的数据，先按照站码进行排序（即分组，再按照时间进行排序，方便之后表的处理）

    //根据站名查询水库信息
    List<St_rsvr_r> findSt_rsvr_rByZhanma(String zhanma);

}
