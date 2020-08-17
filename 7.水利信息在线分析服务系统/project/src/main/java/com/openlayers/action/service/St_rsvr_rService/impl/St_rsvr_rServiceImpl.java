package com.openlayers.action.service.St_rsvr_rService.impl;

import com.openlayers.action.dao.St_rsvr_rDao;
import com.openlayers.action.entity.St_rsvr_r;
import com.openlayers.action.service.St_rsvr_rService.St_rsvr_rService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
@Repository
public class St_rsvr_rServiceImpl implements St_rsvr_rService {

    @Resource
    private St_rsvr_rDao st_rsvr_rDao;
    @Override
    public List<St_rsvr_r> findSt_rsvr_r() {

        return st_rsvr_rDao.findAll();
    }


}
