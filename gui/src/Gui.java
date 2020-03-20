import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    Gui(){
        JButton btn = new JButton("Click me");
        btn.setBounds(50, 100, 80, 30);
        add(btn);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(300, 300);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
         new Gui();
//        JFrame frame = new JFrame();
//        Button btn = new Button("Click");
//        btn.setBounds(200,200,200,200);
//        frame.add(btn);
//        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        frame.setSize(200, 200);
//        frame.setLayout(null);
//        frame.setVisible(true);

    }
}
