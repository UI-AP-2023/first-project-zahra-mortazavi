package model.user;

public abstract class UserModel {
   protected UserModel(String userName,String passWord,String email,String phoneNumber){
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
   public String getUserName(){
       return userName;
   }
   public String getPassWord(){
       return passWord;
   }
   public String getPhoneNumber(){
       return phoneNumber;
   }
   public String getEmail(){
       return email;
   }
   public void setPhoneNumber(){
       this.phoneNumber=phoneNumber;
    }
    public void setPassWord(){
       this.passWord=passWord;
    }
    public void setEmail(){
       this.email=email;
    }

    @Override
    public String toString() {
        return
                "\nuserName='" + userName + '\'' +
                "\npassWord='" + passWord + '\'' +
                "\nemail='" + email + '\'' +
                "\nphoneNumber='" + phoneNumber + '\''
                ;
    }
}
