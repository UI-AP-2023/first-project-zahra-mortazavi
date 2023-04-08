package view.goods;

import controller.buyercontroller.BuyerController;
import controller.goodscontroller.GoodsController;
import view.buyer.BuyerPanel;
import view.buyer.GuestPanel;

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
        String answer3=sc.nextLine();
        if (answer3.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findSelectedGoods((Integer.parseInt(num2)));
            showSelectedGoods();
        }
        if (answer3.equals("2")){
            System.out.println("please enter a word");
            search(sc.nextLine());
        }
        if (answer3.equals("3")){
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

if (answer3.equals("4")){
    if (BuyerController.getBuyerController().getUserType()== BuyerController.UserType.GUEST)
        GuestPanel.getGuestPanel().showGuestPanel();
    else
        BuyerPanel.getBuyerPanel().showBuyerPanel();
}


    }
    void showSelectedGoods (){
        String answer;
        System.out.println(GoodsController.getGoodsController().showSelectedGoods());
        do {
            answer=sc.nextLine();
            if (answer.equals("1")){
                System.out.println("enter number of goods that you want");

                BuyerController.getBuyerController().addGoodsToCart(Integer.parseInt(sc.nextLine()));
            }
            if (answer.equals("2")){
                System.out.println(GoodsController.getGoodsController().showSelectedGoodsComments());
            }
            if (answer.equals("3")){
                System.out.println("please write comment text here");
                GoodsController.getGoodsController().commentRequest(sc.nextLine());
            }
            if (answer.equals("4")){
                System.out.println("please enter score here");
                GoodsController.getGoodsController().addScore(sc.nextLine());
            }
        }while (answer.equals("0")==false);
       showShop();
    }
    void search (String word){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().search(word));
        String answer=sc.nextLine();
        if (answer.equals("1")){
            String answer2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(answer2));
            showSelectedGoods();
        }
        if (answer.equals("2")){
            showShop();
        }
    }
    void filterByPrice (double price1,double price2){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterByPrice(price1,price2));
        String answer=sc.nextLine();
        if (answer.equals("1")){
            String answer2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(answer2));
            showSelectedGoods();
        }
        if (answer.equals("2")){
            showShop();
        }
    }
    void filterByScore (double score1,double score2){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterByScore(score1,score2));
        String answer=sc.nextLine();
        if (answer.equals("1")){
            String answer2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(answer2));
            showSelectedGoods();
        }
        if (answer.equals("2")){
            showShop();
        }
    }
    void filterByInventory (){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterByInventory());
        String answer=sc.nextLine();
        if (answer.equals("1")){
            String answer2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(answer2));
            showSelectedGoods();
        }
        if (answer.equals("2")){
            showShop();
        }
    }
    void filterByCategory(int number){
        System.out.println("\n1)select a good\n2)filter  by type\n3)back"+GoodsController.getGoodsController().filterCategory(number));
        String answer=sc.nextLine();
        if (answer.equals("1")){
            String answer2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(answer2));
            showSelectedGoods();
        }
        if (answer.equals("2")){
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
        if (answer.equals("3")){
            showShop();
    }}
        void filterDigitalGoods (int number){
            if ((number == 1)||(number == 3)) {
                System.out.println("\n1)select a good\n2)filter\n0)back"+GoodsController.getGoodsController().filterStationary(number));
            }
            else
            {System.out.println("\n1)select a good\n0)back"+GoodsController.getGoodsController().filterDigitalGoods(number));}
            String num=sc.nextLine();
            if (num.equals("1")){
                String num2=sc.nextLine();
                GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
                showSelectedGoods();
            }
            if (num.equals("2")){
                if (number==1)
                { System.out.println("\n1)Single-core CPU,\n2)Dual-core CPU,\n3)Quad-core CPU,\n4)Hexa Core processors,\n5)Octa-core processors,\n6)Deca-core processor");
                String number4=sc.nextLine();
                filterPc(Integer.parseInt(number4));}
                if (number==3)
                {   System.out.println("\n1)USB-A\n2)USB-B\n3)USB-C\n4)Mini USB\n5)Micro USB");
                String number4=sc.nextLine();
                filterUsb(Integer.parseInt(number4));
            }}

            if (num.equals("0")){
                showShop();
            }
        }
    void filterStationery (int number){
        if (number == 2) {
            System.out.println("\n1)select a good\n2)filter\n0)back"+GoodsController.getGoodsController().filterStationary(number));
        }
        else
        {System.out.println("\n1)select a good\n0)back"+GoodsController.getGoodsController().filterStationary(number));}
        String answer=sc.nextLine();
        if (answer.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (answer.equals("2")){
            System.out.println("\n1)B\n2)H2\n3)F\n4)HB\nH");
            String number4=sc.nextLine();
            filterPencil(Integer.parseInt(number4));
        }
        if (answer.equals("0")){
            showShop();
        }
    }
    void filterVehicle (int number){
        System.out.println("\n1)select a good\n2)filter\n0)back"+GoodsController.getGoodsController().filterVehicle(number));
        String answer2=sc.nextLine();
        if (answer2.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (answer2.equals("2")){
            if (number==1)
            {System.out.println("\n1)automatic\n2)not automatic");
            String number3= sc.nextLine();
            filterCar(Integer.parseInt(number3));
            }

            if (number==2){
                System.out.println("\n1)city bike\n2)mountain bike\n3)hybrid bike\n4)road bike");
                String number3= sc.nextLine();
                filterBike(Integer.parseInt(number3));
            }
        }

        if (answer2.equals("0")){
            showShop();
        }
    }
    void filterCar (int number){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterCar(number));
        String answer2=sc.nextLine();
        if (answer2.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (answer2.equals("2")){
            showShop();
        }
    }
    void filterBike (int number){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterBikes(number));
        String answer2=sc.nextLine();
        if (answer2.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (answer2.equals("2")){
            showShop();
        }
    }
    void filterPc (int number){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterPc(number));
        String answer2=sc.nextLine();
        if (answer2.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (answer2.equals("2")){
            showShop();
        }
    }
    void filterUsb(int number){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterFlash(number));
        String answer2=sc.nextLine();
        if (answer2.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (answer2.equals("2")){
            showShop();
        }
    }
    void filterPencil (int number){
        System.out.println("\n1)select a good\n2)back"+GoodsController.getGoodsController().filterPencil(number));
        String answer2=sc.nextLine();
        if (answer2.equals("1")){
            String num2=sc.nextLine();
            GoodsController.getGoodsController().findFilterGoodsIndex(Integer.parseInt(num2));
            showSelectedGoods();
        }
        if (answer2.equals("2")){
            showShop();
        }
    }

}
