import javax.swing.*;

public class LoadDialog extends JDialog {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 350;

    private GuiApp app;
    private JPanel controlPanel;
    private JFileChooser fileChooser;


    public LoadDialog (GuiApp app) {
        super ( app, "Load" );
        this.app = app;

        fileChooser = new JFileChooser ();
        fileChooser.setCurrentDirectory ( new java.io.File ( "." ) );
        fileChooser.setFileSelectionMode ( JFileChooser.DIRECTORIES_ONLY );
        fileChooser.setAcceptAllFileFilterUsed ( false );
        load ();
        controlPanel = new JPanel ( );
        controlPanel.add ( fileChooser );

        add ( controlPanel );
        setSize ( controlPanel.getPreferredSize ());
        setLocationRelativeTo ( app );

    }
    private void load ( ) {

        int result = fileChooser.showOpenDialog ( this );
        if( result == JFileChooser.APPROVE_OPTION ) {

            String path = fileChooser.getSelectedFile ( ).getAbsolutePath ( );
            app.load ( path );
        }
    }
}


