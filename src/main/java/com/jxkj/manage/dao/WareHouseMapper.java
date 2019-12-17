package com.jxkj.manage.dao;

import com.jxkj.manage.pojo.WareHouse;
import com.jxkj.manage.pojo.WareHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WareHouseMapper {
    int countByExample(WareHouseExample example);

    int deleteByExample(WareHouseExample example);

    int deleteByPrimaryKey(Long houseId);

    int insert(WareHouse record);

    int insertSelective(WareHouse record);

    List<WareHouse> selectByExample(WareHouseExample example);

    WareHouse selectByPrimaryKey(Long houseId);

    int updateByExampleSelective(@Param("record") WareHouse record, @Param("example") WareHouseExample example);

    int updateByExample(@Param("record") WareHouse record, @Param("example") WareHouseExample example);

    int updateByPrimaryKeySelective(WareHouse record);

    int updateByPrimaryKey(WareHouse record);

    List<WareHouse> selectAll();

    WareHouse selectByGoodId(Long goodId);
}