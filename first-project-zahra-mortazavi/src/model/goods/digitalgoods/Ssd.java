package model.goods.digitalgoods;

import model.goods.GoodsCategoryModel;

public class Ssd extends InfoStorageEquepment {


    public Ssd(String goodsName, double goodsPrice, int goodsInventory, double weight, String dimensions, int memoryCapacity, double readingSpeed, double writingSpeed) {
        super(goodsName, goodsPrice, goodsInventory, weight, dimensions, memoryCapacity);
        this.readingSpeed = readingSpeed;
        this.writingSpeed = writingSpeed;
    }

    public double getReadingSpeed() {
        return readingSpeed;
    }


    public double getWritingSpeed() {
        return writingSpeed;
    }


   final private double readingSpeed;
  final private double writingSpeed;

    @Override
    public String toString() {
        return super.toString()+
                "\nreadingSpeed=" + readingSpeed +
                "\nwritingSpeed=" + writingSpeed
               ;
    }
}
