package com.cjy.test;

import com.cjy.aop.TargetInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//替换运行期
@ContextConfiguration("classpath:applicationContext.xml")//指定配置文件
public class AopTest {
    @Autowired//要测试谁就注入谁
    private TargetInterface target;
    @Test
    public void test1(){
        target.save();
    }

}
