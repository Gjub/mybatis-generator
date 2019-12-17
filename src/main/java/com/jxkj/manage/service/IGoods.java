package com.jxkj.manage.service;

import com.jxkj.manage.comm.ResultBody;
import com.jxkj.manage.pojo.Goods;

public interface IGoods {
    //查找所有的物品
    ResultBody findAllGoods();
    //更新物品
    ResultBody updateGoods(Goods goods);
    //删除物品
    ResultBody deleteGood(Long goodId);




}
