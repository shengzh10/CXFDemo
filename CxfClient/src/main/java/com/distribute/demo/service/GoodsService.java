package com.distribute.demo.service;

import com.distribute.demo.webService.CxfServicesClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author szh
 * @ClassName GoodsService
 * @Description 商品服务
 * @Date 2019/4/15 16:23
 **/
@Slf4j
@Service
public class GoodsService {

    @Autowired
    private CxfServicesClient cxfServicesClient;

    /**
     * @Description 获取商品数量
     * @return 商品数量
     * @author szh
     * @Date 2019/4/15 16:43
     */
    public int getGoodsNum() {
        Object[] objects = cxfServicesClient.callService("getGoodsNum");
        return null == objects ? 0 : (Integer) objects[0];
    }

    /**
     * @Description 进货
     * @param num 数量
     * @return 商品目前数量
     * @author szh
     * @Date 2019/4/15 16:43
     */
    public int purchaseGoods(int num) {
        Object[] objects = cxfServicesClient.callService("purchase", num);
        return null == objects ? 0 : (Integer) objects[0];
    }

    /**
     * @Description 出货
     * @param num 数量
     * @return 商品目前数量
     * @author szh
     * @Date 2019/4/15 16:44
     */
    public int saleGoods(int num) {
        Object[] objects = cxfServicesClient.callService("sale", num);
        return null == objects ? 0 : (Integer) objects[0];
    }

}
