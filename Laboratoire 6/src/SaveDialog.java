import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveDialog extends JDialog {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 350;

    private GuiApp app;
    private JButton okButton, cancelButton;
    private JPanel controlPanel;
    private JFileChooser fileChooser;




    public SaveDialog (GuiApp app) {
        super ( app, "Save" );
        this.app = app;

        okButton = new JButton ( "OK" );
        okButton.addActionListener ( new ActionListener () {

            @Override
            public void actionPerformed ( ActionEvent e ) {
                save();
                setVisible ( false );
            }
        } );

        cancelButton = new JButton ( "Cancel" );
        cancelButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( ActionEvent e ) {
                int choice = JOptionPane.showConfirmDialog (
                        SaveDialog.this,
                        "Do you want to cancel?",
                        "Cancel",
                        JOptionPane.YES_NO_OPTION );

                if ( choice == JOptionPane.YES_OPTION ) {
                    setVisible ( false );
                }
            }
        } );

        fileChooser = new JFileChooser ();
        fileChooser.setCurrentDirectory ( new java.io.File ( "." ) );
        fileChooser.setDialogTitle ( "Specify a file to save" );
        fileChooser.setFileSelectionMode ( JFileChooser.FILES_ONLY );
        fileChooser.setAcceptAllFileFilterUsed ( false );
        fileChooser.addChoosableFileFilter ( new javax.swing.filechooser.FileFilter () {
            @Override
            public boolean accept ( java.io.File f ) {
                if ( f.isDirectory ( ) ) {
                    return true;
                }
                return f.getName ( ).toLowerCase ( ).endsWith ( ".txt" );
            }
            @Override
            public String getDescription ( ) {
                return "Text Files (*.txt)";
            }
        } );
        fileChooser.setFileFilter ( fileChooser.getAcceptAllFileFilter ( ) );
        fileChooser.setMultiSelectionEnabled ( false );
        fileChooser.setDialogType ( JFileChooser.SAVE_DIALOG );


        controlPanel = new JPanel ( );
        controlPanel.add ( fileChooser );

        controlPanel.add ( okButton );
        controlPanel.add ( cancelButton );

        add ( controlPanel );
        setSize ( controlPanel.getPreferredSize ());
        setLocationRelativeTo ( app );


        }

    private void save ( ) {

        String filename = "Flights.ser";
        fileChooser.setSelectedFile ( new java.io.File ( filename ) );
        if ( fileChooser.showSaveDialog ( this ) == JFileChooser.APPROVE_OPTION ) {
            filename = fileChooser.getSelectedFile ( ).getAbsolutePath ( );
        }
        app.save ( filename );
        app.appendToDisplayArea ( "Saved " + filename + "\n" );

    }

}

