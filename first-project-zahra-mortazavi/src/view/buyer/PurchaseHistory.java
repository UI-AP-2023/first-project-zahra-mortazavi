package view.buyer;

import controller.buyercontroller.BuyerController;
import controller.goodscontroller.GoodsController;

import java.util.Scanner;

public class PurchaseHistory {
    Scanner sc=new Scanner(System.in);
    private PurchaseHistory() {
    }
    private static PurchaseHistory purchaseHistory=new PurchaseHistory();

    public static PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }
    String order;
    public void showPurchaseHistory(){

        System.out.println( BuyerController.getBuyerController().showPurchaseInvoice()+"\n1)add score\n2)back" );
        order=sc.nextLine();
        if (order.equals("1")){
            System.out.println("please enter Purchase Invoice id ");
            String id=sc.nextLine();
            System.out.println("please enter goods number ");
            String index=sc.nextLine();
            System.out.println("please enter score ");
            String score=sc.nextLine();
            if (GoodsController.getGoodsController().addPurchaseInvoiceGoodsScore(Integer.parseInt(id),Integer.parseInt(index),score)==1) {
                System.out.println("your score added successfully");
            }
            else
                System.out.println("invalid information!");

            System.out.println("2)back");
            String answer=sc.nextLine();
            BuyerPanel.getBuyerPanel().showBuyerPanel();
        };
          if (order.equals("0"))
        BuyerPanel.getBuyerPanel().showBuyerPanel();

        }
    }

