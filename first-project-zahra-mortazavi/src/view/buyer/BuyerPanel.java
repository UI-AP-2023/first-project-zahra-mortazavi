package view.buyer;

import view.MainMenu;

import java.util.Scanner;

public class BuyerPanel {
    Scanner sc = new Scanner(System.in);

    private BuyerPanel() {
    }

    private static BuyerPanel buyerPanel = new BuyerPanel();

    public static BuyerPanel getBuyerPanel() {
        return buyerPanel;
    }

    public void showBuyerPanel() {
        String check;
        System.out.println("1)show and edit account information\n2)shop\n3)show cart\n4)increase account balance\n5)show Purchase History\n6)back");
        check = sc.nextLine();
        if (check.equals("1")) {
            EditInfo.getEditInfo().editAccountInfo();
        }
        if (check.equals("2")) {
            Shop.getShop().showShop();
        }
        if (check.equals("3")) {
            Buy.getBuy().buyGoods();
        }
        if (check.equals("4")) {
            IncreaseAccountBalance.getIncreaseAccountBalance().increaseBalance();
        }
        if (check.equals("5")) {
            PurchaseHistory.getPurchaseHistory().showPurchaseHistory();
        }
        if (check.equals("6")) {
            MainMenu.getMainMenu().showMainMenu();
        }
    }
}
