import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphicsPane extends JPanel{
    public int width,height;
    public ArrayList<Client> displayedClients;
    int clientWidth = 300;
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
            drawClient(client,g,client.x,client.y);
        }
        else{
            displayedClients.add(client);
            int lastX = 0;
            int lastY = 0;
            for (Client c : displayedClients){
                if (c.x > lastX){lastX = c.x;}
                if (c.y > lastY){lastY = c.y;}
            }
            drawClient(client,g,lastX+clientGap,lastY+clientGap);
        }
    }

    void drawClient(Client client,Graphics g,int x,int y){
        if (client.getFound()){
                g.setColor(Color.green);
        }
    }

    public void setWidth(int width){this.width = width;}
    public void setHeight(int height){this.height = height;}
}
