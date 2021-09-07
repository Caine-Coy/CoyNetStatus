
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
    static BorderLayout layout;
    static Graphics gc;
    static Canvas canvas;
    static GraphicsPane graphicsPane;
    static List clientList;
    static List serverList;

    static void initiateWindow(){
        frame = new JFrame("CoyNetStatus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maxSize = new Dimension(maxWidth,maxHeight);
    }

    static void initiateUI(){
        //var setup
        //Grid setup
        layout = new BorderLayout();
        layout.preferredLayoutSize(frame);
        frame.setLayout(layout);
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
            frame.add(scanButton,BorderLayout.NORTH);
            scanButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Main.scanNetwork();
                    updateUI();
                }
            });
            clientList = new List();
            frame.add(clientList,BorderLayout.CENTER);
            serverList = new List();
            frame.add(serverList,BorderLayout.WEST);
        }
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setSize(maxSize);
        frame.setMaximumSize(maxSize);
        frame.pack();
    }
    static void updateUI(){  
        if (gRenderInterface){
            canvas.repaint();
        }
        else{
            for(int i = 0; i < serverList.getItems().length;i++){
                for (Client client : Main.knownClients){
                    if (client.name == stripName(serverList.getItem(i))){
                        serverList.replaceItem(client.name + "(" + client.updateStatus() +")", i); 
                    }
                }
                
            }
        }
        frame.pack();
    }

   /*static void updateClient(Client client){
        serverList.add(client.name + client.updateStatus());
    }*/

    static void addClient(Client client){
        if (gRenderInterface){
            graphicsPane.updateClient(client);
        }
        else{
            if (client.tagged){
                serverList.add(client.alias + "(" + client.updateStatus() + ")");
            }
            else{clientList.add(client.name);}
        }
        
    }

    static String stripName(String name){
        String[] result = name.split("\\(");
        //CoyDebug.addToDebug(debugClass, "String split to " + result[0]);
        return result[0];
    }
    

    

}

