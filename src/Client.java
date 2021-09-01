public class Client {
    //Vars
    String name;
    String Alias;
    String currentIP;
    String owner;
    boolean tagged;
    boolean found;
    int x,y;

    public Client(String name,String currentIP){
        this.name = name;
        this.currentIP = currentIP;
        tagged = true;
        CoyDebug.addToDebug("Client " + name, "Client "+ name + " Created");
        x = 0;
        y = 0;
    }
    void Untag(){tagged = false;}
    void tag(){tagged = true;}

    boolean getFound(){return found;}
}
