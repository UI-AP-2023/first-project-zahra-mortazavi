package model;

public abstract class UserModel {
   UserModel(String userName,String passWord,String email,String phoneNumber){
      this.userName=userName;
      this.email=email;
      this.passWord=passWord;
      this.phoneNumber=phoneNumber;
   }
UserModel(String userName,String passWord)
{this(userName,passWord,null,null);}
  final private String userName;
  private String passWord;
  private String email;
   private String phoneNumber;
   String getUserName(){
       return userName;
   }
   String getPassWord(){
       return passWord;
   }
   String getPhoneNumber(){
       return phoneNumber;
   }
   String getEmail(){
       return email;
   }
   void setPhoneNumber(){
       this.phoneNumber=phoneNumber;
    }
    void setPassWord(){
       this.passWord=passWord;
    }
    void setEmail(){
       this.email=email;
    }
    

}
