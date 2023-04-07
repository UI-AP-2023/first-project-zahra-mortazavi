package view.buyer;

import view.MainMenu;

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
    String check;
        System.out.println("\n1)shop\n2)show cart\n3)back");
    check=sc.nextLine();
        if (check.equals("1")){
            Shop.getShop().showShop();
        }
        if (check.equals("2")){
            Buy.getBuy().buyGoods();
    }
        if (check.equals("3")){
        MainMenu.getMainMenu().showMainMenu();
    }

}}
