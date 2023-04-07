package view.buyer;

import controller.buyercontroller.BuyerController;

import java.util.Scanner;

public class IncreaseAccountBalance {

    Scanner sc=new Scanner(System.in);
    private IncreaseAccountBalance() {
    }
    private static IncreaseAccountBalance increaseAccountBalance=new IncreaseAccountBalance();

    public static IncreaseAccountBalance getIncreaseAccountBalance() {
        return increaseAccountBalance;
    }
    public void increaseBalance(){
            int check=0;
            int check2=0;
            do{
                if (check2>0)
                    System.out.println("please try again");
                System.out.println("please enter your card number");

                check= BuyerController.getBuyerController().checkCardNumber(sc.nextLine());
                check2++;
            }while (check==0);
            check2=0;
            do{
                if (check2>0)
                    System.out.println("please try again");
                System.out.println("please enter your CVV2");

                check= BuyerController.getBuyerController().checkCvv2(sc.nextLine());
                check2++;
            }while (check==0);
            check2=0;
            do{
                if (check2>0)
                    System.out.println("please try again");
                System.out.println("please enter your password");

                check= BuyerController.getBuyerController().checkAccountPassWord(sc.nextLine());
                check2++;
            }while (check==0);
            check2=0;
            do{
                if (check2>0)
                    System.out.println("please try again");
                System.out.println("please enter your balance increase");

                check= BuyerController.getBuyerController().checkBalanceIncrease(sc.nextDouble());
                check2++;
            }while (check==0);
            check2=0;
            System.out.println("1)send Balance Increase request to admin\n" +
                    "2)back");
        int order=sc.nextInt();
        if(order==1)
        { BuyerController.getBuyerController().requestBalanceIncrease();
            System.out.println("your request sent to admin");
           String num= sc.nextLine();
            BuyerPanel.getBuyerPanel().showBuyerPanel();  }

        else
            BuyerPanel.getBuyerPanel().showBuyerPanel();


        }

}
