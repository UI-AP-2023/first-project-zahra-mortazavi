package model.user.buyer;

import model.goods.GoodsModel;
import model.user.UserModel;
import  model.user.UserModel;
import java.util.ArrayList;

public class BuyerModel extends UserModel {
    BuyerModel(String userName,String passWord,String email,String phoneNumber){
        super(userName,passWord,email,phoneNumber);
        cart=new ArrayList<GoodsModel>();
        purchaseHistory=new ArrayList<PurchaseInvoiceModel>();
    }
    private ArrayList<GoodsModel>cart;
   private ArrayList<PurchaseInvoiceModel>purchaseHistory;
   private double userAccountBalance;
   public ArrayList<PurchaseInvoiceModel>getPurchaseHistory(){
       return purchaseHistory;
   }
   public ArrayList<GoodsModel>getCart(){
       return cart;
   }
   double getUserAccountBalance(){
       return userAccountBalance;
   }
   void setUserAccountBalance(double balance){
       this.userAccountBalance=balance;
   }

    @Override
    public String toString() {
        return
                "\nuserAccountBalance=" + userAccountBalance
                ;
    }
}
