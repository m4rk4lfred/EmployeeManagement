package EmployeeManagementSystem;

import java.util.Scanner;

import javax.swing.JOptionPane;

import EmployeeManagementSystem.Mainmenu.employeeManagement;

public class Employeemanagement extends Mainmenu implements employeeManagement{
    Scanner scan;
   
    static String[] employeeNames = new String[100];
    static String[] employeeAddress = new String[100];
    static String[] employeePhoneNumber = new String[100];
    static String[] employeePosition = new String[100];
    static String[] employeeSalary = new String[100];
    boolean running = true;
    int counterEmployee = getCounter();
    public Employeemanagement(Scanner scan) {
        super();
        this.scan = scan;       
    }

    @Override
    public void AddEmployee() {
       
       clearScreen();
       scan.nextLine();
       while(running){
       center("ADD EMPLOYEE");
       System.out.print("\n\n");
       
       if(employeeNames[counterEmployee] == null){
       System.out.print("Enter Employee Name: ");
       employeeNames[this.counterEmployee] = scan.nextLine();
       System.out.print("Enter Address: ");
       employeeAddress[this.counterEmployee] = scan.nextLine();
       System.out.print("Enter Phone Number: ");
       employeePhoneNumber[this.counterEmployee] = scan.nextLine();
       System.out.print("Position: ");
       employeePosition[this.counterEmployee] = scan.nextLine();
       System.out.print("Salary: ");
       employeeSalary[this.counterEmployee] = scan.nextLine();
       counterEmployee++;
       setCounter(counterEmployee);
       System.out.println(counterEmployee + "Employee Added Successfully\n");
       System.out.println("Do you want to add another employee? (Y/N)");
       String user = scan.nextLine();
       if(user.equals("N")|| user.equals("n")){
           running = false;
       }
       else if(user.equals("Y") || user.equals("y")){
          clearScreen();
          running = true;
       }
       else{
        JOptionPane.showMessageDialog(null, "ERROR: Invalid Input", "ERROR", JOptionPane.ERROR_MESSAGE);
        clearScreen();
        continue;
    }
}
}
       
       StartMainMenu();
}
    @Override
    public void ShowEmployee() {
        clearScreen();
        center("LIST OF EMPLOYEES");
        System.out.println("\n\n");
        for(int i = 0; i < counterEmployee; i++){
            if(employeeNames[i] != null){
            System.out.println(i+1 +".\nEmployee Name: " + employeeNames[i]);
            System.out.println("Address: " + employeeAddress[i]);
            System.out.println("Phone Number: " + employeePhoneNumber[i]);
            System.out.println("Position: " + employeePosition[i]);
            System.out.println("Salary: " + employeeSalary[i]);
            System.out.println("\n");

            System.out.println("Total Number of Employees: " + counterEmployee);
            }
     
        } 
        waitForAnyKey();
        StartMainMenu(); 
       
        
    }
    @Override
    public void removeEmployee() {
       while(true){
       System.out.println("REMOVE EMPLOYEE\n\n");
       clearScreen();
       scan.nextLine();
       System.out.print("Enter Employee Name: ");
       String name = scan.nextLine();

       for(int i = 0 ; i < counterEmployee; i++){
          if(name.replaceAll("\s+", "").toLowerCase().equals(employeeNames[i].replaceAll("\s", "").toLowerCase())){
                employeeNames[i] = null;
                employeeAddress[i] = null;
                employeePhoneNumber[i] = null;
                employeePosition[i] = null;
                employeeSalary[i] = null;
                
                System.out.println("Employee Removed Successfully");
                break;
            }
            else{
                System.out.println("Employee not found");
          }
           }
        for(int j = 0 ; j < counterEmployee ; j++){
            if(employeeNames[j] == null){
                employeeNames[j] = employeeNames[j+1];
                employeeAddress[j] = employeeAddress[j+1];
                employeePhoneNumber[j] = employeePhoneNumber[j+1];
                employeePosition[j] = employeePosition[j+1];
                employeeSalary[j] = employeeSalary[j+1];

                employeeNames[j+1] = null;
                employeeAddress[j+1] = null;
                employeePhoneNumber[j+1] = null;
                employeePosition[j+1] = null;
                employeeSalary[j+1] = null;
               

            }
             
        }
           this.counterEmployee--;
           setCounter(counterEmployee);
        System.out.println("Do you want to remove another employee? (Y/N)");
        String user = scan.nextLine();
        if(user.equals("N")|| user.equals("n")){
            break;
        }
        else if(user.equals("Y") || user.equals("y")){
            clearScreen();
            continue;
        }
        else{
            System.err.println("Invalid Input");
        }

    }
        StartMainMenu();
        }
    
    @Override
    public void listAllEmployee() {
        clearScreen();
        center("LIST OF ALL EMPLOYEES");
        System.out.println("\n");
        for(int i = 0 ; i < counterEmployee; i++){
            System.out.println(i+1 + ". " + employeeNames[i]);
        }
        waitForAnyKey();
        StartMainMenu(); 
    }
    public void displayEmployeeMenu(){
       
        clearScreen();
        System.out.println(ANSI_YELLOW +"1. Add Employee" );
        System.out.println("2. Show Employee");
        System.out.println("3. Remove Employee");
        System.out.println("4. List All Employee");
        System.out.println("5. Back to Main Menu"+ANSI_RESET);
        System.out.println("Enter your choice: ");
        if(scan.hasNextInt()){
        userChoice = scan.nextInt();
        }
        functionalityEmployeeMenu();
    }
    private void functionalityEmployeeMenu(){
        switch(userChoice){
        
            case 1:
                AddEmployee();
               
                break;
            case 2:
                ShowEmployee();
                break;
            case 3:
                removeEmployee();
                break;
            case 4:
                listAllEmployee();
                break;
            case 5:
                StartMainMenu();
                break;
        }
        
    }


}

