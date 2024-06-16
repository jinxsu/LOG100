public class GateScreen extends Observer{

    private ScreenDialog screenDialog;

    Gate gate;

    public GateScreen (Gate gate) {
        this.gate = gate;
    }
    public GateScreen(Gate gate, ScreenDialog screenDialog) {
        this.gate = gate;
        this.screenDialog = screenDialog;
    }

    @Override
    public void update ( ) {
     Observer.displayFlights(gate.getFlights(),screenDialog);

    }
}
