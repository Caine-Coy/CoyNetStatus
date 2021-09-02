
import java.awt.*;

import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

public class UI{
    //Vars
    static String debugClass = "UI";
    //classes
    static MouseInput mouseInput;
    //ui
    static boolean gRenderInterface = false;
    static int maxHeight = 600;
    static int maxWidth = 800;
    static Dimension maxSize;
    static JFrame frame;
    static Label headerLabel;
    static FlowLayout layout;
    static Graphics gc;
    static Canvas canvas;
    static GraphicsPane graphicsPane;

    static void initiateWindow(){
        frame = new JFrame("CoyNetStatus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maxSize = new Dimension(maxWidth,maxHeight);
    }

    static void initiateUI(){
        //var setup
        //Grid setup
        layout = new FlowLayout(10,10,10);
        layout.preferredLayoutSize(frame);
        frame.setLayout(layout);
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //labels
        if (gRenderInterface){
            canvas = new Canvas();
            canvas.setBounds(0, 0, 800, 600);
            graphicsPane = new GraphicsPane();
            frame.add(graphicsPane);
            mouseInput = new MouseInput();
            canvas.addMouseListener(mouseInput);
        }
        else{
            Button scanButton = new Button("Scan Network");
            frame.add(scanButton);
        }
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(maxSize);
        frame.setMaximumSize(maxSize);
        frame.pack();
    }
    static void updateUI(){  
        if (gRenderInterface){
            canvas.repaint();
        }
        frame.pack();
    }
    public void mouseEntered(MouseEvent ev){
        updateUI();
        CoyDebug.addToDebug(debugClass, "Mouse Entered");
    }
    static void addClient(Client client){
        if (gRenderInterface){
            graphicsPane.updateClient(client);
        }
        
    }
    

    

}

