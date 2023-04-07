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
        int check2=0;
        do{
            check=0;
            if (check2>0)
            {  System.out.println("please try again");}
        System.out.println("please enter your username");

String userName=sc.nextLine();

            check= BuyerController.getBuyerController().signUpUserName(userName);
            check2++;
    }while (check==0);
        check2=0;
        do{
            if (check2>0)
                System.out.println("please try again");

            System.out.println("please enter your password");

            check= BuyerController.getBuyerController().signUpPassWord(sc.nextLine());
            check2++;
        }while (check==0);
        check2=0;
        do{
            if (check2>0)
                System.out.println("please try again");
            System.out.println("please enter your phone number");

            check= BuyerController.getBuyerController().signUpPhoneNum(sc.nextLine());
            check2++;
        }while (check==0);
        check2=0;
        do{
            if (check2>0)
                System.out.println("please try again");
            System.out.println("please enter your email");

            check= BuyerController.getBuyerController().signUpEmail(sc.nextLine());
            check2++;
        }while (check==0);
        check2=0;
        System.out.println("1)send creat account request to admin\n" +
                "2)back");
        String order=sc.nextLine();
        if(order.equals("1"))
        { BuyerController.getBuyerController().creatAccountRequest();
            System.out.println("your request sent to admin");
            String num=sc.nextLine();

            MainMenu.getMainMenu().showMainMenu();}
        else
            MainMenu.getMainMenu().showMainMenu();
}
}
