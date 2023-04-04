package model.request;

 abstract public class Request {
    public Request() {
        requestId++;
    }
    private static int requestId;

     public static int getRequestId() {
         return requestId;
     }
 }
