package view.buyer;

import controller.buyercontroller.BuyerController;
import view.admin.AdminPanel;

import java.util.Scanner;

public class LongIn {
    Scanner sc=new Scanner(System.in);
    private LongIn() {
    }
    private static LongIn longIn=new LongIn();

    public static LongIn getLongIn() {
        return longIn;
    }
    int logInCheck;
    int logInCounter=0;
    public void userLongIn(){
        logInCounter=0;
        do {
            if(logInCounter>0){
                System.out.println("please try again");
            }
            System.out.println("please enter your userName");
            String userName = sc.nextLine();
            System.out.println("please enter your password");
             logInCheck = BuyerController.getBuyerController().LogIn(userName, sc.nextLine());
             logInCounter++;
        }while (logInCheck==2);
        if (logInCheck==0){
            AdminPanel.getAdminPanel().showAdminPanel();
        }
        if (logInCheck==1){
            BuyerPanel.getBuyerPanel().showBuyerPanel();
        }
    }
}
