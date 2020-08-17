package com.openlayers.action.dao;

import com.openlayers.action.entity.St_sitinfo_b;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//监测站点的dao
@Repository
@Mapper   //让spring容器知道这是一个mapper类
public interface St_sitinfo_bDao {

    //查询所有监测站点信息
    List<St_sitinfo_b> findAll();

}
