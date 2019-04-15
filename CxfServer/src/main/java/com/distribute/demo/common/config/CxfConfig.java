package com.distribute.demo.common.config;

import javax.xml.ws.Endpoint;
import com.distribute.demo.webService.TestService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author szh
 * @ClassName CfxConfig
 * @Description
 * @Date 2019/4/15 0:06
 **/
@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;
    @Autowired
    private TestService testService;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, testService);
        endpoint.publish("/cfxServices");
        return endpoint;
    }

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/cxf/*");
    }

}
