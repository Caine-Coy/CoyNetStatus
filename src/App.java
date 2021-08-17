import java.awt.*;
import javax.swing.*;


public class App {
    static JFrame frame;
    public static void main(String[] args) throws Exception {
        initiateWindow();
        initiateUI();
        displayMainScreen();
    }

    static void initiateWindow(){
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static void initiateUI(){
        Label label = new Label();
        label.setText("Eggplant");
        label.setAlignment(Label.CENTER);
        frame.getContentPane().add(label, BorderLayout.CENTER);
    }
    static void displayMainScreen(){
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
