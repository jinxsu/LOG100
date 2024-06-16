public class TerminalScreen extends Observer{
    Terminal terminal;
    String name;
    private ScreenDialog screenDialog;
    public TerminalScreen (Terminal term, String s) {
        terminal = term;
        this.name = s;

    }
    public TerminalScreen(Terminal terminal, String name, ScreenDialog screenDialog) {
        this.terminal = terminal;
        this.name = name;
        this.screenDialog = screenDialog;
    }


    @Override
    public void update ( ) {
       Observer.displayFlights(terminal.getFlights(),screenDialog);

    }
}