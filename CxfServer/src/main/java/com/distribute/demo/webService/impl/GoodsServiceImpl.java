package com.distribute.demo.webService.impl;

import com.distribute.demo.webService.GoodsService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @author szh
 * @ClassName GoodsServiceImpl
 * @Description 商品service
 * @Date 2019/4/15 14:37
 **/
@WebService(endpointInterface = "com.distribute.demo.webService.GoodsService",
        targetNamespace = "http://webService.demo.distribute.com",
        serviceName = "GoodsService")
@Component
public class GoodsServiceImpl implements GoodsService {

    private static int goodsNum = 100;

    @Override
    public int getGoodsNum() {
        return goodsNum;
    }

    @Override
    public int purchase(int num) {
        goodsNum += num;
        return goodsNum;
    }

    @Override
    public int sale(int num) {
        goodsNum -= num;
        return goodsNum;
    }

}
