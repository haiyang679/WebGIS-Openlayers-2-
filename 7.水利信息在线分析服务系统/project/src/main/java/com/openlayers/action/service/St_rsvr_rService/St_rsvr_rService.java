package com.openlayers.action.service.St_rsvr_rService;

import com.openlayers.action.entity.St_rsvr_r;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface St_rsvr_rService {

    //联合查询，查询水库信息表，，一个水库对应多个监测站点，一个监测站点对应多个水库
    //直接调用dao层的St_rsvr_rDao的findAll()方法实现即可
    List<St_rsvr_r> findSt_rsvr_r();
}
