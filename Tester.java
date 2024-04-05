/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntd.hv;

/**
 *
 * @author admin
 */
public class Tester {
    public static void main(String[] args) {
        ManageStudent ql = new ManageStudent();
        do {
            System.out.print("\n1. input by hand\n" +
                    "2. input from file\n" +
                    "3. input grade\n" +
                    "4. print student list\n" +
                    "5. search by name\n" +
                    "6. search by ID\n" +
                    "7. search by hometown\n" +
                    "8. Scholarship list\n" +
                    "9. Age statistics\n" +
                    "---------------------------\n" +
                    " Choice: ");
            int choice = Configuration.SC.nextInt();
            switch (choice){
                case 1:
                    char exit;
                    
                    do{
                        Configuration.SC.nextLine();
                        ql.addStudent();
                        System.out.println("Press '0' to input student, any key to exit");
                        exit = Configuration.SC.next().charAt(0);
                    }while (exit == '0');
                    break;
                case 2:
                    ql.addStudent("src/main/resouce/student.txt");
          
                    break;
                case 3:
                     
                    break;
                case 4:
                    System.out.print("\n Student List\n");
                    ql.printStudentList();
                     break;
                case 5:
                                         break;
                case 6:
                     
                    break;
                case 7:
                    
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("Age statistics");
                    break;
            }
        } while (true);
    }
}
