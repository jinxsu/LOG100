import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveDialog extends JDialog {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 350;

    private GuiApp app;
    private JPanel controlPanel;
    private JFileChooser fileChooser;




    public SaveDialog (GuiApp app) {
        super ( app, "Save" );
        this.app = app;

        fileChooser = new JFileChooser ();
        fileChooser.setCurrentDirectory ( new java.io.File ( "." ) );
        fileChooser.setFileSelectionMode ( JFileChooser.DIRECTORIES_ONLY );
        fileChooser.setAcceptAllFileFilterUsed ( false );
        save ();
        controlPanel = new JPanel ( );
        controlPanel.add ( fileChooser );


        add ( controlPanel );
        setSize ( controlPanel.getPreferredSize ());
        setLocationRelativeTo ( app );


        }

    private void save ( ) {

        int result = fileChooser.showSaveDialog ( this );
        if( result == JFileChooser.APPROVE_OPTION ) {

            String path = fileChooser.getSelectedFile ( ).getAbsolutePath ( );
            app.save ( path );
        }
    }

}

