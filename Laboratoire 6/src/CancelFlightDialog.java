import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class CancelFlightDialog extends JDialog {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 350;

    private GuiApp app;
    private JButton okButton, cancelButton;
    private JPanel controlPanel;
    private JTextField companyField, flightNumberField;
    private JTextField terminalField, gateNumberField;
    private String[] statuses = { Flight.ONTIME, Flight.CANCELLED, Flight.BOARDING, Flight.DELAYED };
    public CancelFlightDialog(GuiApp app) {
        super(app, "Cancel Flight");
        this.app = app;

        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelFlight();
                setVisible(false);
            }
        });

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                        CancelFlightDialog.this,
                        "Do you want to cancel?",
                        "Cancel",
                        JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    setVisible(false);
                }
            }
        });
        JPanel companyPanel = new JPanel();
        companyField = new JTextField(10);
        companyPanel.add(new JLabel("Company: "));
        companyPanel.add(companyField);

        JPanel flightNumberPanel = new JPanel();
        flightNumberField = new JTextField(10);
        flightNumberPanel.add(new JLabel("Flight Number: "));
        flightNumberPanel.add ( flightNumberField );


        JPanel terminalPanel = new JPanel();
        terminalField = new JTextField(10);
        terminalPanel.add(new JLabel("Terminal: "));
        terminalPanel.add(terminalField);

        JPanel gatePanel=new JPanel ();
        gateNumberField = new JTextField(10);
        gatePanel.add(new JLabel("Gate Number: "));
        gatePanel.add(gateNumberField);

        controlPanel = new JPanel();
        controlPanel.add(okButton);
        controlPanel.add(cancelButton);
        Container c = getContentPane();
        c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
        c.add(companyPanel);
        c.add(flightNumberPanel);
        c.add(terminalPanel);
        c.add(gatePanel);
        c.add(controlPanel);

        add(controlPanel);
        setSize ( WIDTH, HEIGHT );
        setLocationRelativeTo(app);

    }

    private void cancelFlight ( ) {
        String company = companyField.getText();
        String flightNumber= flightNumberField.getText();
        String terminal = terminalField.getText();
        String gateNumber = gateNumberField.getText();
        app.cancelFlight ( company, flightNumber, terminal, gateNumber );
        app.appendToDisplayArea ( "Flight " + flightNumber + " has been notified of cancellation" );
    }

}
