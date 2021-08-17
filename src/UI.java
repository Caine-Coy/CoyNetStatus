
import java.awt.*;
import javax.swing.*;

public class UI {
    //ui
    static JFrame frame;
    static Label networkLabel;

    static void initiateWindow(){
        frame = new JFrame("CoyNetStatus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static void initiateUI(){
        //Grid setup
        JPanel pane = new JPanel(new GridBagLayout());
       
        GridBagConstraints c = new GridBagConstraints();
        networkLabel = new Label();
        networkLabel.setText("Eggplant");
        networkLabel.setAlignment(Label.CENTER);
        pane.add(networkLabel, c);


        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    static void updateUI(){
        frame.pack();  
    }

}
