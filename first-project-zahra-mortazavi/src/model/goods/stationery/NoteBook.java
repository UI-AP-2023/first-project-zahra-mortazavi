package model.goods.stationery;

import model.goods.GoodsCategoryModel;
import model.goods.stationery.Stationery;

public class NoteBook extends Stationery {
    private int pageNum;
   private PaperType paperType;

    public NoteBook(String goodsName, double goodsPrice, int goodsInventory, String producingCountry, int pageNum,PaperType paperType) {
        super(goodsName, goodsPrice, goodsInventory, producingCountry);
        this.pageNum = pageNum;
        this.paperType = paperType;
    }

    public int getPageNum() {
        return pageNum;
    }


    public PaperType getPaperType() {
        return paperType;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\npageNum=" + pageNum +
                "\npaperType='" + paperType.getType() + '\'';
    }
}
