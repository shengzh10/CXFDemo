package com.distribute.demo.webService;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Service;

/**
 * @author szh
 * @ClassName CxfServicesClient
 * @Description web service客户端
 * @Date 2019/4/15 10:20
 **/
@Service
public class CxfServicesClient {
    
    private static Client cxfClient;
    
    /**
     * @Description 获取客户端
     * @return 客户端
     * @author szh
     * @Date 2019/4/15 16:36       
     */
    public static Client getClient() {
        if (null == cxfClient) {
            JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
            String address = "http://localhost:8081/cxf/cxfServices?wsdl";
            cxfClient = dcf.createClient(address);
        }
        return cxfClient;
    }

    /**
     * @Description 调用服务
     * @param serviceName 服务名称
     * @param params
     * @return
     * @author szh
     * @Date 2019/4/15 16:40
     */
    public Object[] callService(String serviceName, Object... params) {
        getClient();
        try {
            return cxfClient.invoke(serviceName, params);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Description 测试：静态访问服务
     * @author szh
     * @Date 2019/4/15 16:33       
     */
    public void test1() {
        try {
            // 接口地址
            String address = "http://120.78.133.4:8081/cxf/cxfServices?wsdl";
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

    /**
     * @Description 测试：动态创建客户端访问服务
     * @author szh
     * @Date 2019/4/15 16:34       
     */
    public void test2() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        String address = "http://120.78.133.4:8081/cxf/cxfServices?wsdl";
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
