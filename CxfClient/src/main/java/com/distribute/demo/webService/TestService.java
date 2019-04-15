package com.distribute.demo.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://webService.demo.distribute.com")
public interface TestService {

    @WebMethod
    String hello(@WebParam(name = "text") String text);

}
