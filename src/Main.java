import java.awt.*;
import java.net.*;
import javax.swing.*;


public class Main {
    //classes
    static NetworkInterface netInterface;
    static CoyDebug debug;
    //Vars
    static JFrame frame;
    static String localIP;
    static String localMAC;
    static String localName;
    static String[] taggedNetworks;
    static String[] knownMACs;
    static String[] taggedMAC;
    //ui
    static Label networkLabel;
    public static void main(String[] args) throws Exception {
        debug = new CoyDebug(true,false);
        initiateWindow();
        initiateUI();
        scanNetwork();
        updateUI();
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
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    static void updateUI(){
        frame.pack();  
    }
    static void loadConfig(){
        
    }
    static void scanNetwork(){
        try{
            localIP = Inet4Address.getLocalHost().getHostAddress();
            netInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            localMAC = CoyFunctions.convertMACtoString(netInterface.getHardwareAddress());
            networkLabel.setText(localIP+" "+localMAC);
        }
        catch (Exception e){
            networkLabel.setText(e.toString());
        }

    }

}
