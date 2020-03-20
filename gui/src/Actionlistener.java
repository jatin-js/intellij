import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Demo extends JFrame implements ActionListener {
    JButton b1;

    Demo(){
        this.setLayout(null);
        b1 = new JButton("Button 1");
        b1.setBounds(130, 5, 100, 50);
        this.add(b1);
        b1.addActionListener(this);
    }

    // Override Method
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == b1){
            JOptionPane.showMessageDialog(this, "Enter a valid Number", "WARNING", JOptionPane.WARNING_MESSAGE);
            JOptionPane.showMessageDialog(this, "Enter a valid String", "ERROR", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this,"Do you want to quit", "Question", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(this,"You pressed Button FOUR", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

        }
    }
}

class MessageDialog1 {
    public static void main(String[] args) {
        Demo f = new Demo();
        f.setBounds(200,200,400,300);
        f.setResizable(true);
        f.setVisible(true);

    }
}