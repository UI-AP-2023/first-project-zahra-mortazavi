package model.goods.digitalgoods;

import model.goods.GoodsCategoryModel;

public class FlashMemory extends InfoStorageEquepment {
    final private FlashMemoryType flashMemoryType;
    public FlashMemoryType getFlashMemoryType() {
        return flashMemoryType;
    }




    public FlashMemory(String goodsName, double goodsPrice, int goodsInventory,double weight, String dimensions, int memoryCapacity, FlashMemoryType flashMemoryType) {
        super(goodsName, goodsPrice, goodsInventory, weight, dimensions, memoryCapacity);
        this.flashMemoryType = flashMemoryType;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nflashMemoryType=" + flashMemoryType.getType()
                ;
    }
}
