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
        int check2=0;
        String check3;
        do { System.out.println("1)show Account Info\n" +
                "2)edit password\n" +
                "3)edit phone number\n" +
                "4)edit email\n" +
                "5)back\n");

             check3=sc.nextLine();
            // sc.nextLine();
            if (check3.equals("1")){
                System.out.println(BuyerController.getBuyerController().showAccountInfo());
            }
            if (check3.equals("2")){
                check2=0;
                do{
                    if (check2>0)
                        System.out.println("please try again");
                    System.out.println("please enter your password");

                    check= BuyerController.getBuyerController().editPassWord(sc.nextLine());
                    check2++;
                }while (check==0);
                check2=0;
            }
            if (check3.equals("3")){
                do{
                    if (check2>0)
                        System.out.println("please try again");
                    System.out.println("please enter your phone number");

                    check= BuyerController.getBuyerController().editPhoneNum(sc.nextLine());
                    check2++;
                }while (check==0);
                check2=0;
            }
            if (check3.equals("4")){
                do{
                    if (check2>0)
                        System.out.println("please try again");
                    System.out.println("please enter your email");

                    check= BuyerController.getBuyerController().editEmail(sc.nextLine());
                    check2++;
                }while (check==0);
                check2=0;
            }
        }while (check3.equals("5")==false);
BuyerPanel.getBuyerPanel().showBuyerPanel();
    }
}
