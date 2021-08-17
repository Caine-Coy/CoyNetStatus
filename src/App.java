import java.awt.*;
import java.net.*;
import javax.swing.*;


public class App {
    static JFrame frame;
    static String localIP;
    static Label networkLabel;
    static String[] taggedMAC;
    static String[] taggedNetworks;
    public static void main(String[] args) throws Exception {
        initiateWindow();
        initiateUI();
        displayMainScreen();

        scanNetwork();
    }

    static void initiateWindow(){
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static void initiateUI(){
        networkLabel = new Label();
        networkLabel.setText("Eggplant");
        networkLabel.setAlignment(Label.CENTER);
        frame.getContentPane().add(networkLabel, BorderLayout.CENTER);
    }
    static void displayMainScreen(){
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    static void loadConfig(){
        
    }
    static void scanNetwork(){
        try{
            localIP = Inet4Address.getLocalHost().getHostAddress();
            networkLabel.setText(localIP);
        }
        catch (Exception e){
            networkLabel.setText(e.toString());
        }

    }
}
