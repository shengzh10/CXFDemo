package com.distribute.demo.webService;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Service;

/**
 * @author szh
 * @ClassName CxfServicesClient
 * @Description
 * @Date 2019/4/15 10:20
 **/
@Service
public class CxfServicesClient {

    public void test1() {
        try {
            // 接口地址
            String address = "http://localhost:8081/cxf/cxfServices?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(TestService.class);
            // 创建一个代理接口实现
            TestService cs = (TestService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String userName = "test1";
            // 调用代理接口的方法调用并返回结果
            String result = cs.hello(userName);
            System.out.println("返回结果: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test2() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        String address = "http://localhost:8081/cxf/cxfServices?wsdl";
        Client client = dcf.createClient(address);
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
        // PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("hello", "test2");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

}
