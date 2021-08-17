public class Client {
    //Vars
    String name;
    String MAC;
    String currentIP;
    String owner;
    boolean tagged;

    public Client(String name,String MAC,String currentIP){
        this.name = name;
        this.MAC = MAC;
        this.currentIP = currentIP;
        tagged = true;
    }
    void Untag(){tagged = false;}
    void tag(){tagged = true;}
}
