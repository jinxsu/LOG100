public class TerminalScreen extends Observer{
    Terminal terminal;
    String name;
    public TerminalScreen(){

    }
    public TerminalScreen (Terminal term, String s) {
        terminal = term;
        this.name = s;

    }

    public String getName ( ) {
        return name;
    }

    @Override
    public void update ( ) {
        System.out.println ( name );
        for(Flight flight: terminal.getFlights ( ))
        {
            System.out.println (flight.toString () );
        }

    }
}
