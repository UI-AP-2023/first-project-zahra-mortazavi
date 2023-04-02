package model.goods.vehicles;

import model.goods.GoodsCategoryModel;

public class Car extends Vehicles {
   final private int carEngineVolume;
    final   private boolean AutomaticCar;

    public double getCarEngineVolume() {
        return carEngineVolume;
    }


    public boolean isAutomaticCar() {
        return AutomaticCar;
    }




    public Car(String goodsName, double goodsPrice, int goodsInventory, String manufacturingCompany, int carEngineVolume, boolean automaticCar) {
        super(goodsName, goodsPrice, goodsInventory, manufacturingCompany);
        this.carEngineVolume = carEngineVolume;
        AutomaticCar = automaticCar;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\ncarEngineVolume=" + carEngineVolume +
                "\nAutomaticCar=" + AutomaticCar ;
    }


}
