package model.goods.stationery;

import model.goods.GoodsCategoryModel;

public class Pen extends Stationery {
    public Pen(String goodsName, double goodsPrice, int goodsInventory , String producingCountry, String penColor) {
        super(goodsName, goodsPrice, goodsInventory, producingCountry);
        this.penColor = penColor;
    }

    public String getPenColor() {
        return penColor;
    }


   final private String penColor;

    @Override
    public String toString() {
        return super.toString()+
                "\npenColor='" + penColor + '\''
                ;
    }
}
