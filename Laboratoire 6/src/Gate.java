import java.util.List;
public class Gate extends Subject{
    private String gateNumber;
    Terminal terminal;
    public Gate (String s ) {
        this.gateNumber = s;
    }
    public String getGateNumber () {
        return gateNumber;
    }
    public void setGateNumber (String gateNumber) {
        this.gateNumber = gateNumber;
    }

    @Override
    public void addFlight (Flight flight) {
        listOfFlights.add(flight);
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

    @Override
    public String toString ( ) {
        return ( "GATE "+gateNumber);
    }
}
