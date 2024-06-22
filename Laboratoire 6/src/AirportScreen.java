public class AirportScreen extends Observer{
    private ScreenDialog screenDialog;
    Airport airport;
    String name;


    public AirportScreen (Airport airport, String s) {
        this.airport = airport;
        this.name = s;
        

    }
    public AirportScreen(Airport airport, String name, ScreenDialog screenDialog) {
        this.airport = airport;
        this.name = name;
        this.screenDialog = screenDialog;
    }

    @Override
    public void update ( ) {
       Observer.displayFlights(airport.getFlights(),screenDialog);

    }
}