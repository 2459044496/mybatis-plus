package com.example.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.entity.User;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void testSaveBatch() {
        List<User> list = new ArrayList<>(20000);
        for (int i=0; i<10000000; i++) {
            User user = new User();
            user.setAge(i);
            list.add(user);
            if (list.size()>=10000) {
                userService.saveBatch(list);
                list.clear();
            }
        }
    }

    @Test
    public void getAll() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        Thread.sleep(30000);//休眠30S
        //userService.list();  //26513   //堆使用率直线上升
        //userMapper.getAll(); //28099  //堆使用上下波动
        userMapper.getAll2(new QueryWrapper<User>(),
                resultContext -> {
                    System.out.println(resultContext.getResultCount());
                }); //23060*/
        long endTime = System.currentTimeMillis();
        System.out.println(endTime);
        System.out.println(endTime-startTime);

        Thread.sleep(1000000000);
    }

}
