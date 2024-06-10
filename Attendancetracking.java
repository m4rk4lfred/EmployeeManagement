package EmployeeManagementSystem;

import java.util.Scanner;

import EmployeeManagementSystem.Mainmenu.attendanceTracking;

public class Attendancetracking extends Employeemanagement implements attendanceTracking{
     public static Attendancetracking Attendancetracking;
     Scanner scan;
     int attendanceSize = 100;
     static String[][] markedAttendance = new String[100][3];
     static int attendanceCount;
    public Attendancetracking(Scanner scan){
         super(scan);
         this.scan = scan;
     }
     
    //  THIS IS SINGLETON DESIGN PATTERN SO THAT ONLY ONE INSTANCE OF THE CLASS IS CREATED
    public static Attendancetracking getAttendancetracking(){
        if(Attendancetracking != null){
           Attendancetracking = new Attendancetracking();
        }
        return Attendancetracking;
    }

   public void showAttendanceMenu(){
         clearScreen();
         System.out.println("Attendance Tracker\n");
         System.out.println("1. Mark Attendance");
         System.out.println("2. View Attendance by date");
         System.out.println("3. View attendance by employee");
         System.out.println("4. Back to Main Menu");
         functionalityAttendance();
   }

   public void functionalityAttendance(){
         System.out.println("Enter your choice: ");
         int userChoice = scan.nextInt();
         switch(userChoice){
             case 1:
                 markAttendance();
                 break;
             case 2:
                 showAttendanceByDate();
                 break;
             case 3:
                 viewAttendanceByEmployee();
                 break;
             case 4:
                 StartMainMenu();
                 break;
         }
   }

   public void markAttendance(){
         clearScreen();
         scan.nextLine();
         System.out.println("Mark Attendance\n");
         System.out.print("Enter date (YYYY-MM-DD): ");
         String date = scan.nextLine();
         System.out.print("Enter Employee Name: ");
         String name = scan.nextLine();
         System.out.print("Mark attendance(Absent, Present , Leave): ");
         String attendance = scan.nextLine();
         boolean nameAdded = false;
         boolean dateAdded = false;
         boolean attendanceAdded = false;
         for(int i = 0 ; i < employeeNames.length ; i++){
             if(name != null && name.equals(employeeNames[i]) && !nameAdded){
                 markedAttendance[attendanceCount][0] = employeeNames[i];
                 nameAdded = true;
             } 

             if(date != null && !dateAdded){
                 markedAttendance[attendanceCount][1] = date;      
                 dateAdded = true;
             }
             
             if(attendance != null && !attendanceAdded){
                    markedAttendance[attendanceCount][2] = attendance;
                    attendanceAdded = true;
             }
             if(nameAdded && dateAdded && attendanceAdded){
                 System.out.println("Employee " + name + " marked " +attendance+ " on " + date + " successfully");
                
                 dateAdded = false;
                 nameAdded = false;
                 attendanceAdded = false;
                 
             }
            
         }
         attendanceCount++;
         System.out.println("Attendance Count: " + attendanceCount);

         /*for(int i = 0 ; i < markedAttendance.length ; i++){
            for(int j = 0 ; j < markedAttendance[i].length ; j++){
                System.out.println(markedAttendance[i][j]);
            }
         } */
         waitForAnyKey();
         StartMainMenu();
   }

   public void showAttendanceByDate(){
           clearScreen();
           scan.nextLine();
           System.out.println("View Attendance by Date\n");
           System.out.println("Enter Date (YYYY-MM-DD): ");
           String dates = scan.nextLine();

           for(int i = 0 ; i < markedAttendance.length ; i++){
                 if(markedAttendance[i][1] != null && markedAttendance[i][1].replaceAll("-", "").equals(dates.replaceAll("-", ""))&& markedAttendance[i][2].toLowerCase().equals("present")){
                     System.out.println("Present: " + markedAttendance[i][0]);
                 }
                 if(markedAttendance[i][1] != null && markedAttendance[i][1].replaceAll("-", "").equals(dates.replaceAll("-", ""))&& markedAttendance[i][2].toLowerCase().equals("absent")){
                     System.out.println("Absent: " + markedAttendance[i][0]);
                 }
                 if(markedAttendance[i][1] != null && markedAttendance[i][1].replaceAll("-", "").equals(dates.replaceAll("-", ""))&& markedAttendance[i][2].toLowerCase().equals("leave")){
                     System.out.println("Leave: " + markedAttendance[i][0]);
                 }
           }
              waitForAnyKey();
              StartMainMenu();
   }

   public void viewAttendanceByEmployee(){

   }

   
}
