package model.goods.stationery;

import model.goods.GoodsCategoryModel;
import model.goods.GoodsModel;

abstract public class Stationery extends GoodsModel {
   final private String producingCountry;

    public String getProducingCountry() {
        return producingCountry;
    }


    protected Stationery(String goodsName, double goodsPrice, int goodsInventory, String producingCountry) {
        super(goodsName, goodsPrice, goodsInventory, GoodsCategoryModel.STATIONERY);
        this.producingCountry = producingCountry;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nproducingCountry='" + producingCountry + '\'' ;
    }
}
