package view.buyer;

import view.MainMenu;
import view.goods.Shop;

import java.util.Scanner;

public class GuestPanel {
    private GuestPanel() {
    }
    Scanner sc=new Scanner(System.in);
    private static GuestPanel guestPanel=new GuestPanel();

    public static GuestPanel getGuestPanel() {
        return guestPanel;
    }
    public void showGuestPanel(){
    String answer;
        System.out.println("\n1)shop\n2)show cart\n3)back");
        answer=sc.nextLine();
        if (answer.equals("1")){
            Shop.getShop().showShop();
        }
        if (answer.equals("2")){
            Buy.getBuy().buyGoods();
    }
        if (answer.equals("3")){
        MainMenu.getMainMenu().showMainMenu();
    }

}}
