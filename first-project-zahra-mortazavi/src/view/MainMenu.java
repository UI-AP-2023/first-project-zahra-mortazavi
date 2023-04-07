package view;

import controller.buyercontroller.BuyerController;
import view.buyer.GuestPanel;
import view.buyer.LongIn;
import view.buyer.SingUp;

import java.util.Scanner;

public class MainMenu {
    private MainMenu() {
    }
private static MainMenu mainMenu=new MainMenu();

    public static MainMenu getMainMenu() {
        return mainMenu;
    }

    Scanner s=new Scanner(System.in);
    public  void showMainMenu(){
        System.out.println( "\n1)sign up\n2)log in\n3)shop");

String num=s.nextLine();

if(num.equals("1")){

    SingUp.getSingUp().signUpBuyer();
}
        if(num.equals("2")){
            BuyerController.getBuyerController().setUserType(BuyerController.UserType.BUYER);

            LongIn.getLongIn().userLongIn();
        }
        if (num.equals("3")){
            BuyerController.getBuyerController().setUserType(BuyerController.UserType.GUEST);

            GuestPanel.getGuestPanel().showGuestPanel();
        }

    }}

