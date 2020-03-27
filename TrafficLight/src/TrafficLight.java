import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLight extends JFrame implements ActionListener {

    static JFrame f;
    static JCheckBox c1,c2,c3;
    static JLabel l1,l2,l3;

    public static void main(String[] args) {
        f = new JFrame("Traffic Light");
        c1 = new JCheckBox("Red");
        c2 = new JCheckBox("Green");
        c3 = new JCheckBox("Yellow");
       l1 = new JLabel();
        l2 = new JLabel();
       l3 = new JLabel();

//        l1.setText("");
//        l2.setText("Green");
//        l3.setText("Yellow");

        l1.setOpaque(true);
        l2.setOpaque(true);
        l3.setOpaque(true);

        c1.setBounds(10,100,100,30);
        c2.setBounds(160,100,100,30);
        c3.setBounds(310,100,100,30);

        l1.setBounds(10,10,100,30);
        l2.setBounds(160,10,100,30);
        l3.setBounds(310,10,100,30);



        TrafficLight t = new TrafficLight();
        c1.addActionListener(t);
        c2.addActionListener(t);
        c3.addActionListener(t);

        f.add(c1);
        f.add(c2);
        f.add(c3);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==c1 && c1.isSelected()){
            l1.setForeground(Color.red);
            l1.setText("Red Light");
            l2.setText("");
            l3.setText("");
            c2.setSelected(false);
            c3.setSelected(false);
//            f.remove(l2);
//            f.remove(l3);

        }
        else if(e.getSource()==c2 && c2.isSelected()){
            l2.setForeground(Color.green);
            l2.setText("Green Light");
            l1.setText("");
            l3.setText("");
            c1.setSelected(false);
            c3.setSelected(false);
//            f.remove(l1);
//            f.remove(l3);

        }
        else if(e.getSource()==c3 && c3.isSelected()){
            l3.setForeground(Color.yellow);
            l3.setText("Yellow Light");
            l1.setText("");
            l2.setText("");
            c2.setSelected(false);
            c1.setSelected(false);
//            f.remove(l2);
//            f.remove(l1);

        }else{
            l1.setText("");
            l2.setText("");
            l3.setText("");
        }

    }

}
