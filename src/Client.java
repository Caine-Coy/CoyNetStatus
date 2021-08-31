public class Client {
    //Vars
    String name;
    String currentIP;
    String owner;
    boolean tagged;
    ClientLabel label;

    public Client(String name,String currentIP){
        this.name = name;
        this.currentIP = currentIP;
        tagged = true;
        label = new ClientLabel(this);
        UI.addClientLabel(label);
        CoyDebug.addToDebug("Client " + name, "Client "+ name + " Created");
    }
    void Untag(){tagged = false;}
    void tag(){tagged = true;}
}
