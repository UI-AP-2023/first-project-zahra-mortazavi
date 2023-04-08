package controller.goodscontroller;

import controller.admincontroller.AdminController;
import controller.buyercontroller.BuyerController;
import model.goods.CommentModel;
import model.goods.GoodsCategoryModel;
import model.goods.GoodsModel;
import model.goods.ScoreModel;
import model.goods.digitalgoods.CpuModel;
import model.goods.digitalgoods.FlashMemory;
import model.goods.digitalgoods.FlashMemoryType;
import model.goods.digitalgoods.Pc;
import model.goods.stationery.Pencil;
import model.goods.stationery.PencilType;
import model.goods.vehicles.Bike;
import model.goods.vehicles.BikeType;
import model.goods.vehicles.Car;
import model.user.buyer.PurchaseInvoiceModel;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoodsController {
    private GoodsController() {
        this.filteredGoods = new ArrayList<GoodsModel>();
        this.goodsList = new ArrayList<GoodsModel>();
        this.backUpFilteredGoods = new ArrayList<GoodsModel>();
    }

    private ArrayList<GoodsModel> filteredGoods;
    private ArrayList<GoodsModel> backUpFilteredGoods;
    private static ArrayList<GoodsModel> goodsList;
    private static GoodsController goodsController = new GoodsController();

    public static GoodsController getGoodsController() {
        return goodsController;
    }

    private static int selectedGoodsId;
    private static int selectedGoodsIndex;

    public static int getSelectedGoodsIndex() {
        return selectedGoodsIndex;
    }

    public static ArrayList<GoodsModel> getGoodsList() {
        return goodsList;
    }

    public static int getSelectedGoodsId() {
        return selectedGoodsId;
    }

    public String showAllGoods() {
        StringBuilder goodsString = new StringBuilder();
        for (GoodsModel goods : goodsList) {
            goodsString.append("\n" + (goodsList.indexOf(goods) + 1) + ")" +
                    "\nname : " + goods.getGoodsName() +
                    "\ngoods id : " + goods.getGoodsId() +
                    "\ncategory : " + goods.getGoodsCategoryModel().getCategory() +
                    "\nprice : " + goods.getGoodsPrice() + "\n**********************");
        }
        return goodsString.toString();
    }

    public void findSelectedGoods(int index) {
        boolean check = false;
        selectedGoodsIndex = index - 1;
        selectedGoodsId = goodsList.get(selectedGoodsIndex).getGoodsId();
    }

    public String showSelectedGoods() {
        boolean check = false;
        if (BuyerController.getBuyerController().getUserType() == BuyerController.UserType.GUEST) {
            return "\n" + goodsList.get(selectedGoodsIndex).toString() + "\n1)add to cart\n2)show comments\n0)back";
        }
        for (PurchaseInvoiceModel purchaseInvoice : BuyerController.getBuyers().get(BuyerController.getUsersIndex()).getPurchaseHistory()) {
            for (GoodsModel goods : purchaseInvoice.getPurchaseGoods()) {
                if (goods.getGoodsId() == selectedGoodsId) {
                    check = true;
                }
            }
        }
        if (check == true)
            return "\n" + goodsList.get(selectedGoodsIndex).toString() + "\n1)add to cart\n2)show comments\n3)add new comment\n4)score\n0)back";
        else
            return "\n" + goodsList.get(selectedGoodsIndex).toString() + "\n1)add to cart\n2)show comments\n3)add new comment\n0)back";
    }

    public StringBuilder showSelectedGoodsComments() {
        StringBuilder allComments = new StringBuilder();
        for (CommentModel comment : goodsList.get(selectedGoodsIndex).getComment()) {
            allComments.append("\nuser " + comment.getBuyerModel().getUserName() + ":\n" + comment.getCommentText());
        }
        return allComments;
    }

    public int addScore(String score) {
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        Pattern pattern = Pattern.compile("^[0-5]$");
        Matcher matcher = pattern.matcher(score);
        if (matcher.find() == true) {
            check1 = true;
        }
        for (PurchaseInvoiceModel purchaseInvoice : BuyerController.getBuyers().get(BuyerController.getUsersIndex()).getPurchaseHistory()) {
            for (GoodsModel goods : purchaseInvoice.getPurchaseGoods()) {
                if (goods.getGoodsId() == selectedGoodsId) {
                    check2 = true;
                }
            }
        }

        if (check1 == true && check2 == true) {
            for (ScoreModel score2 : goodsList.get(selectedGoodsIndex).getScores()) {
                if (score2.getBuyer().equals(BuyerController.getBuyers().get(BuyerController.getUsersIndex()))) {
                    goodsList.get(selectedGoodsIndex).getScores().remove(score2);
                    ScoreModel score1 = new ScoreModel(BuyerController.getBuyers().get(BuyerController.getUsersIndex()), goodsList.get(selectedGoodsIndex), score);
                    goodsList.get(selectedGoodsIndex).getScores().add(score1);
                    calculateScore();
                    return 1;

                }
            }
            ScoreModel score1 = new ScoreModel(BuyerController.getBuyers().get(BuyerController.getUsersIndex()), goodsList.get(selectedGoodsIndex), score);
            goodsList.get(selectedGoodsIndex).getScores().add(score1);
            check3 = true;
            calculateScore();
            return 1;
        } else
            return 0;
    }

    private double sum = 0;

    public void calculateScore() {
        for (ScoreModel score2 : goodsList.get(selectedGoodsIndex).getScores()) {
            sum += Double.parseDouble(score2.getScore());
        }
        goodsList.get(selectedGoodsIndex).setGoodsScore(sum / (goodsList.get(selectedGoodsIndex).getScores().size()));

    }

    public void commentRequest(String commentText) {
        boolean check2 = false;
        for (PurchaseInvoiceModel purchaseInvoice : BuyerController.getBuyers().get(BuyerController.getUsersIndex()).getPurchaseHistory()) {
            for (GoodsModel goods : purchaseInvoice.getPurchaseGoods()) {
                if (goods.getGoodsId() == selectedGoodsId) {
                    check2 = true;
                }
            }
        }
        CommentModel comment = new CommentModel(BuyerController.getBuyers().get(BuyerController.getUsersIndex()), selectedGoodsId, check2, commentText);
        AdminController.getRequests().add(comment);

    }

    public String search(String searchedWord) {
        filteredGoods.clear();
        for (GoodsModel goods : goodsList) {
            if (goods.getGoodsName().contains(searchedWord)) {
                filteredGoods.add(goods);
            }
        }
        return makeFiltersString(filteredGoods);
    }

    public String filterCategory(int num) {
        filteredGoods.clear();
        if (num == 1) {
            for (GoodsModel goods : goodsList) {
                if (goods.getGoodsCategoryModel().equals(GoodsCategoryModel.DIGITALGOODS)) {
                    filteredGoods.add(goods);
                }
            }
        }
        if (num == 2) {
            for (GoodsModel goods : goodsList) {
                if (goods.getGoodsCategoryModel().equals(GoodsCategoryModel.STATIONERY)) {
                    filteredGoods.add(goods);
                }
            }
        }
        if (num == 3) {
            for (GoodsModel goods : goodsList) {
                if (goods.getGoodsCategoryModel().equals(GoodsCategoryModel.VEHICLES)) {
                    filteredGoods.add(goods);
                }
            }
        }
        if (num == 4) {
            for (GoodsModel goods : goodsList) {
                if (goods.getGoodsCategoryModel().equals(GoodsCategoryModel.EDIBLE)) {
                    filteredGoods.add(goods);
                }
            }
        }
        return makeFiltersString(filteredGoods);
    }

    public String filterStationary(int num) {
        makeBackUPlist();
        filteredGoods.clear();
        if (num == 1) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods.getGoodsName().contains("pen")) {
                    filteredGoods.add(goods);
                }
            }
        }
        if (num == 2) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods.getGoodsName().contains("pencil")) {
                    filteredGoods.add(goods);
                }
            }
        }
        if (num == 3) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods.getGoodsName().contains("note book")) {
                    filteredGoods.add(goods);
                }
            }
        }
        return makeFiltersString(filteredGoods);
    }

    public String filterDigitalGoods(int num) {
        makeBackUPlist();
        filteredGoods.clear();
        if (num == 1) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods.getGoodsName().contains("PC")) {
                    filteredGoods.add(goods);
                }
            }
        }
        if (num == 2) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods.getGoodsName().contains("SSD")) {
                    filteredGoods.add(goods);
                }
            }
        }
        if (num == 3) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods.getGoodsName().contains("flash")) {
                    filteredGoods.add(goods);
                }
            }
        }
        return makeFiltersString(filteredGoods);
    }

    public String filterVehicle(int num) {
        makeBackUPlist();
        filteredGoods.clear();
        if (num == 1) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods.getGoodsName().contains("car")) {
                    filteredGoods.add(goods);
                }
            }
        }
        if (num == 2) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods.getGoodsName().contains("bike")) {
                    filteredGoods.add(goods);
                }
            }
        }


        return makeFiltersString(filteredGoods);
    }

    public String filterBikes(int num) {
        backUpFilteredGoods.clear();
        makeBackUPlist();
        filteredGoods.clear();
        if (num == 1) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Bike) {
                    if (((Bike) goods).getBikeType() == BikeType.CITYBIKE) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 2) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Bike) {
                    if (((Bike) goods).getBikeType() == BikeType.MOUNNTAINBIKE) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 3) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Bike) {
                    if (((Bike) goods).getBikeType() == BikeType.HYBRIDEBIKE) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 4) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Bike) {
                    if (((Bike) goods).getBikeType() == BikeType.ROADBIKE) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        return makeFiltersString(filteredGoods);
    }

    public String filterCar(int num) {
        backUpFilteredGoods.clear();
        makeBackUPlist();
        filteredGoods.clear();
        if (num == 1) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Car) {
                    if (((Car) goods).isAutomaticCar() == true) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 2) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Car) {
                    if (((Car) goods).isAutomaticCar() == false) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        return makeFiltersString(filteredGoods);

    }

    public String filterPencil(int num) {
        backUpFilteredGoods.clear();
        makeBackUPlist();
        filteredGoods.clear();
        if (num == 1) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Pencil) {
                    if (((Pencil) goods).getPencilType() == PencilType.B) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 2) {
            for (GoodsModel goods : backUpFilteredGoods) {

                if (goods instanceof Pencil) {
                    if (((Pencil) goods).getPencilType() == PencilType.H2) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 3) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Pencil) {
                    if (((Pencil) goods).getPencilType() == PencilType.F) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 4) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Pencil) {
                    if (((Pencil) goods).getPencilType() == PencilType.HB) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 5) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Pencil) {
                    if (((Pencil) goods).getPencilType() == PencilType.H) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        return makeFiltersString(filteredGoods);
    }

    public String filterPc(int num) {
        backUpFilteredGoods.clear();
        makeBackUPlist();
        filteredGoods.clear();
        if (num == 1) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Pc) {
                    if (((Pc) goods).getCpuModel() == CpuModel.SINGLECORE) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 2) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Pc) {
                    if (((Pc) goods).getCpuModel() == CpuModel.DUALCORECPU) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 3) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Pc) {
                    if (((Pc) goods).getCpuModel() == CpuModel.QUADCORECPU) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 4) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Pc) {
                    if (((Pc) goods).getCpuModel() == CpuModel.HEXACOREPROCESSORS) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 5) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Pc) {
                    if (((Pc) goods).getCpuModel() == CpuModel.OCTACOREPROCESSORS) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 6) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof Pc) {
                    if (((Pc) goods).getCpuModel() == CpuModel.DECACOREPROCESSORS) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        return makeFiltersString(filteredGoods);
    }

    public String filterFlash(int num) {
        backUpFilteredGoods.clear();
        makeBackUPlist();
        filteredGoods.clear();
        if (num == 1) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof FlashMemory) {
                    if (((FlashMemory) goods).getFlashMemoryType() == FlashMemoryType.USBA) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 2) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof FlashMemory) {
                    if (((FlashMemory) goods).getFlashMemoryType() == FlashMemoryType.USBB) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 3) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof FlashMemory) {
                    if (((FlashMemory) goods).getFlashMemoryType() == FlashMemoryType.USBC) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 4) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof FlashMemory) {
                    if (((FlashMemory) goods).getFlashMemoryType() == FlashMemoryType.MINIUSB) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        if (num == 5) {
            for (GoodsModel goods : backUpFilteredGoods) {
                if (goods instanceof FlashMemory) {
                    if (((FlashMemory) goods).getFlashMemoryType() == FlashMemoryType.MICROUSB) {
                        filteredGoods.add(goods);
                    }

                }
            }
        }
        return makeFiltersString(filteredGoods);
    }

    public String filterByInventory() {
        filteredGoods.clear();
        for (GoodsModel goods : goodsList) {
            if (goods.getGoodsInventory() > 0) {
                filteredGoods.add(goods);
            }
        }
        return makeFiltersString(filteredGoods);
    }

    public String filterByPrice(double price1, double price2) {
        filteredGoods.clear();
        for (GoodsModel goods : goodsList) {
            if ((goods.getGoodsPrice() >= price1) && (goods.getGoodsPrice() <= price2)) {
                filteredGoods.add(goods);
            }
        }
        return makeFiltersString(filteredGoods);
    }

    public String filterByScore(double score1, double score2) {
        filteredGoods.clear();
        for (GoodsModel goods : goodsList) {
            if ((goods.getGoodsScore() >= score1) && (goods.getGoodsScore() <= score2)) {
                filteredGoods.add(goods);
            }
        }
        return makeFiltersString(filteredGoods);
    }

    public String makeFiltersString(ArrayList<GoodsModel> filteredGoods) {
        StringBuilder filteredGoodsString = new StringBuilder();
        for (GoodsModel goods : filteredGoods) {
            int num=(filteredGoods.indexOf(goods) + 1);
            filteredGoodsString.append(" \n"+num + ")" + "\nname : " + goods.getGoodsName() +
                    "\ngoods id : " + goods.getGoodsId() +
                    "\ncategory : " + goods.getGoodsCategoryModel().getCategory() +
                    "\nprice : " + goods.getGoodsPrice() + "\n**********************");
        }
        ;

        return filteredGoodsString.toString();
    }

    public void makeBackUPlist() {
        for (GoodsModel goods : filteredGoods) {
            backUpFilteredGoods.add(goods);
        }
    }

    public void findFilterGoodsIndex(int index) {
        for (GoodsModel goods : goodsList) {
            if (filteredGoods.get(index - 1).getGoodsId() == goods.getGoodsId()) {
                selectedGoodsIndex = goodsList.indexOf(goods);
                selectedGoodsId = filteredGoods.get(index - 1).getGoodsId();
            }
        }
    }

    public int addPurchaseInvoiceGoodsScore(int purchaseInvoiceId, int index, String score) {
        for (PurchaseInvoiceModel purchaseInvoice : BuyerController.getBuyers().get(BuyerController.getUsersIndex()).getPurchaseHistory()) {
            if (purchaseInvoice.getInvoiceId() == purchaseInvoiceId) {
                selectedGoodsId = purchaseInvoice.getPurchaseGoods().get(index - 1).getGoodsId();
            }
        }
        for (GoodsModel goods : goodsList) {
            if (goods.getGoodsId() == selectedGoodsId) {
                selectedGoodsIndex = goodsList.indexOf(goods);
            }
        }
        return addScore(score);
    }


}


