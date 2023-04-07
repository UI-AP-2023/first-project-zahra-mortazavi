package controller.buyercontroller;

import controller.admincontroller.AdminController;
import controller.goodscontroller.GoodsController;
import model.goods.GoodsModel;
import model.request.Request;
import model.user.UserModel;
import model.user.buyer.BalanceIncrease;
import model.user.buyer.BuyerModel;
import model.user.buyer.PurchaseInvoiceModel;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuyerController {
    private BuyerController() {
        buyers = new ArrayList<BuyerModel>();
    }

    private static BuyerController buyerController = new BuyerController();

    public static BuyerController getBuyerController() {
        return buyerController;
    }
    private static int usersIndex;
    private static ArrayList<BuyerModel> buyers;


    private String userName;
    private String passWord;
    private String email;
    private String phoneNumber;
    private String cardNumber;
    private String accountPassWord;
    private String cardCvv2;
    private double balanceIncrease1;

    public String getCardNumber() {
        return cardNumber;
    }

    public String getAccountPassWord() {
        return accountPassWord;
    }

    public String getCardCvv2() {
        return cardCvv2;
    }

    public double getBalanceIncrease1() {
        return balanceIncrease1;
    }

    public static int getUsersIndex() {
        return usersIndex;
    }


    public static ArrayList<BuyerModel> getBuyers() {
        return buyers;
    }

    public static void setBuyers(ArrayList<BuyerModel> buyers) {
        BuyerController.buyers = buyers;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    int signUpUserName(String userName) {
        boolean check = false;
        boolean check2 = false;
        for (Request request:AdminController.getRequests()){
            if (request instanceof UserModel){
                if (((UserModel) request).getEmail().equals(email)){
                    check2=true;
                }
            }
        }
        for (BuyerModel buyer : buyers) {
            if (buyer.getUserName().equals(userName)){
                check = true;
            }

        }
        if (check==true||check2==true||userName.equals("admin"))
            return 0;
        this.userName = userName;
        return 1;
    }

    int signUpEmail(String email) {
        boolean check = false;
        boolean check2 = false;
        for (BuyerModel buyer : buyers) {
            if (buyer.getEmail().equals(email)) {
                check = true;
            }
        }
        for (Request request:AdminController.getRequests()){
            if (request instanceof UserModel){
                if (((UserModel) request).getEmail().equals(email)){
                    check2=true;
                }
            }
        }
        Pattern pattern = Pattern.compile("^[a-zA-z0-9._%+-]+[@gmail\\.com|@yahoo\\.com]$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find() == true && check == false&&check2==false) {
            this.email = email;
            return 1;
        } else
            return 0;

    }

    int signUpPassWord(String passWord) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
        Matcher matcher = pattern.matcher(passWord);
        if (matcher.find() == true) {
            this.accountPassWord = passWord;
            return 1;
        } else
            return 0;

    }

    int signUpPhoneNum(String phoneNum) {
        boolean check = false;
        boolean check2 = false;
        for (BuyerModel buyer : buyers) {
            if (buyer.getPhoneNumber().equals(phoneNum)) {
                check = true;
            }
        }
        for (Request request:AdminController.getRequests()){
            if (request instanceof UserModel){
                if (((UserModel) request).getEmail().equals(email)){
                    check2=true;
                }
            }
        }
        Pattern pattern = Pattern.compile("^09[1-3]\\d{8}$");
        Matcher matcher = pattern.matcher(phoneNum);
        if (matcher.find() == true && check == false) {
            this.phoneNumber = phoneNumber;
            return 1;
        } else
            return 0;

    }

    String creatAccountRequest() {
        BuyerModel buyer = new BuyerModel(userName,accountPassWord, email, phoneNumber);
AdminController.getRequests().add(buyer);
return "your request sent to admin!";
    }
    public int logIn(String userName,String passWord){
        if (userName.equals("admin")&&passWord.equals("admin"))
            return 0;
        for (BuyerModel buyer:buyers){
            if(buyer.getUserName().equals(userName)&&buyer.getPassWord().equals(passWord)){
               usersIndex= buyers.indexOf(buyer);
                return 1;}}
    return 2;}


    int editEmail(String email) {
        boolean check = false;
        boolean check2 = false;
        for (BuyerModel buyer : buyers) {
            if (buyer.getEmail().equals(email)) {
                check = true;
            }
        }
        for (Request request:AdminController.getRequests()){
            if (request instanceof UserModel){
                if (((UserModel) request).getEmail().equals(email)){
                    check2=true;
                }
            }
        }
        Pattern pattern = Pattern.compile("^[a-zA-z0-9._%+-]+[@gmail\\.com|@yahoo\\.com]$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find() == true && check == false&&check2==false) {

                   buyers.get(usersIndex).setEmail(email);
            return 1;
        } else
            return 0;

    }

    int editPassWord(String passWord) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
        Matcher matcher = pattern.matcher(passWord);
        if (matcher.find() == true) {
            buyers.get(usersIndex).setPassWord(passWord);


            return 1;
        } else
            return 0;

    }

    int editPhoneNum(String phoneNum) {
        boolean check = false;
        boolean check2 = false;
        for (BuyerModel buyer : buyers) {
            if (buyer.getPhoneNumber().equals(phoneNum)) {
                check = true;
            }
        }
        for (Request request:AdminController.getRequests()){
            if (request instanceof UserModel){
                if (((UserModel) request).getEmail().equals(email)){
                    check2=true;
                }
            }
        }
        Pattern pattern = Pattern.compile("^09[1-3]\\d{8}$");
        Matcher matcher = pattern.matcher(phoneNum);
        if (matcher.find() == true && check == false) {
            buyers.get(usersIndex).setPhoneNumber(phoneNum);
            return 1;
        } else
            return 0;

    }
       public String showAccountInfo(){
            return buyers.get(usersIndex).toString();
        }

       public int checkCardNumber(String cardNum){
           Pattern pattern = Pattern.compile("^\\d{16}$");
           Matcher matcher = pattern.matcher(cardNum);
           if (matcher.find() == true ){
               this.cardNumber=cardNum;
               return 1;
           }
           else
               return 0;
       }
    public int checkCvv2(String cvv2){
        Pattern pattern = Pattern.compile("^\\d{3}$");
        Matcher matcher = pattern.matcher(cvv2);
        if (matcher.find() == true ){
            this.cardCvv2=cvv2;
            return 1;
        }
        else
            return 0;
    }
    public int checkAccountPassWord(String accountPassWord){
        Pattern pattern = Pattern.compile("^\\d{5,}$");
        Matcher matcher = pattern.matcher(accountPassWord);
        if (matcher.find() == true ){
            this.accountPassWord=accountPassWord;
            return 1;
        }
        else
            return 0;
    }
    public int balanceIncrease(double balance){
        if (balance>0){
            this.balanceIncrease1=balance;
            return 1;
        }
            else
                return 0;
    }
    public void requestBalanceIncrease(){
        BalanceIncrease balanceIncrease=new BalanceIncrease(buyers.get(usersIndex),cardNumber,passWord,cardCvv2,balanceIncrease1);
        AdminController.getRequests().add(balanceIncrease);
    }
    public StringBuilder showCart(){
        StringBuilder cartGoods=new StringBuilder();
        for (GoodsModel goods:buyers.get(usersIndex).getCart()){
            cartGoods.append((buyers.get(usersIndex).getCart().indexOf(goods)+1)+")\n"+goods.toString()+"\n");
        }
        return cartGoods;
    }
    public void removeGoods(int index){
        buyers.get(usersIndex).getCart().remove((index-1));
    }
    public void addGoodsToCart(int number){
        buyers.get(usersIndex).getCart().add(GoodsController.getGoodsList().get(GoodsController.getSelectedGoodsIndex()));
        buyers.get(usersIndex).getCart().get((buyers.get(usersIndex).getCart().size()-1)).setGoodsInventory(number);
        }
     public String showPurchaseInvoice(){
        StringBuilder allPurchaseInvoice=new StringBuilder();
        for (PurchaseInvoiceModel purchaseInvoice:buyers.get(usersIndex).getPurchaseHistory()){
            allPurchaseInvoice.append(purchaseInvoice.toString());
        }
        return allPurchaseInvoice.toString();
     }
     private double totalPrice;
     public String buyGoods(){
         totalPrice=0;
        for (GoodsModel goods :buyers.get(usersIndex).getCart()){
            for (GoodsModel goods1:GoodsController.getGoodsList()){
                if (goods.getGoodsId()==goods1.getGoodsId()){
                    if (goods.getGoodsInventory()>goods1.getGoodsInventory()){
                        return goods.getGoodsName()+" is not available  enough in the shop !";
                    }
                }
            }
        }
         for (GoodsModel goods :buyers.get(usersIndex).getCart()){
             totalPrice=totalPrice+(goods.getGoodsPrice()*goods.getGoodsInventory());
         }
        if (totalPrice>buyers.get(usersIndex).getUserAccountBalance()){
            return "your Account Balance is insufficient !";
        }
         for (GoodsModel goods :buyers.get(usersIndex).getCart()){
             for (GoodsModel goods1:GoodsController.getGoodsList()){
                 if (goods.getGoodsId()==goods1.getGoodsId()){
                  goods1.setGoodsInventory( ( goods1.getGoodsInventory()-goods.getGoodsInventory()));}}}
         buyers.get(usersIndex).setUserAccountBalance(buyers.get(usersIndex).getUserAccountBalance()-totalPrice);
                     PurchaseInvoiceModel purchaseInvoice=new PurchaseInvoiceModel("1402/18/1",totalPrice,buyers.get(usersIndex).getCart());
         buyers.get(usersIndex).getPurchaseHistory().add(purchaseInvoice);
         return "youre Purchase was successful !";
     }
    }

