public class GateScreen extends Observer{
    Gate gate;

    public GateScreen()
    {

    }
    public GateScreen (Gate gate) {
        this.gate = gate;
    }

    public Gate getGate ( ) {
        return gate;
    }
    @Override
    public void update ( ) {
        System.out.println ( "GATE "+gate.toString () );
        for(Flight flight : gate.getFlights()) {
            System.out.println (flight.toString () );
        }

    }
}
