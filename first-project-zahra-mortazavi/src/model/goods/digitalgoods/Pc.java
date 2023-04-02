package model.goods.digitalgoods;

import model.goods.GoodsCategoryModel;

public class Pc extends DigitalGoods {
   final private CpuModel CpuModel;
  final private int RamCapacity;

    public Pc(String goodsName, double goodsPrice, int goodsInventory, double weight, String dimensions, CpuModel cpuModel, int ramCapacity) {
        super(goodsName, goodsPrice, goodsInventory, weight, dimensions);
        CpuModel = cpuModel;
        RamCapacity = ramCapacity;
    }

    public CpuModel getCpuModel() {
        return CpuModel;
    }


    public int getRamCapacity() {
        return RamCapacity;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nCpuModel='" + CpuModel.getModel() + '\'' +
                "\nRamCapacity='" + RamCapacity +"GB"+ '\''
               ;
    }
}
