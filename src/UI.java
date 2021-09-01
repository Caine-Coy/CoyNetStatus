
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class UI{
    //Vars
    static String debugClass = "UI";
    //ui
    static int maxHeight = 600;
    static int maxWidth = 800;
    static Dimension maxSize;
    static JFrame frame;
    static Label headerLabel;
    static FlowLayout layout;
    static ArrayList<ClientLabel> clientLabels;
    static Graphics gc;

    static void initiateWindow(){
        frame = new JFrame("CoyNetStatus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maxSize = new Dimension(maxWidth,maxHeight);
        gc = frame.getGraphics();
        
    }

    static void initiateUI(){
        //TODO CHANGE LAYOUT ENGINE. 2D RENDERING???
        //var setup
        clientLabels = new ArrayList<ClientLabel>();
        //Grid setup
        layout = new FlowLayout(10,10,10);
        layout.preferredLayoutSize(frame);
        frame.setLayout(layout);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //buttons
        JButton  scanButton = new JButton("Scan Network");
        scanButton.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Main.scanNetwork();         
        }});
        //labels
        headerLabel = new Label();
        headerLabel.setText("Tagged Devices");
        //frame adding
        frame.add(scanButton);
        frame.add(headerLabel);

        
        frame.setVisible(true);
        frame.setMaximumSize(maxSize);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setMaximumSize(maxSize);
    }
    static void updateUI(){  
        frame.pack();
        frame.setMaximumSize(maxSize);
        
    }
    public void paint (Graphics g){
        g.setColor(Color.red);
        g.drawRect(50, 50, 200, 200);
    }

    static void addClientLabel(ClientLabel clientLabel){
        if (!clientLabels.contains(clientLabel)){
            frame.add(clientLabel.label);
        }
    }

    

}
