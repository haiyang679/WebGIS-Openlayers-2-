package com.openlayers.action.MybatisTest.ServiceTest;

import com.openlayers.action.entity.St_rsvr_r;
import com.openlayers.action.service.St_rsvr_rService.St_rsvr_rService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class St_rsvr_rServiceTest {

    @Resource
    private St_rsvr_rService st_rsvr_rService;

    @Test
    public void testFindSt_rsvr_r() throws ParseException {
        List<St_rsvr_r> st_rsvr_rList = st_rsvr_rService.findSt_rsvr_r();
        for(St_rsvr_r st_rsvr_r: st_rsvr_rList){
            //System.out.println(st_rsvr_r);
            //System.out.println(st_rsvr_r.getTM());

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            String formatDate = df.format(st_rsvr_r.getTM());
            System.out.println(formatDate);
            Date date = df.parse(formatDate);
            System.out.println(date.toString());

        }
    }
}
