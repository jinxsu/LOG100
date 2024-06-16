import javax.swing.*;

public class DelayFlightDialog extends JDialog {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 350;

    private GuiApp app;
    private String currentState = null;

    private JButton okButton, cancelButton;
    private JPanel controlPanel;
    private JTextField companyField, flightNumberField, destinationField;
    private JTextField departureTimeField, terminalField, gateNumberField;
    private JComboBox statusBox;

    public DelayFlightDialog(GuiApp guiApp) {
        this.app=guiApp;
    }
}
