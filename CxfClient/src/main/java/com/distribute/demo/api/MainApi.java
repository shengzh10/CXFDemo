package com.distribute.demo.api;

import com.distribute.demo.webService.CxfServicesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author szh
 * @ClassName MainApi
 * @Description
 * @Date 2019/4/14 23:17
 **/
@Controller
public class MainApi {

    @Autowired
    private CxfServicesClient cxfServicesClient;

    @RequestMapping("main")
    public void main() {
        cxfServicesClient.test2();
    }

}
