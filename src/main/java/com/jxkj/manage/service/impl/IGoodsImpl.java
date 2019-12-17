package com.jxkj.manage.service.impl;

import com.jxkj.manage.comm.ResultBody;
import com.jxkj.manage.dao.GoodsMapper;
import com.jxkj.manage.dao.WareHouseMapper;
import com.jxkj.manage.pojo.Goods;
import com.jxkj.manage.pojo.GoodsExample;
import com.jxkj.manage.pojo.WareHouse;
import com.jxkj.manage.pojo.WareHouseExample;
import com.jxkj.manage.service.IGoods;
import com.jxkj.manage.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IGoodsImpl implements IGoods {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private WareHouseMapper wareHouseMapper;

    @Override
    public ResultBody findAllGoods() {
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andGoodIdIsNotNull();
        List<Goods> list = goodsMapper.selectByExample(goodsExample);
        return ResultUtils.success(list);
    }

    @Override
    public ResultBody updateGoods(Goods goods) {
        goodsMapper.updateByPrimaryKey(goods);
        return ResultUtils.success();
    }

    @Override
    public ResultBody deleteGood(Long goodId) {
        WareHouseExample wareHouseExample = new WareHouseExample();
        wareHouseExample.createCriteria().andGoodIdEqualTo(goodId);
        wareHouseMapper.deleteByExample(wareHouseExample);
        goodsMapper.deleteByPrimaryKey(goodId);
        return ResultUtils.success();
    }
}
