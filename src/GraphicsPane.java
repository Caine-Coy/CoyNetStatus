import javax.swing.*;
import java.awt.*;

public class GraphicsPane extends JPanel{
    public int width,height;
    int gridSize = 4;
    Client[][] clientGrid= new Client[gridSize][gridSize];
    int clientWidth = UI.maxWidth/clientGrid.length;
    int clientHeight = UI.maxHeight/clientGrid.length;
    int clientHGap = 60;
    int clientVGap = 20;
    Graphics g;

    public GraphicsPane(){
    }
    public String debugClass = "Graphics Pane";
    @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 600);
        }
    @Override
    protected void paintComponent(Graphics g) {
        this.g = g;
        super.paintComponent(g);
        fillClientGrid();
    }

    public void updateClient(Client client){
        if (client.tagged){
            for (int x = 0;x < clientGrid[0].length;x++){
                 if (clientGrid[x][0] == null){
                    clientGrid[x][0] = client;
                }
                    
            }
        }       
    }
        
    void drawClient(Client client,Graphics g,int x,int y){
       if (client.getFound()){
         CoyDebug.addToDebug(debugClass,"Drawing Connected Client " + client.name);
            g.setColor(Color.green);
        }
        else{
            CoyDebug.addToDebug(debugClass,"Drawing Disconnected Client " + client.name);
                g.setColor(Color.red);    
        }
        g.fillRect(x, y,clientWidth, clientHeight);
        //Border and text
        g.setColor(Color.black);
        g.drawRect(x, y, clientWidth, clientHeight);
        g.drawString(client.name, x+(clientWidth/8), y+(clientHeight/2));
    }
    public synchronized void fillClientGrid(){
            for (int x = 0; x < clientGrid.length;x++){
                for (int y = 0; y < clientGrid.length;y++){
                    if (clientGrid[x][y] != null){
                        drawClient(clientGrid[x][y], g, x*clientWidth,y*clientHeight);     
                    }
                }
            }
    }

    public void setWidth(int width){this.width = width;}
    public void setHeight(int height){this.height = height;}
}
