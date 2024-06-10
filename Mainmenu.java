package EmployeeManagementSystem;

import java.io.Console;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Mainmenu {
   
    Scanner scan = new Scanner(System.in);
    int userChoice;
    private static int counterEmployee ;
   
    
    Mainmenu() {
        counterEmployee = getCounter();
    }
    public void StartMainMenu(){
        clearScreen();
        displayMenu();
        functionalityhomeMenu();
    }
    private void displayMenu(){
        
        System.out.println("Main Menu\n");
        System.out.println("1. Employee Management");
        System.out.println("2. Department Management");
        System.out.println("3. Attendance Management");
        System.out.println("4. Exit");
        
        
    }

    private void functionalityhomeMenu(){
        try{
        System.out.println("Enter your choice: ");
        userChoice = scan.nextInt();
        switch(userChoice){
            case 1:
                //clearScreen();
                Employeemanagement employeeManagement = new Employeemanagement(scan);
                employeeManagement.displayEmployeeMenu();

                break;
            case 2:
                department departmentManagement = department.getDeparManegement();
                departmentManagement.showDepartmentMenu();
                break;
            case 3:
                Attendancetracking Attendancetracking = new Attendancetracking(scan);
                Attendancetracking.showAttendanceMenu();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
    catch(InputMismatchException e){
        errorHandle();
    }
    }
    public interface employeeManagement {
      public void AddEmployee();
      public void ShowEmployee();
      public void removeEmployee();
      public void listAllEmployee();
        
    }

    public interface departmentManegement{
        public void addDepartment();
        public void assignEmplyoeeToDepartment();
        public void removeEmployeeFromDepartment();
        public void listDepartment();
    }

    public interface attendanceTracking{
        public void markAttendance();
        public void showAttendanceByData();
        public void viewAttendanceByEmployee();
    }
    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static void setCounter(int count){
        counterEmployee = count;
    }

    public static int getCounter(){
        return counterEmployee;
    }
    
   /*  public void waitForAnyKey() {
    System.out.println("Press any key to continue...");
    try {
        new ProcessBuilder("cmd", "/c", "pause >nul").inheritIO().start().waitFor();
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
}*/
   
    public void waitForAnyKey() {
    System.out.println("Press enter to back...");
    Console console = System.console();
    if(console != null){
        console.readLine();
    }
    else{
       System.err.println("Console not available");

    }

    }

    public int getCounterEmployee(){
        return counterEmployee;
    }
    public void errorHandle(){
       
        JOptionPane.showMessageDialog(null, "Error : Enter integer from 1 to 4", "Invalid input", JOptionPane.ERROR_MESSAGE);
        StartMainMenu();
    }


}
