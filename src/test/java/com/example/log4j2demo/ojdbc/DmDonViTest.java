package com.example.log4j2demo.ojdbc;

import com.example.log4j2demo.Log4j2DemoApplication;
import com.example.log4j2demo.Log4j2DemoApplicationTests;
import com.example.log4j2demo.mixi.DmDonVi;
import com.example.log4j2demo.mixi.DmDonViService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Log4j2DemoApplication.class)
public class DmDonViTest {

    @Autowired
    private DmDonViService dmDonViService;


    @Test
    public void testDonvi(){
        DmDonVi data = this.dmDonViService.findById(1L);
        System.out.println(data);
    }
}
