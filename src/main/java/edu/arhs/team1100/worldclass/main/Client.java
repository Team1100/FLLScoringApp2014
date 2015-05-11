package edu.arhs.team1100.worldclass.main;

import edu.arhs.team1100.worldclass.forms.ClientApplication;
import edu.arhs.team1100.worldclass.forms.SetupDialog;
import edu.arhs.team1100.worldclass.util.HibernateUtil;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.hibernate.exception.JDBCConnectionException;

/**
 *
 * @author Eddie
 */
public class Client {

    private String username;
    private String password;
    private String address;
    private boolean GUI = true;

    public Client() {
    }

    public Client(String username, String password, String address) {
        this.username = username;
        this.password = password;
        this.address = address;
        GUI = false;
    }

    public void run() {
        boolean connected = false;
        SetupDialog setup = new SetupDialog();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        do {
            if (GUI) {

                int setupResult = JOptionPane.showConfirmDialog(new JFrame(), setup, "Setup", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (setupResult != JOptionPane.OK_OPTION) {
                    System.exit(0);
                }

                username = setup.getUsername();
                password = setup.getPassword();
                address = setup.getAddress();

                if (address.isEmpty()) {
                    address = "localhost";
                }
            }


            try {
                HibernateUtil.testConnection(username, password, address);
                connected = true;
            } catch (JDBCConnectionException e) {
                String message;
                if (e.getSQLException().getErrorCode() == 1045) {
                    message = "Username and password combination are incorrect. Retry?";
                } else if (e.getSQLException().getErrorCode() == 0) {
                    message = "Could not connect to server \"" + address + "\". Retry?";
                } else {
                    message = "Unknown error. See console for more info. Retry?";
                    System.out.println(e.getSQLException().getMessage());
                }

                int errorResult = JOptionPane.showConfirmDialog(new JFrame(), message, "Error", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                if (errorResult != JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
                
            
            }
        } while (!connected);
        
        new ClientApplication().display();
    }

}
