package model.user.buyer;
import model.goods.GoodsModel;


import java.util.ArrayList;

public class PurchaseInvoiceModel {
     private int invoiceId;
    private static int mainInvoiceId=0;
    final private String purchaseDate;
    final private double purchasePaid;
    final private ArrayList<GoodsModel>purchaseGoods;

    public PurchaseInvoiceModel(String purchaseDate,double purchasePaid,ArrayList<GoodsModel>purchaseGoods) {
        this.purchaseDate = purchaseDate;
        this.purchasePaid=purchasePaid;
        this.mainInvoiceId+=1;
        this.invoiceId=mainInvoiceId;
        this.purchaseGoods =purchaseGoods;
    }

    public int getMainInvoiceId() {
        return mainInvoiceId;
    }


    public  int getInvoiceId() {
        return invoiceId;
    }


    public String getPurchaseDate() {
        return purchaseDate;
    }


    public double getPurchasePaid() {
        return purchasePaid;
    }


    public ArrayList<GoodsModel> getPurchaseGoods() {
        return purchaseGoods;
    }

    @Override
    public String toString() {
        StringBuilder PurchaseInvoiceString=new StringBuilder();
               PurchaseInvoiceString.append( "\ninvoiceId=" + invoiceId + "\npurchaseDate='" + purchaseDate + '\'' + "\npurchasePaid=" + purchasePaid );
         for (GoodsModel goods:purchaseGoods)  {
             PurchaseInvoiceString.append("\n"+(purchaseGoods.indexOf(goods)+1)+")"+goods.toString()+"");
         }
         return PurchaseInvoiceString.toString();
    }
}
