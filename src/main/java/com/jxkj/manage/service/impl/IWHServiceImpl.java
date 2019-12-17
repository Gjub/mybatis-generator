package com.jxkj.manage.service.impl;

import com.jxkj.manage.comm.ResultBody;
import com.jxkj.manage.dao.GoodsMapper;
import com.jxkj.manage.dao.WareHouseMapper;
import com.jxkj.manage.pojo.Goods;
import com.jxkj.manage.pojo.WareHouse;
import com.jxkj.manage.pojo.WareHouseExample;
import com.jxkj.manage.service.IWHService;
import com.jxkj.manage.util.GeneratorIdUtil;
import com.jxkj.manage.util.ResultUtils;
import com.jxkj.manage.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IWHServiceImpl implements IWHService {

    @Autowired
    private WareHouseMapper wareHouseMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public ResultBody findExistAll(Integer state) {
        WareHouseExample wareHouseExample = new WareHouseExample();
        wareHouseExample.createCriteria().andStateEqualTo(state);
        List<WareHouse> list = wareHouseMapper.selectByExample(wareHouseExample);
        List<GoodsVO> list1 = new ArrayList<>();
        for(WareHouse wareHouse:list){
            Goods good = goodsMapper.selectByPrimaryKey(wareHouse.getGoodId());
            GoodsVO goodsVO = new GoodsVO();
            goodsVO.setGoodId(good.getGoodId());
            goodsVO.setGoodsName(good.getGoodsName());
            goodsVO.setDescripe(good.getDescripe());
            goodsVO.setCreateTime(wareHouse.getCreateTime());
            goodsVO.setUpdateTime(wareHouse.getUpdateTime());
            list1.add(goodsVO);
        }
        return ResultUtils.success(list1);
    }


    @Override
    public ResultBody outGoods(Long goodsId) {
        WareHouse wareHouse = wareHouseMapper.selectByGoodId(goodsId);
        if (wareHouse.getState() == 1) {
            wareHouse.setState(0);
            wareHouse.setUpdateTime(new Date(System.currentTimeMillis() + 8 * 60 * 60 * 1000));
            wareHouseMapper.updateByPrimaryKey(wareHouse);
            return ResultUtils.success(wareHouse);
        } else {
            return ResultUtils.error(1, "你所要出货的商品不存在");
        }

    }

    @Override
    public ResultBody inGoods(Goods goods) {
        goods.setGoodId(GeneratorIdUtil.generatorId());
        WareHouse wareHouse = new WareHouse();
        wareHouse.setGoodId(goods.getGoodId());
        wareHouse.setState(1);
        int i = goodsMapper.insert(goods);
        int j = wareHouseMapper.insert(wareHouse);
        if (i > 0 && j > 0) {
            return ResultUtils.success();
        } else {
            return ResultUtils.error(1, "添加失败，请重试");
        }
    }


}
