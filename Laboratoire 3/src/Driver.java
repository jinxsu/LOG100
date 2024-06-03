import dt.*;

import java.util.Scanner;

public class Driver {
    public static void testTruck() throws VehicleException {
            Truck cityTruck = new Truck ( new String[]{"sand", "traffic cones"}, 1001, "Ville de Montreal", "Valerie Plante", "City Hall", "Chevrolet", "Silverado", "MTL 001", 40000.F );
            Truck westmountTruck = new Truck ( new String[]{"sand", "traffic cones", "concrete", "trees", "flowers"}, 2001, "Westmount", "Michelle Desjardins", "75 Belvedere", "Ford", "XLT", "WMT 100", 27000.F );
            Truck expensiveTruck = new Truck ( new String[]{"traffic cones", "sand", "wood", "furniture", "food", "ice"}, 3003, "Griffintown", "Jean Montagne", "1122 Peel", "Toyota", "Tundra", "RST 002", 45000.F );
            System.out.println ( cityTruck );
            System.out.println ( westmountTruck );
            System.out.print ( expensiveTruck );
    }
    public static void testSuv() throws VehicleException {
            Suv cheapSuv = new Suv ( ( byte ) 12, ( byte ) 4, ( byte ) 2, "Jeanne Tremblay", "1100 Notre-Dame", "Fiat", "500X", "ABC 123", 25000.f );
            Suv mediumSuv = new Suv ( ( byte ) 7, ( byte ) 2, ( byte ) 2, "Pierre Maisonneuve", "", "Honda", "Odyssey", "FHG 789", 36000.f );
            Suv expensiveSuv = new Suv ( ( byte ) 8, ( byte ) 2, ( byte ) 2, "Justin Levesque", "1400 McGill", "BMW", "X6", "", 74000.f );
            System.out.println ( cheapSuv );
            System.out.println ( mediumSuv );
            System.out.print ( expensiveSuv );

    }
    public float sumValues(Vehicle[] vehicles)
    {
        if(vehicles==null||vehicles.length == 0)
        {
            return 0;
        }
        float sum = 0;
        for (Vehicle vehicle : vehicles)
        {
            sum+= vehicle.getValue ( );
        }
        return sum;
    }
    public static void main(String[] args) {
//        if(args[0].equals("truck")){
//            testTruck();
//        }
//        else if(args[0].equals("suv")){
//            testSuv ();
//        }
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt ( );
        switch (choice) {

            case 1:
                try{
                    testTruck ();
                } catch (TruckException e)
                {
                    System.out.println ( );
                    System.err.println ( "Error with Truck constructor parameter" +e.getParameter ());
                } catch (VehicleException e){
                    System.out.println ( );
                    System.err.println ("Error with Vehicle constructor parameter "+ e.getParameter());
                }
                break;
                case 2:
                    try{
                        testSuv ();
                    }catch (VehicleException e){
                        System.out.println ( );
                        System.err.println ("Error with Vehicle constructor parameter "+ e.getParameter());

                    }

        }




    }

    }

