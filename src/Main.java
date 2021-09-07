import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Main{
    //classes
    static NetworkInterface netInterface;
    //Vars
    static String debugClass = "Main";
    static Client localClient;
    static List<String> taggedNetworks;
    static List<Client> knownClients;
    static HashMap<String,String> taggedIPs;
    static boolean scanning = false;
    static List<Future<?>> futures;
    
    
    public static void main(String[] args) throws Exception {
        CoyDebug.init(true,false);
        load();
        UI.initiateWindow();
        UI.initiateUI();
        if(UI.gRenderInterface){
            scanNetwork();
        }
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
            taggedIPs = new HashMap<String,String>();
            taggedIPs.put("80.235.222.202","Anchor House") ;//Anchor House
            taggedIPs.put("80.229.133.220","Granville Park"); //Granville Park
            taggedIPs.put("217.46.183.253","Beckenham"); //Beckenham
            taggedIPs.put("80.229.66.218","Stepping Stones"); //Stepping Stones
            taggedIPs.put("81.133.238.123","Ormiston Road"); //Ormiston Road
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

    static Client getKnownClientFromName(String name){
        for (Client c: knownClients){if (name == c.name){return c;}}
        return null;
    }
     
    static void scanNetwork(){
        if (!scanning){
            scanning = true;
            ExecutorService es = Executors.newCachedThreadPool();
            for (Map.Entry entry : taggedIPs.entrySet()){
                futures.add(es.submit(new Runnable(){
                    public void run(){
                        String IP = entry.getKey().toString();
                        try {
                            Client client;
                            if (!checkKnown(IP)){
                                client = new Client(InetAddress.getByName(IP).getHostName(), IP);
                                knownClients.add(client);
                                client.alias = entry.getValue().toString();
                                client.tag();
                                client.checkIfOnline();
                                UI.addClient(client);
                            }
                            else{
                                client = getKnownClientFromName(IP);
                                client.checkIfOnline();

                            }
                        } catch (Exception e) {
                            CoyDebug.error(debugClass, e);
                        }
                        
                    }
                }));
            }
            /*
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
                            es.shutdown();
                            scanning = false;
                            UI.updateUI();
                            
                        } catch (Exception e) {
                            CoyDebug.error(debugClass, e);
                        }
                        
                    }
                    */
                    
        }
    }
    static void testNetworkAdapter(){   
    }

    
}
