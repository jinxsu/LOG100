public class AirportScreen extends Observer{
    Airport airport;
    String name;

    public AirportScreen()
    {

    }

    public AirportScreen (Airport airport, String s) {
        this.airport = airport;
        this.name = s;


    }

    public String getName ( ) {
        return name;
    }

    @Override
    public void update ( ) {
        System.out.println (name );

        for(Flight flight : airport.getFlights()){
            System.out.println (flight.toString () );
        }



    }
}
