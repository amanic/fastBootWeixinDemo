package com.amateur.wanbei.service.impl;

import com.amateur.wanbei.dao.mapper.UserMapper;
import com.amateur.wanbei.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenhaitao on 2018/6/5.
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService{

    @Autowired
    UserMapper userMapper;

    @Override
    public String hello() {
        try {
            log.info("没报错，记录日志。");
            return userMapper.selectByPrimaryKey(1).toString();
        } catch (Exception e) {
            log.error("报错啦，记录日志。",e);
            return "false";
        }
    }
}
