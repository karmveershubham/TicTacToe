package AutoMotive;

import java.util.*;

interface utility{
    public void get_details();
    public void set_details();
}

public class AutoMotive {
    
    static void main_menu(){
        System.out.println();
        System.out.println("==================== *** WELCOME TO SHOWROOM MANAGEMENT SYSTEM *** ================");
        System.out.println();
        System.out.println("===================== *** ENTER YOUR CHOICE *** ====================");
        System.out.println();
        System.out.println("1)Add Showroom\t\t\t 2)Add Employee\t\t\t 3)Add Cars");
        System.out.println();
        System.out.println("4)Get Showroom\t\t\t 5)Get Employee\t\t\t 6)Get Cars");
        System.out.println();
        System.out.println("=========================== *** ENTER 0 TO EXIT *** =======================");
    }

    public static void main(String[] args) {
        Showroom showroom[] = new Showroom[5];
        Employees employee[] = new Employees[5];
        Customers customers[] =new Customers[5];
        Cars car[] = new Cars[5];


        int showroom_index = 0;
        int employee_index = 0;
        int car_index = 0;
        int customer_index=0;
        int choice=0;

        main_menu();
        
        while(true){

            Scanner sc = new Scanner(System.in);

            choice=sc.nextInt();

            switch(choice){
                case 0:
                    System.out.println("\nThanks!\nHave A Nice Day.");
                    System.exit(0);
                    break;
                case 1:
                    showroom[showroom_index] = new Showroom();
                    showroom[showroom_index].set_details();
                    showroom_index++;
                    System.out.println("New ShowRoom Added SucessFully.");
                    System.out.print("===================== *** ENTER YOUR CHOICE *** ====================");
                    break;
                
                case 2:
                    employee[employee_index] = new Employees();
                    employee[employee_index].set_details();
                    employee_index++;
                    System.out.println();
                    System.out.println("2)Add new Employee");
                    System.out.println("()Go to Main Menu");
                    // choice=sc.nextInt();
                    break;
                
                case 3:
                    car[car_index] = new Cars();
                    car[car_index].set_details();
                    car_index++;
                    System.out.println();
                    System.out.println("3)Add new Car");
                    System.out.println("9)Go to Main Menu");
                    // choice = sc.nextInt();
                    break;
                case 4:
                    customers[car_index] = new Customers();
                    customers[car_index].set_details();
                    customer_index++;
                    System.out.println();
                    System.out.println("3)Add new Customer");
                    System.out.println("9)Go to Main Menu");
                    // choice = sc.nextInt();
                    break;
                
                case 5:
                    for(int j = 0; j < showroom_index; j++){
                        showroom[j].get_details();
                        System.out.println();
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("9)Go Back to Main Menu");
                    System.out.println("0)Exit");
                    // choice = sc.nextInt();
                    break;
                
                case 6:
                    for(int j = 0; j < employee_index; j++){
                        employee[j].get_details();
                        System.out.println();
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("9)Go Back to Main Menu");
                    System.out.println("0)Exit");
                    // choice = sc.nextInt();
                    break;
                
                case 7:
                    for(int j = 0; j < car_index; j++){
                        car[j].get_details();
                        System.out.println();
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("9)Go Back to Main Menu");
                    System.out.println("0)Exit");
                    // choice = sc.nextInt();
                    break;
                
                case 8:
                    for(int j = 0; j < customer_index; j++){
                        car[j].get_details();
                        System.out.println();
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("9)Go Back to Main Menu");
                    System.out.println("0)Exit");
                    // choice = sc.nextInt();
                    break;
                
                default: 
                    System.out.print("Please Enter a Valid Choice: ");
                    main_menu();
                    // choice = sc.nextInt();
                    break;
            }
        }
    }
    
}
