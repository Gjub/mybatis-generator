package com.jxkj.manage.service;

import com.jxkj.manage.comm.ResultBody;
import com.jxkj.manage.pojo.Goods;

public interface IWHService {
    /**
     * 根据传入的state查找仓库现存物品
     * @return
     */
    ResultBody findExistAll(Integer state);

    /**
     * 出库
     * @param goodsId 物品id
     * @return
     */
    ResultBody outGoods(Long goodsId);

    /**
     * 入库
     * @param goods
     * @return
     */
    ResultBody inGoods(Goods goods);

}
