package com.zyd.blog;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author zhrey
 * @website http://www.zhrey.cn
 * @date 2018/4/25 11:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@org.springframework.boot.test.IntegrationTest("server.port:0")
public class BaseJunitTest {

    protected String host = "http://47.93.248.210:8090";

    @Autowired
    protected MockMvc mvc;

    @Before
    public void init() throws Exception {
        System.out.println("初始化一些参数1");
    }

}
