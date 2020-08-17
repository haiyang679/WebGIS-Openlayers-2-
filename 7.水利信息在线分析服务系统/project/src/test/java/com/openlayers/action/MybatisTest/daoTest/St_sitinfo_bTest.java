package com.openlayers.action.MybatisTest.daoTest;

import com.openlayers.action.dao.St_sitinfo_bDao;
import com.openlayers.action.entity.St_sitinfo_b;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class St_sitinfo_bTest {


    @Autowired
    private St_sitinfo_bDao st_sitinfo_bDAO;

    @Test
    public void testSt_sitinfo_bDaoFindAll() {
        List<St_sitinfo_b> st_sitinfo_bs = st_sitinfo_bDAO.findAll();
        for (St_sitinfo_b st_sitinfo_b : st_sitinfo_bs) {
            System.out.println(st_sitinfo_b);
        }
    }

}
