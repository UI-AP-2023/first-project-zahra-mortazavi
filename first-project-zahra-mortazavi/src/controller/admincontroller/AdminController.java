package controller.admincontroller;

import controller.buyercontroller.BuyerController;
import controller.goodscontroller.GoodsController;
import model.goods.CommentModel;
import model.goods.CommentStatusModel;
import model.goods.GoodsModel;
import model.goods.digitalgoods.*;
import model.goods.edible.Edible;
import model.goods.stationery.*;
import model.goods.vehicles.Bike;
import model.goods.vehicles.BikeType;
import model.goods.vehicles.Car;
import model.request.Request;
import model.user.UserModel;
import model.user.buyer.BalanceIncrease;
import model.user.buyer.BuyerModel;

import java.sql.Array;
import java.util.ArrayList;

public class AdminController {
    private AdminController() {
        requests=new ArrayList<Request>();
    }
    private static AdminController adminController=new AdminController();
    public static AdminController getAdminController() {
        return adminController;
    }

    public static ArrayList<Request> getRequests() {
        return requests;
    }

    public static void setRequests(ArrayList<Request> requests) {
        AdminController.requests = requests;
    }

    private static ArrayList<Request> requests;
    public String help(){
        return"\nadd car:\nadd goodsName goodsPrice goodsInventory manufacturingCompany carEngineVolume automaticCar\n" +
                "add bike:\nadd goodsName goodsPrice goodsInventory manufacturingCompany bikeType\n" +
                "bikeType:(MOUNNTAINBIKE,CITYBIKE,HYBRIDEBIKE,ROADBIKE)\n" +
                "add notebook:\nadd goodsName goodsPrice goodsInventory producingCountry.pageNum.paperType\n" +
                "paperType :(FIBERGLASS,PLAINPAPAER,OILPAPER,STRAWPAPER)\n" +
                "add pen:\nadd goodsName goodsPrice goodsInventory producingCountry penColor\n" +
                "add pencil:\nadd goodsName goodsPrice goodsInventory producingCountry pencilType\n" +
                "pencilType :(H2,H,HB,F,B)\n" +
                "add edible:\nadd goodsName goodsPrice goodsInventory edibleP edibleExp\n" +
                "add ssd:\nadd goodsName goodsPrice goodsInventory weight dimensions memoryCapacity readingSpeed writingSpeed)\n" +
                "add pc:\nadd goodsName goodsPrice goodsInventory weight dimensions cpuModel ramCapacity\n" +
                "cpuModel:SINGLECORE,DUALCORECPU,QUADCORECPU,HEXACOREPROCESSORS,OCTACOREPROCESSORS,DECACOREPROCESSORS)\n" +
                "add flash:\nadd goodsName goodsPrice goodsInventory weight dimensions memoryCapacity flashMemoryType\n" +
                "flashMemoryType:(USBA,USBB,MICROUSB,MINIUSB,USBC)\n" +
                "show goods:\nshowgoods\n" +
                "edit name:\nedit goodsID NAME newgoodsname\n" +
                "edit price:\nedit goodsID PRICE newgoodsprice\n" +
                "edit inventory:\nedit goodsID INVENTORY newgoodsinventory\n" +
                "delete:\ndelete goodsID(you can add more than one ID)\n" +
                "show request:\nshowreq\n" +
                "accept request:\nreq accept requestID(you can add more than one ID)\n" +
                "reject request:\nreq reject requestID(you can add more than one ID)\n" +
                "exit";}
    public String findOrder(String orders){
        String order[]=orders.split(" ");
        if (order[0].equals("add")){
           if (addGoods(order)==0)
               return "invalid order!";
           else
            return "done!";
        }
         if (order[0].equals("showgoods")){

             return showGoodsToAdmin();

        }
         if (order[0].equals("edit")){
             if (editGoods(order)==0)
                 return "invalid order!";
             else
                 return "done!";


        }
         if (order[0].equals("delete")){
             if (deleteGoods( order)==0)
                 return "invalid order!";
             else
                 return "done!";



        }
         if (order[0].equals("req")){
             if (findRequestType(order)==0)
                 return "invalid order!";
             else
                 return "done!";



        }
        if (order[0].equals("showreq")){

            return showRequest();
        }
        if (order[0].equals("help")){

            return  help();
        }
        else
            return "invalid order!";
    }
public int addGoods( String order[]){
        if (order[1].contains("car")){
            Car newCar=new Car(order[1],Double.parseDouble(order[2]),Integer.parseInt(order[3]),order[4],Integer.parseInt(order[5]),Boolean.parseBoolean(order[6]));
            GoodsController.getGoodsController().getGoodsList().add(newCar);
            return 1;
        }
    if (order[1].contains("bike")){
        Bike bike=new Bike(order[1],Double.parseDouble(order[2]),Integer.parseInt(order[3]),order[4],BikeType.valueOf(order[5]));
        GoodsController.getGoodsController().getGoodsList().add(bike);
        return 1;
    }
    if (order[1].contains("pen")){
        Pen pen=new Pen(order[1],Double.parseDouble(order[2]),Integer.parseInt(order[3]),order[4],order[5]) ;
        GoodsController.getGoodsController().getGoodsList().add(pen);
        return 1;
    }
    if (order[1].contains("pencil")){
        Pencil pencil=new Pencil(order[1],Double.parseDouble(order[2]),Integer.parseInt(order[3]),order[4], PencilType.valueOf(order[5])) ;
        GoodsController.getGoodsController().getGoodsList().add(pencil);
        return 1;
    }
    if (order[1].contains("ssd")){
        Ssd ssd=new Ssd(order[1],Double.parseDouble(order[2]),Integer.parseInt(order[3]),Double.parseDouble(order[4]),order[5],Integer.parseInt(order[6]),Double.parseDouble(order[7]),Double.parseDouble(order[8]));
        GoodsController.getGoodsController().getGoodsList().add(ssd);
        return 1;
    }
    if (order[1].contains("pc")){
        Pc pc=new Pc(order[1],Double.parseDouble(order[2]),Integer.parseInt(order[3]),Double.parseDouble(order[4]),order[5], CpuModel.valueOf(order[6]),Integer.parseInt(order[7]));
        GoodsController.getGoodsController().getGoodsList().add(pc);
        return 1;
    }
    if (order[1].contains("flash")){
        FlashMemory flashMemory=new FlashMemory(order[1],Double.parseDouble(order[2]),Integer.parseInt(order[3]),Double.parseDouble(order[4]),order[5],Integer.parseInt(order[6]), FlashMemoryType.valueOf(order[7]));
        GoodsController.getGoodsController().getGoodsList().add(flashMemory);
        return 1;
    }
    if (order[1].contains("notebook")){
        NoteBook noteBook=new NoteBook(order[1],Double.parseDouble(order[2]),Integer.parseInt(order[3]),order[4],Integer.parseInt(order[5]), PaperType.valueOf(order[6]));
        GoodsController.getGoodsController().getGoodsList().add(noteBook);
        return 1;
    }
    if (order[1].contains("edible")){
        Edible edible=new Edible(order[1],Double.parseDouble(order[2]),Integer.parseInt(order[3]),order[4],order[5]);
        GoodsController.getGoodsController().getGoodsList().add(edible);
        return 1;
    }
    else
        return 0;
}
String showGoodsToAdmin(){
    StringBuilder allGoods=new StringBuilder();
        for (GoodsModel goods:GoodsController.getGoodsController().getGoodsList()){
            allGoods.append(GoodsController.getGoodsController().getGoodsList().indexOf(goods)+")\n"+goods.toString());

        }
    return allGoods.toString();
}
private int index;
public int editGoods(String order[]){
        boolean check=false;
    for (GoodsModel goods:GoodsController.getGoodsController().getGoodsList()){
        if (goods.getGoodsId()==Integer.parseInt(order[1])){
            index=GoodsController.getGoodsController().getGoodsList().indexOf(goods);
        check=true;}
        if (check==true){
        if (order[2].equals("NAME")){
            GoodsController.getGoodsController().getGoodsList().get(index).setGoodsName(order[3]);
            return 1;
        }
            if (order[2].equals("PRICE")){
                GoodsController.getGoodsController().getGoodsList().get(index).setGoodsPrice(Double.parseDouble(order[3]));
                return 1;
            }
            if (order[2].equals("INVENTORY")){
                GoodsController.getGoodsController().getGoodsList().get(index).setGoodsInventory(Integer.parseInt(order[3]));
                return 1;
            }
            else
                return 0;
        }
        else
            return 0;
    }
    return 2;
}
private int counter;
    public int deleteGoods(String order[]){
        counter=0;
        for (int i = 1; i < order.length; i++) {
int index2=0;
        for (GoodsModel goods:GoodsController.getGoodsController().getGoodsList()){
            if (goods.getGoodsId()==Integer.parseInt(order[i])){
                index2=GoodsController.getGoodsController().getGoodsList().indexOf(goods);
               counter++;
            }}
            GoodsController.getGoodsController().getGoodsList().remove(index2);
        }
            if (counter==(order.length-1)){
                return 1;
            }
else
    return 0;
}
public String showRequest(){
    StringBuilder allRequests=new StringBuilder();
    for (Request request:requests){
        allRequests.append((requests.indexOf(request)+1)+")\nrequestID : "+request.getRequestId()+"\n");
        if (request instanceof UserModel){
            allRequests.append("sing up request :"+((UserModel) request).toString());}
            if (request instanceof CommentModel){
                allRequests.append("comment request :"+((CommentModel) request).toString());
        }
        if (request instanceof BalanceIncrease){
            allRequests.append(((BalanceIncrease) request).toString());
        }
    }
    return allRequests.toString();
}
public int findRequestType(String order[]){
        if (order[1].equals("accept")){
            acceptRequest( order);
            return 1;
        }
    if (order[1].equals("reject")){
rejectRequest(order);
        return 1;
    }
    else
        return 0;
}
private int counter2;
public int acceptRequest(String order[]){
    counter2=0;
    int index1=0;
    for (int i = 2; i <order.length ; i++) {
        for (Request request:requests){
            if (request.getRequestId()==Integer.parseInt(order[i])){
                counter2++;
                index1=requests.indexOf(request);
                if (request instanceof UserModel){
                    BuyerController.getBuyers().add(((BuyerModel) request));
                 
                }
              if (request instanceof  CommentModel){
                  for (GoodsModel goods:GoodsController.getGoodsController().getGoodsList()){
                      if (goods.getGoodsId()==((CommentModel) request).getGoodsId()){
                          goods.getComment().add(((CommentModel)request));
                          ((CommentModel) request).setCommentStatus(CommentStatusModel.ACCEPTED);

                      }
                  }
              }
              if (request instanceof  BalanceIncrease){
                  for (BuyerModel buyer: BuyerController.getBuyers()){
                      if (buyer==((BalanceIncrease) request).getBuyer()){
                          buyer.setUserAccountBalance(buyer.getUserAccountBalance()+((BalanceIncrease) request).getBalanceIncrease());

                      }
                  }
              }

                }

            }

requests.remove(index1);


    }
    if (counter2==order.length-2){
        return 1;
    }
    else
        return 0;
}
int counter3;
public int rejectRequest(String order[]){
    counter3=0;
    int index2=0;
    for (int i = 2; i < order.length; i++) {
        for (Request request:requests){
            if (request.getRequestId()==Integer.parseInt(order[i])){
                index2=requests.indexOf(request);
                counter3++;
            }
        }
        requests.remove(index2);
    }

    if (counter3==order.length-2){
        return 1;
    }
    else
        return 0;
}
}