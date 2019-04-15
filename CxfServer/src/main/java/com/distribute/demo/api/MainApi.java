package com.distribute.demo.api;

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

    @RequestMapping("main")
    public String main() {
        return "Main";
    }

}
