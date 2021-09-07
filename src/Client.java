import java.net.InetAddress;

public class Client {
    //Vars
    String name,currentIP,owner,status,alias;
    boolean found,tagged;
    int x,y;

    public Client(String name,String currentIP){
        this.name = name;
        this.currentIP = currentIP;
        tagged = true;
        CoyDebug.addToDebug("Client " + name, "Client "+ name + " Created");
        x = 0;
        y = 0;
        status = updateStatus();
    }
    void Untag(){tagged = false;}
    void tag(){tagged = true;}

    public String updateStatus(){
        if (getFound()){status="Online";}
        else{status="Offline";};
        return status;
    }

    boolean getFound(){return checkIfOnline();}

    boolean checkIfOnline(){
        try {
            if (InetAddress.getByName(currentIP).isReachable(100)){
                found = true;
                return true;
            }
            else{
                found = false;
                return false;
            }
        } catch (Exception e) {
            CoyDebug.error(name, e);
        }
        return false;    
    }

}
