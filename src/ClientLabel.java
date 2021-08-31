import java.awt.*;

public class ClientLabel{
    Label label;
    ClientLabel(Client client){
        label = new Label();
        label.setText(client.name + " " +client.currentIP);
        label.setAlignment(Label.CENTER);
    }
}
