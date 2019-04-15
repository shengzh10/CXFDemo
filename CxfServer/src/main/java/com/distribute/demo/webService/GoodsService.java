package com.distribute.demo.webService;

import javax.jws.WebService;

@WebService(targetNamespace = "http://webService.demo.distribute.com")
public interface GoodsService {

    /**
     * @Description 获取商品数量
     * @return 数量
     * @author szh
     * @Date 2019/4/15 16:00
     */
    int getGoodsNum();

    /**
     * @Description 进货
     * @param num 数量
     * @return 商品目前数量
     * @author szh
     * @Date 2019/4/15 16:00
     */
    int purchase(int num);

    /**
     * @Description 出货
     * @param num 数量
     * @return 商品目前数量
     * @author szh
     * @Date 2019/4/15 16:01
     */
    int sale(int num);

}
