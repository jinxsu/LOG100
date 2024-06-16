import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleApp {

    /*
     * Simulation attributes
     * DO NOT EDIT
     */

    private Scanner scan = new Scanner(System.in);

    private Airport airport = new Airport();
    private Terminal termA = new Terminal("TERMINAL A");
    private Terminal termB = new Terminal("TERMINAL B");
    private Terminal termC = new Terminal("TERMINAL C");
    private Gate[] gatesA = new Gate[3];
    private Gate[] gatesB = new Gate[7];
    private Gate[] gatesC = new Gate[5];

    /**
     * Creates the objects used for the simulation.
     * DO NOT EDIT
     */
    public void createObjects() {

        // Airport screens

        AirportScreen airportScreen1 = new AirportScreen(airport, "AIRPORT (1)");
        AirportScreen airportScreen2 = new AirportScreen(airport, "AIRPORT (2)");
        airport.attach(airportScreen1);
        airport.attach(airportScreen2);

        // Terminal screens (three each)

        TerminalScreen termAScreen1 = new TerminalScreen(termA, "TERMINAL A (1)");
        TerminalScreen termAScreen2 = new TerminalScreen(termA, "TERMINAL A (2)");
        TerminalScreen termAScreen3 = new TerminalScreen(termA, "TERMINAL A (3)");
        termA.attach(termAScreen1);
        termA.attach(termAScreen2);
        termA.attach(termAScreen3);

        TerminalScreen termBScreen1 = new TerminalScreen(termB, "TERMINAL B (1)");
        TerminalScreen termBScreen2 = new TerminalScreen(termB, "TERMINAL B (2)");
        TerminalScreen termBScreen3 = new TerminalScreen(termB, "TERMINAL B (3)");
        termB.attach(termBScreen1);
        termB.attach(termBScreen2);
        termB.attach(termBScreen3);

        TerminalScreen termCScreen1 = new TerminalScreen(termC, "TERMINAL C (1)");
        TerminalScreen termCScreen2 = new TerminalScreen(termC, "TERMINAL C (2)");
        TerminalScreen termCScreen3 = new TerminalScreen(termC, "TERMINAL C (3)");
        termC.attach(termCScreen1);
        termC.attach(termCScreen2);
        termC.attach(termCScreen3);

        // Gates and gate screens

        // Terminal A
        for(int i = 0; i < gatesA.length; ++i) {
            gatesA[i] = new Gate("A-" + (i + 1));
            gatesA[i].attach(new GateScreen(gatesA[i]));
        }
        // Terminal B
        for(int i = 0; i < gatesB.length; ++i) {
            gatesB[i] = new Gate("B-" + (i + 1));
            gatesB[i].attach(new GateScreen(gatesB[i]));
        }
        // Terminal C
        for(int i = 0; i < gatesC.length; ++i) {
            gatesC[i] = new Gate("C-" + (i + 1));
            gatesC[i].attach(new GateScreen(gatesC[i]));
        }
    }

    /**
     * Adds a new flight based on user-provided information.
     */
    public void addFlight() {

        // Collect flight information from the console

        System.out.print("Company: ");
        String company = scan.next();

        System.out.print("Flight Number: ");
        int flightNumber = scan.nextInt();

        System.out.print("Destination: ");
        String destination = scan.next();

        System.out.print("Departure Time (0000): ");
        int departureTime = scan.nextInt();

        System.out.print("Terminal (A, B, C): ");
        String terminal = scan.next();

        System.out.print("Gate Number: ");
        int gateNumber = scan.nextInt();

        System.out.println("Status:");
        System.out.println("1 - " + Flight.ONTIME);
        System.out.println("2 - " + Flight.CANCELLED);
        System.out.println("3 - " + Flight.BOARDING);
        System.out.println("4 - " + Flight.DELAYED);
        int statusInt = scan.nextInt();
        String statusStr = switch (statusInt) {
            case 1 -> Flight.ONTIME;
            case 2 -> Flight.CANCELLED;
            case 3 -> Flight.BOARDING;
            case 4 -> Flight.DELAYED;
            default -> "";
        };

        // Create an instance of Flight
        Flight flight = new Flight(company, flightNumber, destination,
                departureTime, terminal + "-" + gateNumber, statusStr);

        // Add it to the airport's list of flights
        airport.addFlight(flight);

        // Add it to the appropriate terminal and gate
        switch(terminal) {
            case "A":
                termA.addFlight(flight);
                gatesA[gateNumber - 1].addFlight(flight);
                break;
            case "B":
                termB.addFlight(flight);
                gatesB[gateNumber - 1].addFlight(flight);
                break;
            case "C":
                termC.addFlight(flight);
                gatesC[gateNumber - 1].addFlight(flight);
                break;
        }
    }

    /*
     * TODO: Implement the following methods. You may add other methods as well.
     */

    public void delayFlight() {
        String gate = " ";

        System.out.print("Company: ");
        String company = scan.next();

        System.out.print("Flight Number: ");
        int flightNumber = scan.nextInt();

        for(Flight flight : airport.getFlights()) {
            if(flight.getCompany().equals(company) && flight.getFlightNumber() == flightNumber) {
                if(Objects.equals ( flight.getStatus ( ), Flight.ONTIME )) {
                    flight.setStatus(Flight.DELAYED);
                     gate=flight.getGate ();
                }
            }
        }
        airport.notifyObservers ();
        if(gate.charAt ( 0)=='A')
        {
            termA.notifyObservers ();
        }
        else if(gate.charAt ( 0)=='B')
        {
            termB.notifyObservers ();
        }
        else{
            termC.notifyObservers ();
        }
        String[] arr = gate.split("-");
        if(arr[0].equals ("A"))
        {
            if(arr[1].equals ("1"))
            {
                gatesA[0].notifyObservers ();
            }
            else if(arr[1].equals ("2"))
            {
                gatesA[1].notifyObservers ();
            }
            else{
                gatesA[2].notifyObservers ();
            }
        }
        else if(arr[0].equals ("B"))
        {
            if(arr[1].equals ("1"))
            {
                gatesB[0].notifyObservers ();
            }
            else if(arr[1].equals ("2"))
            {
                gatesB[1].notifyObservers ();
            }
            else{
                gatesB[2].notifyObservers ();
            }

        }
        else{
            if(arr[1].equals ("1"))
            {
                gatesC[0].notifyObservers ();
            }
            else if(arr[1].equals ("2"))
            {
                gatesC[1].notifyObservers ();
            }
            else{
                gatesC[2].notifyObservers ();
            }
        }


    }
    public boolean isGateAvailable(String gate)
    {
        for(Flight flight : airport.getFlights()) {
            if(flight.getGate ().equals (gate)) {
                return false;
            }

        }
        return true;
    }
    private void notifyObserversByGate(String gate) {
        String[] parts = gate.split("-");
        String terminal = parts[0];
        int gateNumber = Integer.parseInt(parts[1]);

        switch (terminal) {
            case "A":
                termA.notifyObservers();
                gatesA[gateNumber - 1].notifyObservers();
                break;
            case "B":
                termB.notifyObservers();
                gatesB[gateNumber - 1].notifyObservers();
                break;
            case "C":
                termC.notifyObservers();
                gatesC[gateNumber - 1].notifyObservers();
                break;
        }
    }
    public void changeGate() {
        Flight flightToChangeGate = null;
        System.out.print("Company: ");
        String company = scan.next();

        System.out.print("Flight Number: ");
        int flightNumber = scan.nextInt();

        System.out.print("Terminal (A, B, C): ");
        String terminal = scan.next().toUpperCase (  );

        System.out.print("Gate Number: ");
        String gateNumber = scan.next();

        for(Flight flight : airport.getFlights()) {
            if(flight.getCompany ().equals ( company )&& flight.getFlightNumber ()==flightNumber )
            {
                flightToChangeGate = flight;
                break;


            }
        }
        String newGate=terminal+"-"+gateNumber;
        assert flightToChangeGate != null;
        String oldGate= flightToChangeGate.getGate ( );
        if(isGateAvailable(newGate)) {
            flightToChangeGate.setGate ( newGate );
            airport.notifyObservers();
            notifyObserversByGate(newGate);
            notifyObserversByGate ( oldGate );

        }
        else{
            System.out.println("New gate " + gateNumber + " is not available.");
        }




    }
    public void cancelFlight() {
        String gate=" ";
        System.out.print("Company: ");
        String company = scan.next();

        System.out.print("Flight Number: ");
        int flightNumber = scan.nextInt();

        for(Flight flight : airport.getFlights()) {
            if( flight.getCompany ().equals ( company )&& flight.getFlightNumber() == flightNumber )
            {
                flight.setStatus(Flight.CANCELLED);
                gate= flight.getGate ( );
            }
        }
        airport.notifyObservers ();
        if(gate.charAt ( 0)=='A')
        {
            termA.notifyObservers ();
        }
        else if(gate.charAt ( 0)=='B')
        {
            termB.notifyObservers ();
        }
        else{
            termC.notifyObservers ();
        }
        String[] arr = gate.split("-");
        if(arr[0].equals ("A"))
        {
            if(arr[1].equals ("1"))
            {
                gatesA[0].notifyObservers ();
            }
            else if(arr[1].equals ("2"))
            {
                gatesA[1].notifyObservers ();
            }
            else{
                gatesA[2].notifyObservers ();
            }
        }
        else if(arr[0].equals ("B"))
        {
            if(arr[1].equals ("1"))
            {
                gatesB[0].notifyObservers ();
            }
            else if(arr[1].equals ("2"))
            {
                gatesB[1].notifyObservers ();
            }
            else{
                gatesB[2].notifyObservers ();
            }

        }
        else{
            if(arr[1].equals ("1"))
            {
                gatesC[0].notifyObservers ();
            }
            else if(arr[1].equals ("2"))
            {
                gatesC[1].notifyObservers ();
            }
            else{
                gatesC[2].notifyObservers ();
            }
        }
    }
    public void notifyBoarding() {
        String gate=" ";
        System.out.print("Company: ");
        String company = scan.next();

        System.out.print("Flight Number: ");
        int flightNumber = scan.nextInt();

        for(Flight flight : airport.getFlights()) {
            if( flight.getCompany ().equals ( company )&& flight.getFlightNumber() == flightNumber )
            {
                flight.setStatus(Flight.BOARDING);
                gate= flight.getGate ( );
            }
        }
        airport.notifyObservers ();
        if(gate.charAt (0)=='A')
        {
            termA.notifyObservers ();
        }
        else if(gate.charAt (0)=='B')
        {
            termB.notifyObservers ();
        }
        else{
            termC.notifyObservers ();
        }
        String[] arr = gate.split("-");
        if(arr[0].equals ("A"))
        {
            if(arr[1].equals ("1"))
            {
                gatesA[0].notifyObservers ();
            }
            else if(arr[1].equals ("2"))
            {
                gatesA[1].notifyObservers ();
            }
            else{
                gatesA[2].notifyObservers ();
            }
        }
        else if(arr[0].equals ("B"))
        {
            if(arr[1].equals ("1"))
            {
                gatesB[0].notifyObservers ();
            }
            else if(arr[1].equals ("2"))
            {
                gatesB[1].notifyObservers ();
            }
            else{
                gatesB[2].notifyObservers ();
            }

        }
        else{
            if(arr[1].equals ("1"))
            {
                gatesC[0].notifyObservers ();
            }
            else if(arr[1].equals ("2"))
            {
                gatesC[1].notifyObservers ();
            }
            else{
                gatesC[2].notifyObservers ();
            }
        }

    }
    public void removeFlight() {
        String gate=" ";
        System.out.print("Company: ");
        String company = scan.next();
        System.out.print("Flight Number: ");
        int flightNumber = scan.nextInt();
        for(Flight flight : airport.getFlights()) {
            if(flight.getCompany().equals ( company )&& flight.getFlightNumber() == flightNumber )
            {
                airport.removeFlight(flight);
                gate= flight.getGate ();
            }

        }
        if(gate.charAt (0)=='A')
        {
            termA.notifyObservers ();
        }
        else if(gate.charAt (0)=='B')
        {
            termB.notifyObservers ();
        }
        else{
            termC.notifyObservers ();
        }
        String[] arr = gate.split("-");
        if(arr[0].equals ("A"))
        {
            if(arr[1].equals ("1"))
            {
                gatesA[0].notifyObservers ();
            }
            else if(arr[1].equals ("2"))
            {
                gatesA[1].notifyObservers ();
            }
            else{
                gatesA[2].notifyObservers ();
            }
        }
        else if(arr[0].equals ("B"))
        {
            if(arr[1].equals ("1"))
            {
                gatesB[0].notifyObservers ();
            }
            else if(arr[1].equals ("2"))
            {
                gatesB[1].notifyObservers ();
            }
            else{
                gatesB[2].notifyObservers ();
            }

        }
        else{
            if(arr[1].equals ("1"))
            {
                gatesC[0].notifyObservers ();
            }
            else if(arr[1].equals ("2"))
            {
                gatesC[1].notifyObservers ();
            }
            else{
                gatesC[2].notifyObservers ();
            }
        }

    }

    /**
     * Displays the options available in the console.
     * DO NOT EDIT
     */
    public void displayMenu() {
        System.out.println("********************");
        System.out.println("1 - Add Flight");
        System.out.println("2 - Delay Flight");
        System.out.println("3 - Change Gate");
        System.out.println("4 - Cancel Flight");
        System.out.println("5 - Notify Boarding");
        System.out.println("6 - Remove Flight");
        System.out.println("0 - Quit");
        System.out.println("********************");
    }

    /**
     * Displays the choice menu, waits for the user input, and calls the appropriate method.
     * DO NOT EDIT
     */
    public void displayPrompt() {
        int option = 0;

        do {
            displayMenu();
            System.out.print("Select Option: ");
            option = scan.nextInt();

            switch(option) {
                case 1: addFlight(); break;
                case 2: delayFlight(); break;
                case 3: changeGate(); break;
                case 4: cancelFlight(); break;
                case 5: notifyBoarding(); break;
                case 6: removeFlight(); break;
                case 0: scan.close(); break;
                default:
                    System.out.println("Error - stop");
                    scan.close();
                    return;
            }
        } while (option != 0); // While the option is not Quit
    }

    /**
     * Creates all the objects and starts the simulation.
     * DO NOT EDIT
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ConsoleApp app = new ConsoleApp();

        // Object setup
        app.createObjects();

        // Start the simulation
        app.displayPrompt();



    }

}
