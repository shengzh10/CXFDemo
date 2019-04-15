package com.distribute.demo.api;

import com.distribute.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author szh
 * @ClassName GoodsApi
 * @Description 商品controller
 * @Date 2019/4/15 16:32
 **/
@Controller
@RequestMapping("goods")
public class GoodsApi {

    @Autowired
    private GoodsService goodsService;

    /**
     * @Description 商品页面
     * @param model 返回商品数量
     * @author szh
     * @Date 2019/4/15 16:53
     */
    @RequestMapping()
    public String goods(Model model) {
        int goodsNum = goodsService.getGoodsNum();
        model.addAttribute("goodsNum", goodsNum);
        return "Goods";
    }

    @PostMapping("purchase")
    public String purchase(Model model, @RequestParam("num") int num) {
        int goodsNum =  goodsService.purchaseGoods(num);
        model.addAttribute("goodsNum", goodsNum);
        return "Goods";
    }

    @PostMapping("sale")
    public String sale(Model model, @RequestParam("num") int num) {
        int goodsNum =  goodsService.saleGoods(num);
        model.addAttribute("goodsNum", goodsNum);
        return "Goods";
    }

}
