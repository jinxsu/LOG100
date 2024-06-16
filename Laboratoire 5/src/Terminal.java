import java.util.List;

public class Terminal extends Subject{
    private String letter;
    Gate gate;
    public Terminal (String terminal ) {
        this.letter = terminal;
    }


    @Override
    public void addFlight (Flight flight) {
        listOfFlights.add ( flight );
        notifyObservers ();
    }
    public void addFlight(String company, int flightNumber,String destination,int departureTime, String Terminal, String status)
    {
        listOfFlights.add ( new Flight ( company,flightNumber,destination, departureTime,Terminal,status) );
        notifyObservers ();
    }

    @Override
    public void removeFlight (Flight flight) {
        listOfFlights.remove ( flight );
        notifyObservers ();

    }

    @Override
    public List<Flight> getFlights ( ) {
        return listOfFlights;
    }


}
