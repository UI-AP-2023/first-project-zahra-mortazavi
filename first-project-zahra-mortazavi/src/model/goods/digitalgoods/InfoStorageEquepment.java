package model.goods.digitalgoods;

import model.goods.GoodsCategoryModel;

abstract public class InfoStorageEquepment extends DigitalGoods {
    final private int memoryCapacity;

    public InfoStorageEquepment(String goodsName, double goodsPrice, int goodsInventory, double weight, String dimensions, int memoryCapacity) {
        super(goodsName, goodsPrice, goodsInventory, weight, dimensions);
        this.memoryCapacity = memoryCapacity;
    }

    public int getMemoryCapacity() {
        return memoryCapacity;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nmemoryCapacity=" + memoryCapacity ;
    }
}
