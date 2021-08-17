import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //classes
    static NetworkInterface netInterface;
    //Vars
    static String debugClass = "Main";
    static Client localClient;
    static List<String> taggedNetworks;
    static List<Client> knownClients;
    //ui
    
    public static void main(String[] args) throws Exception {
        load();
        UI.initiateWindow();
        UI.initiateUI();
        scanNetwork();
        UI.updateUI();
    }

     static void load(){
         try{
            netInterface = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
         }
         catch(Exception e){
            CoyDebug.error(debugClass,e);
         }
        
        //add loading from file
        if (taggedNetworks == null){
            taggedNetworks = new ArrayList<String>();
        }
        if (knownClients == null){
            knownClients = new ArrayList<Client>();
        }
        //load configs

    }
    void save(){
        //save to file
    }
    /**
     * Checks to see if we have seen the client before.
     * Adds it to the client List if we have.
     * @param client Client to check.
     */
    static boolean checkKnown(Client client){
        for(Client c : knownClients){
            if (client == c){return true;}
        }
        return false;
    }
    /**
     * Checks the MAC against known MACs'
     * @param identifier Accepts MAC Name
     */
    static boolean checkKnown(String identifier){
        for(Client c : knownClients){
            if (identifier == c.MAC){return true;}
        }
        return false;
    }
     
    static void scanNetwork(){
        try{
            if (!checkKnown(CoyFunctions.convertMACtoString(netInterface.getHardwareAddress()))){
                localClient = new Client(InetAddress.getLocalHost().getHostName(), CoyFunctions.convertMACtoString(NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress()), InetAddress.getLocalHost().getHostAddress());
            }
            UI.networkLabel.setText(localClient.name+" "+localClient.MAC+" "+localClient.currentIP);
        }
        catch (Exception e){
            UI.networkLabel.setText(e.toString());
        }

    }

}
