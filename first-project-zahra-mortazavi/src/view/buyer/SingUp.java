package view.buyer;

import controller.buyercontroller.BuyerController;
import view.MainMenu;

import java.util.Scanner;

public class SingUp {
    private SingUp() {
    }


    private static SingUp singUp=new SingUp();

    public static SingUp getSingUp() {
        return singUp;
    }

    Scanner sc=new Scanner(System.in);

    public  void signUpBuyer(){
        int check=0;
        int counter=0;
        do{

            if (counter>0)
            {  System.out.println("please try again");}
        System.out.println("please enter your username");

String userName=sc.nextLine();

            check= BuyerController.getBuyerController().signUpUserName(userName);
            counter++;
    }while (check==0);
        counter=0;
        do{
            if (counter>0)
                System.out.println("please try again");

            System.out.println("please enter your password");

            check= BuyerController.getBuyerController().signUpPassWord(sc.nextLine());
            counter++;
        }while (check==0);
        counter=0;
        do{
            if (counter>0)
                System.out.println("please try again");
            System.out.println("please enter your phone number");

            check= BuyerController.getBuyerController().signUpPhoneNum(sc.nextLine());
            counter++;
        }while (check==0);
        counter=0;
        do{
            if (counter>0)
                System.out.println("please try again");
            System.out.println("please enter your email");

            check= BuyerController.getBuyerController().signUpEmail(sc.nextLine());
            counter++;
        }while (check==0);
        counter=0;
        System.out.println("1)send creat account request to admin\n" +
                "2)back");
        String order=sc.nextLine();
        if(order.equals("1"))
        { BuyerController.getBuyerController().creatAccountRequest();
            System.out.println("your request sent to admin");

            MainMenu.getMainMenu().showMainMenu();}
        else
            MainMenu.getMainMenu().showMainMenu();
}
}
