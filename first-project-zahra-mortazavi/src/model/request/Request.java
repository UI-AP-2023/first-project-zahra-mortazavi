package model.request;

 abstract public class Request {
    public Request() {
        mainRequestId++;
        this.requestId=mainRequestId;
    }
    private  int requestId;
     private static int mainRequestId=0;

     public static int getMainRequestId() {
         return mainRequestId;
     }

     public  int getRequestId() {
         return requestId;
     }
 }
