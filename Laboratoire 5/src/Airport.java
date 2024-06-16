import java.util.List;

public class Airport extends Subject{

    @Override
    public void addFlight (Flight flight) {
        getFlights ().add(flight);
        notifyObservers ();
    }
    public void addFlight(String company, int flightNumber,String destination,int departureTime, String Terminal, String status)
    {
        listOfFlights.add ( new Flight ( company,flightNumber,destination, departureTime,Terminal,status) );
        notifyObservers ();
    }

    @Override
    public void removeFlight (Flight flight) {
        listOfFlights.remove(flight);
        notifyObservers ();

    }

    @Override
    public List<Flight> getFlights ( ) {
        return listOfFlights;
    }


}
