import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main{
    //classes
    static NetworkInterface netInterface;
    //Vars
    static String debugClass = "Main";
    static Client localClient;
    static List<String> taggedNetworks;
    static List<Client> knownClients;
    static List<String> taggedIPs;
    static boolean scanning = false;
    static List<Future<?>> futures;
    
    
    public static void main(String[] args) throws Exception {
        CoyDebug.init(true,false);
        load();
        UI.initiateWindow();
        UI.initiateUI();
        scanNetwork();
        UI.updateUI();
    }

     static void load(){
         futures = new ArrayList<Future<?>>();
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
        if (taggedIPs == null){
            taggedIPs = new ArrayList<String>();
            taggedIPs.add("80.235.222.202") ;//Anchor House
            taggedIPs.add("80.229.133.220"); //Granville Park
            taggedIPs.add("217.46.183.253"); //Beckenham
            taggedIPs.add("80.229.66.218"); //Stepping Stones
            taggedIPs.add("81.133.238.123"); //Ormiston Road
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
     * Checks the Name against Known Names
     * @param identifier Accepts  Name
     */
    static boolean checkKnown(String identifier){
        for(Client c : knownClients){
            if (identifier == c.name){return true;}
        }
        return false;
    }
     
    static void scanNetwork(){
        //setup local Client
        /*try{
            //localClient = new Client(InetAddress.getLocalHost().getHostName(), CoyFunctions.convertMACtoString(NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress()), InetAddress.getLocalHost().getHostAddress()); 
            //debug.addToDebug(debugClass,localClient.name + " " + localClient.MAC + " " + localClient.currentIP);
        }
        catch(Exception e){
            debug.error(debugClass,e);
        }*/
        //scan net
        if (!scanning){
            scanning = true;
            ExecutorService es = Executors.newCachedThreadPool();
            for (String IP : taggedIPs){
                futures.add(es.submit(new Runnable(){
                    public void run(){
                        try {
                            if (InetAddress.getByName(IP).isReachable(100)){
                                if (!checkKnown(IP)){
                                    CoyDebug.addToDebug(debugClass, IP + " Found for the first time");
                                    Client client = new Client(InetAddress.getByName(IP).getHostName(), IP);
                                    client.found = true;
                                    client.tag();
                                    knownClients.add(client);
                                    UI.addClient(client);
                                    
                                }
                            }
                            else{
                                CoyDebug.addToDebug(debugClass, IP + " Cannot be connected to");
                            }
                        } catch (Exception e) {
                            CoyDebug.error(debugClass, e);
                        }
                        
                    }
                }));
            }
                for (int device = 0; device < 256; device++){
                    String host = 192+"."+168+ "." +0+"."+device;
                        //Thread t = new Thread(netscan);
                        //t.start();
                        futures.add(es.submit(new Runnable()
                        { 
                            public void run(){
                                try {
                                    if (InetAddress.getByName(host).isReachable(100)){
                                        if (!Main.checkKnown(InetAddress.getByName(host).getHostName())){
                                            CoyDebug.addToDebug(debugClass, InetAddress.getByName(host) + " Found for the first time");
                                            Client client = new Client(InetAddress.getByName(host).getHostName(), host);
                                            knownClients.add(client);
                                            client.found = true;
                                        }
                                        else{
                                            //TODO
                                        }
                                    }
                                    
                                } catch (Exception e) {
                                    CoyDebug.error(debugClass, e);
                                }
                            }         
                        }));
                    }
                    for(Future<?> f : futures){
                        try {
                            f.get();
                            UI.headerLabel.setText("Working...");
                            UI.updateUI();
                            es.shutdown();
                            scanning = false;
                            
                        } catch (Exception e) {
                            CoyDebug.error(debugClass, e);
                        }
                        
                    }
                    UI.updateUI();
        }
    }
    static void testNetworkAdapter(){
        
    }
}
