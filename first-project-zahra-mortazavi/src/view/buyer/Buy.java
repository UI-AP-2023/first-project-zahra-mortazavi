package view.buyer;

import controller.buyercontroller.BuyerController;
import view.goods.Shop;

import java.util.Scanner;

public class Buy {
    Scanner sc=new Scanner(System.in);
    private Buy() {
    }
    private static Buy buy=new Buy();

    public static Buy getBuy() {
        return buy;
    }
    public void buyGoods(){
        String answer;
        System.out.println(BuyerController.getBuyerController().showCart());
        do {
          answer=sc.nextLine();
          if (answer.equals("1")){
              System.out.println(BuyerController.getBuyerController().buyGoods());
          }
            if (answer.equals("2")){
                BuyerController.getBuyerController().removeGoods(Integer.parseInt(sc.nextLine()));
                buyGoods();
            }
            if (answer.equals("3")){
                System.out.println(BuyerController.getBuyerController().buyGoods());
                Shop.getShop().showShop();
            }
            if (answer.equals("5")){
                SingUp.getSingUp().signUpBuyer();
            }

        }while (answer.equals("4")==false);
if (BuyerController.getBuyerController().getUserType()== BuyerController.UserType.BUYER){
    BuyerPanel.getBuyerPanel().showBuyerPanel();}
else
    GuestPanel.getGuestPanel().showGuestPanel();
    }
}
