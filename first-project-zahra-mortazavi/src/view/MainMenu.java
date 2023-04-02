package view;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

import java.util.Scanner;

public class MainMenu {

   RegisterView registerView=new RegisterView();
    Scanner s=new Scanner(System.in);
public String mainMenu(){
    return "\n1)register\n2)log in\n3)goods";
}
int num=s.nextInt();
if(num==1){
    registerView.register();
    }
}
