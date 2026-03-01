package model.goods.vehicles;

import model.goods.GoodsCategoryModel;
import model.goods.GoodsModel;

abstract public class Vehicles extends GoodsModel {
    public String getManufacturingCompany() {
        return manufacturingCompany;
    }


    final private String manufacturingCompany;

    protected Vehicles(String goodsName, double goodsPrice, int goodsInventory, String manufacturingCompany) {
        super(goodsName, goodsPrice, goodsInventory, GoodsCategoryModel.VEHICLES);
        this.manufacturingCompany = manufacturingCompany;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nmanufacturingCompany='" + manufacturingCompany + '\''
                ;
    }
}
