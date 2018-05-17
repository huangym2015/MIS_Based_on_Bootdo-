package com.bootdo.function.service.impl;

import com.bootdo.function.domain.User;
import com.bootdo.function.oracledao.TestOracleMapper;
import com.bootdo.function.service.ITestOracleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ian on 2018/5/17.
 */
@Service
public class TestOracleImpl implements ITestOracleService {

    @Autowired
    private TestOracleMapper testOracleMapper;

    @Override
    public void insert() {
        User user = new User();
        user.setId(12345);
        user.setName("dynamic");
        testOracleMapper.insert(user);
        System.out.println("insert success！！！");

    }
}
