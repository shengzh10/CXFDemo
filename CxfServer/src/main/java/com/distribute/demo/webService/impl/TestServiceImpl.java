package com.distribute.demo.webService.impl;

import com.distribute.demo.webService.TestService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @author szh
 * @ClassName TestServiceImpl
 * @Description
 * @Date 2019/4/14 23:46
 **/
@WebService(endpointInterface = "com.distribute.demo.webService.TestService",
        targetNamespace = "http://webService.demo.distribute.com",
        serviceName = "TestService")
@Component
public class TestServiceImpl implements TestService {

    @Override
    public String hello(String text) {
        return "Hello, " + text;
    }

}
