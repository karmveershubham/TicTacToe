package AutoMotive;

import java.util.*;

public class Showroom implements utility{
    String showroom_name;
    String showroom_address;
    String manager_name;
    int total_employee;
    int total_cars_in_stock = 0;
    
    @Override
    public void get_details(){
        System.out.println("Showroom Name: " + showroom_name);
        System.out.println("Showroom Address: " + showroom_address);
        System.out.println("Manager Name: " + manager_name);
        System.out.println("Total Employee: " + total_employee);
        System.out.println("Total Cars In Stock: " + total_cars_in_stock);
    }
    
    @Override
    public void set_details(){
        Scanner sc = new Scanner(System.in);
        System.out.println("====================== *** Enter Showroom Details *** ==================");
        System.out.println();
        System.out.print("Enter Showroom Name: ");
        showroom_name = sc.nextLine();
        System.out.print("Enter Showroom Address: ");
        showroom_address = sc.nextLine();
        System.out.print("Enter Manager Name: ");
        manager_name = sc.nextLine();
        System.out.print("Enter Total Employees Number: ");
        total_employee = sc.nextInt();
        System.out.print("Enter Total Availabe Car: ");
        total_cars_in_stock = sc.nextInt();
        System.out.println();
        System.out.println();
        sc.close();
    }
}


