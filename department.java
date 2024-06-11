package EmployeeManagementSystem;

import java.util.Scanner;

import EmployeeManagementSystem.Mainmenu.departmentManegement;

public class department extends Employeemanagement implements departmentManegement{
    Scanner scan;
    private static department departmentManagement;
    static String[] departmentList = new String[100];
    boolean assign = true;
    public static int counterDepartment = 0;  
    public static int assignmentCount = 0;
    static String[][] assignedDepartment = new String[10][2];
    boolean departmentRunning = true;
     public department(Scanner scan){
       super(scan);
      this.scan = scan;
     }

     public static department getDeparManegement(){
          if(departmentManagement == null){
              departmentManagement = new department(new Scanner(System.in));
          }
            return departmentManagement;
     }

    

     public void showDepartmentMenu(){
            clearScreen();
            center("DEPARTMENT MANAGEMENT");
            System.out.println("\n");
            System.out.println("1. Add Department");
            System.out.println("2. Assign Employee to Department");
            System.out.println("3. Remove from Department");
            System.out.println("4. List all Department");
            System.out.println("5. Back to Main Menu");
            System.out.println("Enter your choice: ");
            if(scan.hasNextInt()){
            userChoice = scan.nextInt();
            }
            functionalityDepartment();
     }
    
     public void functionalityDepartment(){
           switch(userChoice)
           {
                case 1:
                    addDepartment();
                    
                    break;

                case 2:
                    assignEmplyoeeToDepartment();
                    break;
                
                case 3:
                    removeEmployeeFromDepartment();
                    break;

                case 4:
                    listDepartment();
                    break;

                case 5:
                    StartMainMenu();
                    break;
           }
     }
    @Override
    public void addDepartment() {
        center("ADD DEPARTMENT");
         scan.nextLine();
         while(departmentRunning){
            System.out.println("Enter Department Name: ");
            if(scan.hasNextLine()){
            departmentList[counterDepartment] = scan.nextLine();
            }
            counterDepartment++;
            
            System.out.println("Department Added Successfully\n");
            
            System.out.println("Do you want to add more Department? (Y/N)");
            String user = scan.nextLine();
            if(user.equals("N")|| user.equals("n")){
                departmentRunning = false;
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
    public void assignEmplyoeeToDepartment() {
        clearScreen();
        center("ASSIGN EMPLOYEE TO THE DEPARTMENT");
        System.out.println("\n\n");
        scan.nextLine();
        assign = true;
        while(assign){
            System.out.println("Enter Employee Name: ");
            String employeeName = scan.nextLine();
            System.out.println("Enter Department: ");
            String departmentName = scan.nextLine();
            boolean departmentAssigned = false;
            boolean employeeAssigned = false;
        
            for(int count = 0 ; count < departmentList.length ; count++){
                if(!departmentAssigned && departmentList[count] != null && departmentList[count].equals(departmentName)){
                    assignedDepartment[assignmentCount][1] = departmentList[count];
                    System.out.println("Department assigned: " + assignedDepartment[assignmentCount][1]);
                    departmentAssigned = true;
                }
        
                if(!employeeAssigned && employeeNames[count] != null && employeeNames[count].equals(employeeName)){
                    assignedDepartment[assignmentCount][0] = employeeNames[count];
                    System.out.println("Employee assigned: " + assignedDepartment[assignmentCount][0]);
                    employeeAssigned = true;
                }
        
                if(departmentAssigned && employeeAssigned){
                    System.out.println("Assignment complete for " + employeeName + " to " + departmentName);
                    assignmentCount++;
                    System.out.println("press y to back");
                    String users = scan.nextLine();
                    if(users.equals("y")){
                        assign = false;
                    }
                    break; // Exit the loop once both assignments are made
                }
            }
        
            if(!departmentAssigned || !employeeAssigned){
                System.out.println("Could not find a match for either the department or the employee.");
            }
        
        
        }
    
        StartMainMenu();
    }

    @Override
    public void removeEmployeeFromDepartment() {
        center("REMOVE EMPLOYEE FROM THE DEPARTMENT");
        System.out.println("\n\n");
        scan.nextLine();

        System.out.println("Enter Employee Name: ");
        String employeeName = scan.nextLine();

        for(int department = 0 ; department < assignedDepartment.length-1 ; department++){
            for(int employee = 0 ; employee < assignedDepartment[department].length ; employee++){
                if(assignedDepartment[department][employee] != null && assignedDepartment[department][employee].equals(employeeName)){
                    assignedDepartment[department][employee] = null;
                    
                }
                 if(assignedDepartment[department][employee] == null){
                     assignedDepartment[department][employee] = assignedDepartment[department + 1][employee];
                     assignedDepartment[department + 1][employee] = null;
                     
                 }
            } 
        }
        waitForAnyKey();
        StartMainMenu();
    }

    @Override
    public void listDepartment() {
        clearScreen();
        center("LIST OF DEPARTMENTS");
        System.out.println("\n\n");
        
         for(int i = 0 ; i < counterDepartment ; i++){
            System.out.println("Department: "+departmentList[i]);
            for(int j = 0 ; j < assignedDepartment.length ; j++){
                    int counter = 0;
                    if(assignedDepartment[j][counter] != null && departmentList[i].equals(assignedDepartment[j][1])){
                        System.out.println((j+1)+". "+assignedDepartment[j][counter]);
                        counter++;
                    }

                    if(counter == 2){
                        counter = 0;
                    }
                
            }
           }

        System.out.println("Total Number of Departments: " + counterDepartment);
        waitForAnyKey();
        StartMainMenu();
    }

    
}
