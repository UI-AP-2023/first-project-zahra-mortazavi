package view.admin;

import controller.admincontroller.AdminController;
import view.MainMenu;

import java.util.Scanner;

public class AdminPanel {
    Scanner sc=new Scanner(System.in);
    private AdminPanel() {
    }
    private static AdminPanel adminPanel=new AdminPanel();

    public static AdminPanel getAdminPanel() {
        return adminPanel;

    }
    String order;
    public void showAdminPanel(){
        System.out.println("* enter\"help\" for directions\n**  enter\"exit\"to go to main menu");
        do {
             order=sc.nextLine();
            System.out.println(AdminController.getAdminController().findOrder(order));

        }while (order.equals("exit")==false);
        MainMenu.getMainMenu().showMainMenu();
    }
}
