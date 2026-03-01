package model.goods.vehicles;

import model.goods.GoodsCategoryModel;

public class Bike extends Vehicles {
    final private BikeType bikeType;

    public Bike(String goodsName, double goodsPrice, int goodsInventory, String manufacturingCompany, BikeType bikeType) {
        super(goodsName, goodsPrice, goodsInventory, manufacturingCompany);
        this.bikeType = bikeType;
    }

    public BikeType getBikeType() {
        return bikeType;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nbikeType=" + bikeType.getType() ;
    }
}
