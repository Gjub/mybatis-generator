package com.jxkj.manage.controller;

import com.jxkj.manage.comm.ResultBody;
import com.jxkj.manage.dao.WareHouseMapper;
import com.jxkj.manage.pojo.Goods;
import com.jxkj.manage.pojo.WareHouse;
import com.jxkj.manage.service.IWHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/wh")
public class WHController {
    @Autowired
    private IWHService iwhService;

    @GetMapping("findExistAll")
    public ResultBody findExistAll(Integer state){
        return iwhService.findExistAll(state);
    }

    @PostMapping("in")
    public ResultBody inGoods(Goods goods){
        return iwhService.inGoods(goods);
    }

    @PostMapping("out")
    public ResultBody outGoods(Long goodId){
        return iwhService.outGoods(goodId);
    }



}
