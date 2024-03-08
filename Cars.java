package AutoMotive;

import java.util.*;

public class Cars extends Showroom implements utility{
    String car_name;
    String car_color;
    String car_fuel_type;
    int car_price;
    String car_type;
    String car_transmission;
    
    @Override
    public void get_details(){
        System.out.println("NAME: " + car_name);
        System.out.println("COLOR: " + car_color);
        System.out.println("FUEL TYPE: " + car_fuel_type);
        System.out.println("PRICE: " + car_price);
        System.out.println("CAR TYPE: " + car_type);
        System.out.println("TRANSMISSION: " + car_transmission);
    }
    
    @Override
    public void set_details(){
        Scanner sc = new Scanner(System.in);
        System.out.println("====================== *** Enter Car Details *** ==================");
        System.out.print("ENTER NAME: ");
        car_name = sc.nextLine();
        System.out.print("ENTER COLOR: ");
        car_color = sc.nextLine();
        System.out.print("ENTER FUEL TYPE(PATROL/DIESEL): ");
        car_fuel_type = sc.nextLine();
        System.out.print("ENTER PRICE: " );
        car_price = sc.nextInt();
        System.out.print("ENTER CAR TYPE(SEDAN/SUV/HATCHBACK: ");
        car_type = sc.nextLine();
        System.out.print("ENTER TRANSMISSION TYPE(AUTOMATIC/MANUAL): ");
        car_transmission = sc.nextLine();
        System.out.println();
        System.out.println();
        total_cars_in_stock++;
    }
    
}
