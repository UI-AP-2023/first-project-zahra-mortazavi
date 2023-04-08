package view.buyer;

import controller.buyercontroller.BuyerController;

import java.util.Scanner;

public class EditInfo {
    private  EditInfo() {
    }
private static EditInfo editInfo=new EditInfo();

    public static EditInfo getEditInfo() {
        return editInfo;
    }

    Scanner sc=new Scanner(System.in);

    public void editAccountInfo(){
        int check=0;
        int counter=0;
        String newInfo;
        do { System.out.println("1)show Account Info\n" +
                "2)edit password\n" +
                "3)edit phone number\n" +
                "4)edit email\n" +
                "5)back\n");

            newInfo=sc.nextLine();
            if (newInfo.equals("1")){
                System.out.println(BuyerController.getBuyerController().showAccountInfo());
            }
            if (newInfo.equals("2")){
                counter=0;
                do{
                    if (counter>0)
                        System.out.println("please try again");
                    System.out.println("please enter your password");

                    check= BuyerController.getBuyerController().editPassWord(sc.nextLine());
                    counter++;
                }while (check==0);
                counter=0;
            }
            if (newInfo.equals("3")){
                do{
                    if (counter>0)
                        System.out.println("please try again");
                    System.out.println("please enter your phone number");

                    check= BuyerController.getBuyerController().editPhoneNum(sc.nextLine());
                    counter++;
                }while (check==0);
                counter=0;
            }
            if (newInfo.equals("4")){
                do{
                    if (counter>0)
                        System.out.println("please try again");
                    System.out.println("please enter your email");

                    check= BuyerController.getBuyerController().editEmail(sc.nextLine());
                    counter++;
                }while (check==0);
                counter=0;
            }
        }while (newInfo.equals("5")==false);
BuyerPanel.getBuyerPanel().showBuyerPanel();
    }
}
