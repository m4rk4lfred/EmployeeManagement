package EmployeeManagementSystem;

public class delay extends Thread{
    String message;
    public delay(String message){
        this.message = message;
     }

     public void run(){
        try {
            for(char msg: message.toCharArray()){
           
            Thread.sleep(100);
            System.out.print(msg);
            }
        } catch (InterruptedException e) {
            
        }
     }
}
