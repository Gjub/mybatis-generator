package com.jxkj.manage.pojo;

public class Goods {
    private Long goodId;

    private String goodsName;

    private String descripe;

    public Goods(Long goodId, String goodsName, String descripe) {
        this.goodId = goodId;
        this.goodsName = goodsName;
        this.descripe = descripe;
    }

    public Goods() {
        super();
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getDescripe() {
        return descripe;
    }

    public void setDescripe(String descripe) {
        this.descripe = descripe == null ? null : descripe.trim();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodId=" + goodId +
                ", goodsName='" + goodsName + '\'' +
                ", descripe='" + descripe + '\'' +
                '}';
    }
}