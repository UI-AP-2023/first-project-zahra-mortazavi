package model.goods.stationery;

import model.goods.GoodsCategoryModel;

public class Pencil extends Stationery {
   final private PencilType pencilType;

    public Pencil(String goodsName, double goodsPrice, int goodsInventory, String producingCountry, PencilType pencilType) {
        super(goodsName, goodsPrice, goodsInventory, producingCountry);
        this.pencilType = pencilType;
    }

    public PencilType getPencilType() {
        return pencilType;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\npencilType=" + pencilType;
    }
}
