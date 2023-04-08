package model.user;

public class AdminModel extends UserModel {
   private AdminModel(String userName,String passWord){
      super(userName,passWord);
   }
   private static AdminModel admin=new AdminModel("admin","admin");
   public static AdminModel getAdmin(){
      return admin;
   }




}
