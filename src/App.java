import java.awt.*;
import javax.swing.*;


public class App {
    static JFrame frame;
    public static void main(String[] args) throws Exception {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Label label = new Label();
        label.setText("Eggplant");
        label.setAlignment(label.CENTER);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);;
    }

    void initiateWindow(){

    }
}
