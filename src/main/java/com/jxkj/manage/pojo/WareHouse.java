package com.jxkj.manage.pojo;

import java.util.Date;

public class WareHouse {
    private Long houseId;

    private Long goodId;

    private Integer state;

    private Date updateTime;

    private Date createTime;

    public WareHouse(Long houseId, Long goodId, Integer state, Date updateTime, Date createTime) {
        this.houseId = houseId;
        this.goodId = goodId;
        this.state = state;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public WareHouse() {
        super();
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}