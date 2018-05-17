package com.bootdo.function.controller;

import com.bootdo.function.service.ApplyService;
import com.bootdo.function.service.ITestOracleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ian on 2018/5/17.
 */

@Controller
public class TestOracleController {

    @Autowired
    private ITestOracleService iTestOracleService;

    @RequestMapping("/test")
    @ResponseBody
    public String index(){
        iTestOracleService.insert();

        return "insert succes";
    }
}
