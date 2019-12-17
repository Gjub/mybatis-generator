package com.jxkj.manage.controller;

import com.jxkj.manage.comm.ResultBody;
import com.jxkj.manage.pojo.Goods;
import com.jxkj.manage.service.impl.IGoodsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IGoodsImpl iGoods;

    @PostMapping("update")
    public ResultBody updateGoods(Goods goods){
        return iGoods.updateGoods(goods);
    }

    @GetMapping("findAllGoods")
    public ResultBody findAllGoods(){
        return iGoods.findAllGoods();
    }

    @PostMapping("delete")
    public ResultBody deleteGood(Long goodId){
        return iGoods.deleteGood(goodId);
    }
}
