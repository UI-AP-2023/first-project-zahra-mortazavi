package controller.buyercontroller;

import controller.admincontroller.AdminController;
import controller.goodscontroller.GoodsController;
import model.goods.GoodsModel;
import model.goods.digitalgoods.FlashMemory;
import model.goods.digitalgoods.Pc;
import model.goods.digitalgoods.Ssd;
import model.goods.edible.Edible;
import model.goods.stationery.NoteBook;
import model.goods.stationery.Pen;
import model.goods.stationery.Pencil;
import model.goods.vehicles.Bike;
import model.goods.vehicles.Car;
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
        guestCart = new ArrayList<GoodsModel>();
        backUpCart=new ArrayList<>();
    }

    private ArrayList<GoodsModel> guestCart;


    public enum UserType {
        GUEST, BUYER;
    }

    private UserType userType;


    private static BuyerController buyerController = new BuyerController();

    public static BuyerController getBuyerController() {
        return buyerController;
    }

    private static int usersIndex;
    private static ArrayList<BuyerModel> buyers;


    private String userName;
    private String passWord;
    private String email;
    private String phoneNumber1;
    private String cardNumber;
    private String accountPassWord;
    private String cardCvv2;
    private double balanceIncrease1;

    ArrayList<GoodsModel>backUpCart;
    public ArrayList<GoodsModel> getGuestCart() {
        return guestCart;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public static int getUsersIndex() {
        return usersIndex;
    }

    public static ArrayList<BuyerModel> getBuyers() {
        return buyers;
    }


    public int signUpUserName(String userName) {
        boolean check = false;
        boolean check2 = false;
        for (Request request : AdminController.getRequests()) {
            if (request instanceof UserModel) {
                if (((UserModel) request).getUserName().equals(userName)) {
                    check2 = true;
                }
            }
        }
        for (BuyerModel buyer : buyers) {
            if (buyer.getUserName().equals(userName)) {
                check = true;
            }

        }
        if (check || check2 || userName.equals("admin"))
            return 0;
        this.userName = userName;
        return 1;
    }

    public int signUpEmail(String email) {
        boolean check = false;
        boolean check2 = false;
        for (BuyerModel buyer : buyers) {
            if (buyer.getEmail().equals(email)) {
                check = true;
            }
        }
        for (Request request : AdminController.getRequests()) {
            if (request instanceof UserModel) {
                if (((UserModel) request).getEmail().equals(email)) {
                    check2 = true;
                }
            }
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z\\d_%+-]+@gmail\\.com$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find() == true && check == false && check2 == false) {
            this.email = email;
            return 1;
        } else
            return 0;

    }

    public int signUpPassWord(String passWord) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
        Matcher matcher = pattern.matcher(passWord);
        if (matcher.find() == true) {
            this.accountPassWord = passWord;
            return 1;
        } else
            return 0;

    }

    public int signUpPhoneNum(String phoneNum) {
        boolean check = false;
        boolean check2 = false;
        for (BuyerModel buyer : buyers) {
            if (buyer.getPhoneNumber().equals(phoneNum)) {
                check = true;
            }
        }
        for (Request request : AdminController.getRequests()) {
            if (request instanceof UserModel) {
                if (((UserModel) request).getPhoneNumber().equals(phoneNum)) {
                    check2 = true;
                }
            }
        }
        Pattern pattern = Pattern.compile("^09[1-3]\\d{8}$");
        Matcher matcher = pattern.matcher(phoneNum);
        if (matcher.find() == true && check == false && check2 == false) {
            this.phoneNumber1 = phoneNum;
            return 1;
        } else
            return 0;

    }

    public String creatAccountRequest() {
        BuyerModel buyer = new BuyerModel(userName, accountPassWord, email, phoneNumber1);
        buyer.setCart(guestCart);

        AdminController.getRequests().add(buyer);
        return "your request sent to admin!";
    }

    public int LogIn(String userName, String passWord) {
        if (userName.equals("admin") && passWord.equals("admin"))
            return 0;
        for (BuyerModel buyer : buyers) {
            if (buyer.getUserName().equals(userName) && buyer.getPassWord().equals(passWord)) {
                usersIndex = buyers.indexOf(buyer);
                return 1;
            }
        }
        return 2;
    }


    public int editEmail(String email) {
        boolean check = false;
        boolean check2 = false;
        for (BuyerModel buyer : buyers) {
            if (buyer.getEmail().equals(email)) {
                check = true;
            }
        }
        for (Request request : AdminController.getRequests()) {
            if (request instanceof UserModel) {
                if (((UserModel) request).getEmail().equals(email)) {
                    check2 = true;
                }
            }
        }
        Pattern pattern = Pattern.compile("^[a-zA-z0-9._%+-]+[@gmail\\.com|@yahoo\\.com]$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find() == true && check == false && check2 == false) {

            buyers.get(usersIndex).setEmail(email);
            return 1;
        } else
            return 0;

    }

    public int editPassWord(String passWord) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
        Matcher matcher = pattern.matcher(passWord);
        if (matcher.find() == true) {
            buyers.get(usersIndex).setPassWord(passWord);


            return 1;
        } else
            return 0;

    }

    public int editPhoneNum(String phoneNum) {
        boolean check = false;
        boolean check2 = false;
        for (BuyerModel buyer : buyers) {
            if (buyer.getPhoneNumber().equals(phoneNum)) {
                check = true;
            }
        }
        for (Request request : AdminController.getRequests()) {
            if (request instanceof UserModel) {
                if (((UserModel) request).getEmail().equals(email)) {
                    check2 = true;
                }
            }
        }
        Pattern pattern = Pattern.compile("^09[1-3]\\d{8}$");
        Matcher matcher = pattern.matcher(phoneNum);
        if (matcher.find() == true && check == false && check2 == false) {
            buyers.get(usersIndex).setPhoneNumber(phoneNum);
            return 1;
        } else
            return 0;

    }

    public String showAccountInfo() {
        return buyers.get(usersIndex).toString();
    }

    public int checkCardNumber(String cardNum) {
        Pattern pattern = Pattern.compile("^\\d{16}$");
        Matcher matcher = pattern.matcher(cardNum);
        if (matcher.find() == true) {
            this.cardNumber = cardNum;
            return 1;
        } else
            return 0;
    }

    public int checkCvv2(String cvv2) {
        Pattern pattern = Pattern.compile("^\\d{3}$");
        Matcher matcher = pattern.matcher(cvv2);
        if (matcher.find() == true) {
            this.cardCvv2 = cvv2;
            return 1;
        } else
            return 0;
    }

    public int checkAccountPassWord(String accountPassWord) {
        Pattern pattern = Pattern.compile("^\\d{5,}$");
        Matcher matcher = pattern.matcher(accountPassWord);
        if (matcher.find() == true) {
            this.passWord = accountPassWord;
            return 1;
        } else
            return 0;
    }

    public int checkBalanceIncrease(double balance) {
        if (balance > 0) {
            this.balanceIncrease1 = balance;
            return 1;
        } else
            return 0;
    }

    public void requestBalanceIncrease() {
        BalanceIncrease balanceIncrease = new BalanceIncrease(buyers.get(usersIndex), cardNumber, passWord, cardCvv2, balanceIncrease1);
        AdminController.getRequests().add(balanceIncrease);
    }

    public StringBuilder showCart() {
        if (userType == UserType.GUEST) {
            StringBuilder cartGoods = new StringBuilder();
            for (GoodsModel goods : guestCart) {
                cartGoods.append((guestCart.indexOf(goods) + 1) + ")\n" + goods.toString() + "\n");
            }
            cartGoods.append("1)buy\n2)remove goods\n3)add good\n4)back\n");

            return cartGoods;
        } else {
            StringBuilder cartGoods = new StringBuilder();
            for (GoodsModel goods : buyers.get(usersIndex).getCart()) {
                cartGoods.append((buyers.get(usersIndex).getCart().indexOf(goods) + 1) + ")\n" + goods.toString() + "\n");
            }
            cartGoods.append("1)buy\n2)remove goods\n3)add good\n4)back\n");

            return cartGoods;
        }
    }

    public void removeGoods(int index) {
        if (userType == UserType.GUEST) {
            guestCart.remove((index - 1));
        } else
            buyers.get(usersIndex).getCart().remove((index - 1));
    }

    public void addGoodsToCart(int number) {
        guestCart.clear();
        if (userType == UserType.GUEST) {
            GoodsModel goods = GoodsController.getGoodsList().get(GoodsController.getSelectedGoodsIndex());
            if (goods instanceof Car) {
                Car car = new Car(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Car) goods).getManufacturingCompany(), ((Car) goods).getCarEngineVolume(), ((Car) goods).isAutomaticCar());
               guestCart.add(car);
            }

            if (goods instanceof Bike) {
                Bike bike = new Bike(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Bike) goods).getManufacturingCompany(), ((Bike) goods).getBikeType());
                guestCart.add(bike);
            }
            if (goods instanceof Ssd) {
                Ssd ssd = new Ssd(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Ssd) goods).getWeight(), ((Ssd) goods).getDimensions(), ((Ssd) goods).getMemoryCapacity(), ((Ssd) goods).getReadingSpeed(), ((Ssd) goods).getWritingSpeed());
                guestCart.add(ssd);
            }
            if (goods instanceof FlashMemory) {
                FlashMemory flashMemory = new FlashMemory(goods.getGoodsName(), goods.getGoodsPrice(), number, ((FlashMemory) goods).getWeight(), ((FlashMemory) goods).getDimensions(), ((FlashMemory) goods).getMemoryCapacity(), ((FlashMemory) goods).getFlashMemoryType());
                guestCart.add(flashMemory);
            }
            if (goods instanceof Pc) {
                Pc pc = new Pc(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Pc) goods).getWeight(), ((Pc) goods).getDimensions(), ((Pc) goods).getCpuModel(), ((Pc) goods).getRamCapacity());
                guestCart.add(pc);
            }
            if (goods instanceof NoteBook) {
                NoteBook noteBook = new NoteBook(goods.getGoodsName(), goods.getGoodsPrice(), number, ((NoteBook) goods).getProducingCountry(), ((NoteBook) goods).getPageNum(), ((NoteBook) goods).getPaperType());
                guestCart.add(noteBook);
            }
            if (goods instanceof Pencil) {
                Pencil pencil = new Pencil(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Pencil) goods).getProducingCountry(), ((Pencil) goods).getPencilType());
                guestCart.add(pencil);
            }
            if (goods instanceof Pen) {
                Pen pen = new Pen(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Pen) goods).getProducingCountry(), ((Pen) goods).getPenColor());
                guestCart.add(pen);
            }
            if (goods instanceof Edible) {
                Edible edible = new Edible(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Edible) goods).getEdibleP(), ((Edible) goods).getEdibleExp());
                guestCart.add(edible);
            }
        } else {
            GoodsModel goods = GoodsController.getGoodsList().get(GoodsController.getSelectedGoodsIndex());
            if (goods instanceof Car) {
                Car car = new Car(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Car) goods).getManufacturingCompany(), ((Car) goods).getCarEngineVolume(), ((Car) goods).isAutomaticCar());
                buyers.get(usersIndex).getCart().add(car);
            }

            if (goods instanceof Bike) {
                Bike bike = new Bike(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Bike) goods).getManufacturingCompany(), ((Bike) goods).getBikeType());
                buyers.get(usersIndex).getCart().add(bike);
            }
            if (goods instanceof Ssd) {
                Ssd ssd = new Ssd(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Ssd) goods).getWeight(), ((Ssd) goods).getDimensions(), ((Ssd) goods).getMemoryCapacity(), ((Ssd) goods).getReadingSpeed(), ((Ssd) goods).getWritingSpeed());
                buyers.get(usersIndex).getCart().add(ssd);
            }
            if (goods instanceof FlashMemory) {
                FlashMemory flashMemory = new FlashMemory(goods.getGoodsName(), goods.getGoodsPrice(), number, ((FlashMemory) goods).getWeight(), ((FlashMemory) goods).getDimensions(), ((FlashMemory) goods).getMemoryCapacity(), ((FlashMemory) goods).getFlashMemoryType());
                buyers.get(usersIndex).getCart().add(flashMemory);
            }
            if (goods instanceof Pc) {
                Pc pc = new Pc(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Pc) goods).getWeight(), ((Pc) goods).getDimensions(), ((Pc) goods).getCpuModel(), ((Pc) goods).getRamCapacity());
                buyers.get(usersIndex).getCart().add(pc);
            }
            if (goods instanceof NoteBook) {
                NoteBook noteBook = new NoteBook(goods.getGoodsName(), goods.getGoodsPrice(), number, ((NoteBook) goods).getProducingCountry(), ((NoteBook) goods).getPageNum(), ((NoteBook) goods).getPaperType());
                buyers.get(usersIndex).getCart().add(noteBook);
            }
            if (goods instanceof Pencil) {
                Pencil pencil = new Pencil(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Pencil) goods).getProducingCountry(), ((Pencil) goods).getPencilType());
                buyers.get(usersIndex).getCart().add(pencil);
            }
            if (goods instanceof Pen) {
                Pen pen = new Pen(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Pen) goods).getProducingCountry(), ((Pen) goods).getPenColor());
                buyers.get(usersIndex).getCart().add(pen);
            }
            if (goods instanceof Edible) {
                Edible edible = new Edible(goods.getGoodsName(), goods.getGoodsPrice(), number, ((Edible) goods).getEdibleP(), ((Edible) goods).getEdibleExp());
                buyers.get(usersIndex).getCart().add(edible);
            }

        }
    }

    public String showPurchaseInvoice() {
        StringBuilder allPurchaseInvoice = new StringBuilder();
        for (PurchaseInvoiceModel purchaseInvoice : buyers.get(usersIndex).getPurchaseHistory()) {
            allPurchaseInvoice.append(purchaseInvoice.toString());

        }
        return allPurchaseInvoice.toString();
    }

    public String buyGoods() {
        if (userType == UserType.GUEST) {
            return "sorry you havent account ! if you wanna creat an account enter \"5\"";
        }
        double totalPrice = 0;
        for (GoodsModel goods : buyers.get(usersIndex).getCart()) {
            for (GoodsModel goods1 : GoodsController.getGoodsList()) {
                if (goods.getGoodsId() == goods1.getGoodsId()) {
                    if (goods.getGoodsInventory() > goods1.getGoodsInventory()) {
                        return goods.getGoodsName() + " is not available  enough in the shop !";
                    }
                }
            }
        }
        for (GoodsModel goods : buyers.get(usersIndex).getCart()) {
            totalPrice = totalPrice + (goods.getGoodsPrice() * goods.getGoodsInventory());
        }
        if (totalPrice > buyers.get(usersIndex).getUserAccountBalance()) {
            return "your Account Balance is insufficient !";
        } else {

            backUpCart.clear();
            for (GoodsModel goods : buyers.get(usersIndex).getCart()) {
                backUpCart.add(goods);
            }
            for (GoodsModel goods : backUpCart) {
                for (GoodsModel goods1 : GoodsController.getGoodsList()) {
                    if (goods.getGoodsId() == goods1.getGoodsId()) {
                        goods1.setGoodsInventory((goods1.getGoodsInventory() - goods.getGoodsInventory()));
                    }
                }
            }
            buyers.get(usersIndex).setUserAccountBalance(buyers.get(usersIndex).getUserAccountBalance() - totalPrice);
            PurchaseInvoiceModel purchaseInvoice = new PurchaseInvoiceModel("1402/18/1", totalPrice, backUpCart);
            buyers.get(usersIndex).getPurchaseHistory().add(purchaseInvoice);
            buyers.get(usersIndex).getCart().clear();
            return "your Purchase was successful !";
        }
    }
}

