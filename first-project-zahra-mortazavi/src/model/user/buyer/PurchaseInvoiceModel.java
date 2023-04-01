package model.user.buyer;
import model.goods.GoodsModel;


import java.util.ArrayList;

public class PurchaseInvoiceModel {
     private static int invoiceId=0;
    final private String purchaseDate;
    final private double purchasePaid;
    final private ArrayList<GoodsModel>purchaseGoods;

    public PurchaseInvoiceModel(String purchaseDate,double purchasePaid,ArrayList<GoodsModel>purchaseGoods) {
        this.purchaseDate = purchaseDate;
        this.purchasePaid=purchasePaid;
        this.invoiceId+=1;
        this.purchaseGoods =purchaseGoods;
    }

    public static int getInvoiceId() {
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

}
