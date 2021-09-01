import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphicsPane extends JPanel{
    public int width,height;
    public ArrayList<Client> displayedClients;
    int clientWidth = 100;
    int clientHeight = 50;
    int clientGap = 50;
    public GraphicsPane(){
        displayedClients = new ArrayList<Client>();
    }
    public String debugClass = "Graphics Pane";
    @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 600);
        }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Client c : displayedClients){
            updateClient(c,g);
        }
    }

    public void updateClient(Client client, Graphics g){
        if (displayedClients.contains(client)){
            //drawClient(client,g,client.x,client.y);
        }
        else{
            displayedClients.add(client);
            int lastX = 0;
            int lastY = 0;
            for (Client c : displayedClients){
                if (c.x > lastX){lastX = c.x;}
                if (c.y > lastY){lastY = c.y;}
            client.x = lastX+clientGap;
            client.y = lastY+clientGap;
            drawClient(client,g,lastX+clientGap,lastY+clientGap);
            
        }
        
        }
    }

    void drawClient(Client client,Graphics g,int x,int y){
       if (client.getFound()){
           if (client.tagged){
            CoyDebug.addToDebug(debugClass,"Drawing Client");
                g.setColor(Color.green);
                g.fillRect(x, y, x+clientWidth, y+clientHeight);
                g.setColor(Color.black);
                g.drawString(client.name, x+(clientWidth/2), y+(clientHeight/2));
           }
        }
        else{
            CoyDebug.addToDebug(debugClass,"Drawing Client");
                g.setColor(Color.red);
                g.fillRect(x, y, x+clientWidth, y+clientHeight);
                g.setColor(Color.black);
                g.drawString(client.name, x+(clientWidth/2), y+(clientHeight/2));
        }
    }

    public void setWidth(int width){this.width = width;}
    public void setHeight(int height){this.height = height;}
}
