package model.goods.digitalgoods;

import model.goods.GoodsCategoryModel;
import model.goods.GoodsModel;

abstract public class DigitalGoods extends GoodsModel {
    final private double weight;
   final private String dimensions;

    protected DigitalGoods(String goodsName, double goodsPrice, int goodsInventory , double weight, String dimensions) {
        super(goodsName, goodsPrice, goodsInventory, GoodsCategoryModel.DIGITALGOODS);
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public double getWeight() {
        return weight;
    }


    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nweight=" + weight +
                "\ndimensions='" + dimensions + '\'' ;
    }
}
