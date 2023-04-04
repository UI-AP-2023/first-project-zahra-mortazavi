package model.goods.edible;

import model.goods.GoodsCategoryModel;
import model.goods.GoodsModel;

public class Edible extends GoodsModel {
 final   private String edibleP;

  public Edible(String goodsName, double goodsPrice, int goodsInventory, GoodsCategoryModel goodsCategoryModel, String edibleP, String edibleExp) {
   super(goodsName, goodsPrice, goodsInventory, goodsCategoryModel);
   this.edibleP = edibleP;
   this.edibleExp = edibleExp;
  }

  public String getEdibleExp() {
   return edibleExp;
  }


 final private String edibleExp;

  public String getEdibleP() {
   return edibleP;
  }

 @Override
 public String toString() {
  return super.toString()+
          "\nedibleP='" + edibleP + '\'' +
          "\nedibleExp='" + edibleExp + '\''
          ;
 }
}
