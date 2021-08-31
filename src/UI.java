
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class UI {
    //ui
    static JFrame frame;
    static Label headerLabel;
    static FlowLayout layout;
    static ArrayList<ClientLabel> clientLabels;

    static void initiateWindow(){
        frame = new JFrame("CoyNetStatus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static void initiateUI(){
        //Grid setup
        layout = new FlowLayout();
        frame.setLayout(layout);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        headerLabel = new Label();
        headerLabel.setText("Tagged Devices");
        frame.add(headerLabel);


        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    static void updateUI(){
        frame.revalidate();  
        frame.pack();
    }

    static void addClientLabel(ClientLabel clientLabel){
        if (!clientLabels.contains(clientLabel)){
            frame.add(clientLabel.label);
        }
    }

}
