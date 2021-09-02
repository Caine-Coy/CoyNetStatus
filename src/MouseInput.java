import java.awt.event.*;
public class MouseInput implements MouseListener{
    //vars
    String debugClass = "Mouse Input";
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        CoyDebug.addToDebug(debugClass,"Mouse Entered @ " + e.getX() + ":" + e.getY());
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
