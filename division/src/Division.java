import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Division extends JFrame implements ActionListener {
    static JFrame j;
//    static JTextField t;
    static Panel p;

    static JTextField t1;
    static JTextField t2;
    static JTextField t3;
    static JButton b;

    public static void main(String[] args) {
        j = new JFrame("Division");
        j.setSize(800, 100);
        t1 = new JTextField(16);
       t2 = new JTextField(16);
        t3 = new JTextField(16);
//        JTextArea ta = new JTextArea("/");
        JLabel ta = new JLabel();
        ta.setText("/");
        JLabel tb = new JLabel("=");
        b = new JButton("/");

        t1.setBounds(10,10,100,50);
//        ta.setBounds(210, 35, 10,10);
        b.setBounds(200, 20, 30,30);
        t2.setBounds(320,10,100,50);
        tb.setBounds(520,35,10,10);
        t3.setBounds(630,10,100,50);

        Division d = new Division();
//        t1.addActionListener(d);
        j.add(t1);
        j.add(t2);
        j.add(t3);
        j.add(b);
        j.add(tb);

        b.addActionListener(d);
        j.setLayout(null);
        j.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(t1.getText()=="" || t2.getText()=="")return;

        try {
            int a=Integer.parseInt(t1.getText());
            int b=Integer.parseInt(t2.getText());
            int c;

            c = a / b;
            t3.setText(Integer.toString(c));
        }catch (ArithmeticException A){
            System.out.println("Arithmetic exception: Divide by zero");
        }catch (NumberFormatException n){
            System.out.println("Number format exception: Not an integer");
        }
//        System.out.println(c);
    }

}
