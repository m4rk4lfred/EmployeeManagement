package EmployeeManagementSystem;

import java.io.Console;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Mainmenu {
   
    Scanner scan = new Scanner(System.in);
    int userChoice;
    public static String AnsiRed = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private static int counterEmployee ;
    public static int welcome = 0;
   
    
    Mainmenu() {
        counterEmployee = getCounter();
    }
    public void StartMainMenu(){
        clearScreen();
        displayMenu();
        functionalityhomeMenu();
    }
    private void displayMenu(){
        if(welcome == 0){
        delay delay = new delay("WELCOME TO THE EMPLOYEE MANAGEMENT SYSTEM");;
        delay.start();
        try {
            delay.join();
        } catch (InterruptedException e) {
            System.err.println(AnsiRed+"Thread interrupted"+ANSI_RESET);
        }
        welcome++;
    }
        center("\n\nEMPLOYEE MANAGEMENT SYSTEM");
        System.out.println(ANSI_YELLOW+"1. Employee Management");
        System.out.println("2. Department Management");
        System.out.println("3. Attendance Management");
        System.out.println("4. Exit"+ANSI_RESET);
        
        
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
    
    public String center(String text){
          int terminalLength = 130;
          int padding = (terminalLength - text.length())/2;
          
          String applyPadding = " ".repeat(Math.max(0, padding));
          System.out.println(applyPadding +AnsiRed +text + ANSI_RESET);
          return applyPadding + text;
    }

}
