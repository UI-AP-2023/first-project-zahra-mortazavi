package view.buyer;

import controller.buyercontroller.BuyerController;
import controller.goodscontroller.GoodsController;

import java.util.Scanner;

public class Shop {
    private Shop() {
    }
    Scanner sc=new Scanner(System.in);
    private static Shop shop = new Shop();

    public static Shop getShop() {
        return shop;
    }

    public void showShop() {
        System.out.println("\n1)select a good\n2)search\n3)filter\n4)back" + GoodsController.getGoodsController().showAllGoods());
        String num=sc.nextLine();
        if (num.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findSelectedGoods((Integer.parseInt(num2)));
            showSelectedGoods();
        }
        if (num.equals("2")){
            System.out.println("please enter a word");
            search(sc.nextLine());
        }
        if (num.equals("3")){
            System.out.println("filter by\n1)Category\n2)inventory\n3)price\n4)score");
            String answer=sc.nextLine();
            if (answer.equals("1")) {
                System.out.println("\n1)digital goods\n2)stationary\n3)vehicle\n4)edible");
                String answer2 = sc.nextLine();
                filterByCategory(Integer.parseInt(answer2));
            }
            if (answer.equals("2")) {
                filterByInventory();
            }
            if (answer.equals("3")) {
                System.out.println("please enter min and max price that you want");
                filterByPrice(Double.parseDouble(sc.nextLine()),Double.parseDouble(sc.nextLine()));
            }
            if (answer.equals("4")) {
                System.out.println("please enter min and max score that you want");
                filterByScore(Double.parseDouble(sc.nextLine()),Double.parseDouble(sc.nextLine()));
            }
        }

if (num.equals("4")){
    if (BuyerController.getBuyerController().getUserType()== BuyerController.UserType.GUEST)
        GuestPanel.getGuestPanel().showGuestPanel();
    else
        BuyerPanel.getBuyerPanel().showBuyerPanel();
}


    }
    void showSelectedGoods (){
        String num;
        System.out.println(GoodsController.getGoodsController().showSelectedGoods());
        do {
             num=sc.nextLine();
            if (num.equals("1")){
                System.out.println("enter number of goods that you want");

                BuyerController.getBuyerController().addGoodsToCart(Integer.parseInt(sc.nextLine()));
            }
            if (num.equals("2")){
                System.out.println(GoodsController.getGoodsController().showSelectedGoodsComments());
            }
            if (num.equals("3")){
                System.out.println("please write comment text here");
                GoodsController.getGoodsController().commentRequest(sc.nextLine());
            }
            if (num.equals("4")){
                System.out.println("please enter score here");
                GoodsController.getGoodsController().addScore(sc.nextLine());
            }
        }while (num.equals("0")==false);
       showShop();
    }
    void search (String word){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().search(word));
        String num=sc.nextLine();
        if (num.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (num.equals("2")){
            showShop();
        }
    }
    void filterByPrice (double price1,double price2){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterByPrice(price1,price2));
        String num=sc.nextLine();
        if (num.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (num.equals("2")){
            showShop();
        }
    }
    void filterByScore (double score1,double score2){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterByScore(score1,score2));
        String num=sc.nextLine();
        if (num.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (num.equals("2")){
            showShop();
        }
    }
    void filterByInventory (){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterByInventory());
        String num=sc.nextLine();
        if (num.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (num.equals("2")){
            showShop();
        }
    }
    void filterByCategory(int number){
        System.out.println("\n1)select a good\n2)filter  by type\n3)back"+GoodsController.getGoodsController().filterCategory(number));
        String num=sc.nextLine();
        if (num.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (num.equals("2")){
            if(number==1){
                System.out.println("\n1)pc\n2)SSD\n3)flash");
                filterDigitalGoods(Integer.parseInt(sc.nextLine()));
            }
            if(number==2){
                System.out.println("\n1)pen\n2)pencil\n3)note book");
                filterStationery(Integer.parseInt(sc.nextLine()));
            }
            if(number==3){
                System.out.println("\n1)car\n2)bike");
                filterVehicle(Integer.parseInt(sc.nextLine()));
            }
        }
        if (num.equals("3")){
            showShop();
    }}
        void filterDigitalGoods (int number){
            System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterDigitalGoods(number));
            String num=sc.nextLine();
            if (num.equals("1")){
                String num2=sc.nextLine();
                GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
                showSelectedGoods();
            }
            if (num.equals("2")){
                showShop();
            }
        }
    void filterStationery (int number){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterStationary(number));
        String num=sc.nextLine();
        if (num.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (num.equals("2")){
            showShop();
        }
    }
    void filterVehicle (int number){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterVehicle(number));
        String num=sc.nextLine();
        if (num.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (num.equals("2")){
            showShop();
        }
    }
}
