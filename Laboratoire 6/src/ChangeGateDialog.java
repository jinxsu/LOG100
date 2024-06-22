import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeGateDialog extends JDialog {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 350;

    private GuiApp app;
    private JButton okButton, cancelButton;
    private JPanel controlPanel;
    private JTextField companyField, flightNumberField;
    private JTextField  terminalField, gateNumberField;



    public ChangeGateDialog (GuiApp guiApp) {
        super(guiApp, "Change Gate");
        this.app = guiApp;

        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener () {

            public void actionPerformed(ActionEvent e) {
                changeGate();
                setVisible(false);
            }
        });

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog (
                        ChangeGateDialog.this,
                        "Do you want to cancel?",
                        "Cancel",
                        JOptionPane.YES_NO_OPTION );

                if (choice == JOptionPane.YES_OPTION) {
                    setVisible ( false );
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
        terminalPanel.add(new JLabel("New Terminal: "));
        terminalPanel.add(terminalField);

        JPanel gatePanel=new JPanel ();
        gateNumberField = new JTextField(10);
        gatePanel.add(new JLabel("New Gate Number: "));
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

        setSize ( WIDTH, HEIGHT );
        setLocationRelativeTo(app);


    }

    private void changeGate ( ) {
        String company = companyField.getText();
        String flightNumber= flightNumberField.getText();
        String terminal = terminalField.getText();
        String gateNumber = gateNumberField.getText();

        app.changeGate(company, flightNumber, terminal, gateNumber);
        app.appendToDisplayArea ( "Changed Gate for " + company + " " + flightNumber + " to " + terminal + " " + gateNumber + "\n" );
    }
}
