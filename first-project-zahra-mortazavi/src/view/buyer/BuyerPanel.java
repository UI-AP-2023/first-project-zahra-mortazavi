package view.buyer;

import view.MainMenu;
import view.goods.Shop;

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
        String answer;
        System.out.println("1)show and edit account information\n2)shop\n3)show cart\n4)increase account balance\n5)show Purchase History\n6)back");
        answer = sc.nextLine();
        if (answer.equals("1")) {
            EditInfo.getEditInfo().editAccountInfo();
        }
        if (answer.equals("2")) {
            Shop.getShop().showShop();
        }
        if (answer.equals("3")) {
            Buy.getBuy().buyGoods();
        }
        if (answer.equals("4")) {
            IncreaseAccountBalance.getIncreaseAccountBalance().increaseBalance();
        }
        if (answer.equals("5")) {
            PurchaseHistory.getPurchaseHistory().showPurchaseHistory();
        }
        if (answer.equals("6")) {
            MainMenu.getMainMenu().showMainMenu();
        }
    }
}
