import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


import java.awt.Choice;
import java.awt.FlowLayout;
import javax.swing.*;


import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.JFrame;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



class compCheck implements ActionListener {
    private JDialog win;
    private compFile cfile;
    private JTextArea taSoln;
    private JTextField tfCompNum;
    private JButton submitBtn;

    public compCheck(compFile cfile) {
        this.cfile = cfile;
        win = new JDialog();
        win.setModalityType(ModalityType.APPLICATION_MODAL);
        win.setTitle("Complaints Filed");
        win.setSize(500, 500);
        win.setLayout(new GridLayout(2, 1));

        JTable tableAllComps = cfile.returnTable();
        tableAllComps.setEnabled(false);

        tfCompNum = new JTextField(40);

        taSoln = new JTextArea(7, 40);

        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Complaint No. "));
        panel.add(tfCompNum);
        panel.add(new JLabel("Solution "));
        panel.add(new JScrollPane(taSoln));
        panel.add(submitBtn);

        win.add(new JScrollPane(tableAllComps));
        win.add(panel);

        win.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (submitBtn == (JButton) e.getSource()) {
            boolean flag = true;
            int cno = 0;
            String sol = taSoln.getText();
            try {
                cno = Integer.parseInt(tfCompNum.getText());
            } catch (Exception exc) {
                flag = false;
                JOptionPane.showMessageDialog(null, "Invalid Complaint No");
            }
            if (flag) {
                if (!cfile.findComp(cno)) {
                    JOptionPane.showMessageDialog(null, "No Complaint exist for given Complain No.");
                } else if (sol.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Solution cant be empty");
                } else // Everything right
                {
                    try {
                        cfile.addSoln(cno, sol);
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                    } catch (Exception e1) {
                        int opt = JOptionPane.showConfirmDialog(null, "Solution Already Exists. Overwrite?");
                        if (opt == JOptionPane.YES_OPTION) {
                            cfile.overwriteSoln(cno, sol);
                            JOptionPane.showMessageDialog(null, "Successfully Overwrited");
                        }
                    }
                }
            }
            if (flag) {
                win.dispose();
            }
        }
    }
}



class compFile {
    private String compFName;
    int totalComps;
    private List<complaint> compList;

    public compFile(String compFName) {
        this.compFName = compFName;
        initList();
        this.totalComps = compList.size();
    }

    private void initList() {
        compList = new ArrayList<>();
        File f = new File(compFName);
        if (f.exists()) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(compFName));
                while (true) {
                    compList.add((complaint) ois.readObject());
                }
            } catch (EOFException eof) {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addComp(complaint comp) {
        compList.add(comp);
        this.totalComps++;
    }

    public void addSoln(int cNo, String soln) throws Exception {
        addSoln(cNo, soln, false);
    }

    public void overwriteSoln(int cNo, String soln) {
        try {
            addSoln(cNo, soln, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addSoln(int cNo, String soln, boolean overWrite) throws Exception {
        complaint comp = getComp(cNo);
        if (comp.soln.isEmpty() || overWrite) {
            complaint newComp = new complaint(comp.cNo, comp.dept, comp.comp, soln);
            remove(comp);
            addComp(newComp);
        } else if (!comp.soln.isEmpty()) {
            throw new Exception("Solution Already Exists");
        }
    }

    public String getSoln(int cNo) {
        complaint comp = getComp(cNo);
        if (comp != null) {
            return comp.soln;
        }
        return null;
    }

    public boolean findComp(int cNo) {
        return getComp(cNo) != null;
    }

    private complaint getComp(int cNo) {
        for (complaint comp : compList) {
            if (comp.cNo == cNo) {
                return comp;
            }
        }
        return null;
    }

    private void remove(complaint compTbr) {
        compList.remove(compTbr);
    }

    public JTable returnTable() {
        JTable table;
        Object columnNames[] = { "C.No.", "Department", "Complaint", "Solution" };
        Object rowData[][] = new Object[totalComps][columnNames.length];
        int i = 0;
        for (complaint comp : compList) {
            rowData[i][0] = comp.cNo;
            rowData[i][1] = comp.dept;
            rowData[i][2] = comp.comp;
            rowData[i][3] = comp.soln;
            ++i;
        }
        table = new JTable(rowData, columnNames);
        return table;
    }

    public void exit() {
        try {
            FileWriter fw = new FileWriter(compFName);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(compFName));
            oos.flush();
            for (complaint comp : compList) {
                oos.writeObject(comp);
                oos.flush();
            }
            oos.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}



class ComplaintGUI implements ActionListener, WindowListener {
    private JFrame win;
    private compFile cfile;
    private JButton menuBtns[];
    private final String password = "implementer";

    public ComplaintGUI() {
        win = new JFrame();
        String tmpPath = System.getProperty("java.io.tmpdir");
        cfile = new compFile(tmpPath + "comps.txt");

        win.setTitle("Complaint Box");
        win.setSize(500, 600);
        win.addWindowListener(this);
        win.setLayout(new GridLayout(5, 1));

        menuBtns = new JButton[5];
        for (int i = 0; i < menuBtns.length; ++i) {
            menuBtns[i] = new JButton();
            win.add(menuBtns[i]);
            menuBtns[i].addActionListener(this);
        }
        menuBtns[0].setText("MAIN MENU");
        menuBtns[1].setText("1. Register a Complaint");
        menuBtns[2].setText("2. Status of Complaint");
        menuBtns[3].setText("3. Check Complaint Filed");
        menuBtns[4].setText("4. Report");
        menuBtns[0].setEnabled(false);
        win.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (menuBtns[1] == e.getSource()) {
            new compRegister(cfile);
        } else if (menuBtns[2] == e.getSource()) {
            new compStatus(cfile);
        } else if (menuBtns[3] == e.getSource()) {
            String pwdEntered = JOptionPane.showInputDialog(win, "Enter Password : ");
            if (pwdEntered == null) {
                // do nothing
            } else if (pwdEntered.equals(password)) {
                new compCheck(cfile);
            } else {
                JOptionPane.showMessageDialog(win, "Wrong password");
            }
        } else if (menuBtns[4] == e.getSource()) {
            new compReport(cfile);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowClosing(WindowEvent e) {
        win.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        cfile.exit();
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
    }

}




class compReport {
    private JDialog win;
    private JTable tableAllComps;

    public compReport(compFile cfile) {
        win = new JDialog();
        win.setModalityType(ModalityType.APPLICATION_MODAL);
        win.setTitle("Complaints Filed");
        win.setSize(500, 500);
        win.setLayout(new GridLayout(1, 1));

        tableAllComps = cfile.returnTable();
        tableAllComps.setEnabled(false);
        win.add(new JScrollPane(tableAllComps));
        win.setVisible(true);
    }

}




class compStatus implements ActionListener {
    private JDialog win;
    private compFile cfile;
    private int compNum;
    private JTextField tfCompNum;
    private JTextArea taStatus;

    public compStatus(compFile cfile) {
        win = new JDialog();
        win.setModalityType(ModalityType.APPLICATION_MODAL);
        win.setTitle("Complaint Status");
        win.setSize(500, 300);
        win.setLayout(new GridLayout(2, 1));
        this.cfile = cfile;

        tfCompNum = new JTextField(20);
        tfCompNum.addActionListener(this);

        taStatus = new JTextArea(5, 40);
        taStatus.setEditable(false);

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Enter Complaint No. : "));
        panel1.add(tfCompNum);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Status "));
        panel2.add(new JScrollPane(taStatus));

        win.add(panel1);
        win.add(panel2);

        win.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.compNum = Integer.parseInt(tfCompNum.getText());
            String status = cfile.getSoln(compNum);
            if (status == null) {
                status = "Invalid Complaint No.";
            } else if (status.isEmpty()) {
                status = "No Solution found for given complaint number";
            }
            taStatus.setText(status);
        } catch (Exception exc) {
            taStatus.setText("Invalid Complaint No.");
        }
    }

}


@SuppressWarnings("serial")
class complaint implements Serializable {
    String dept;
    int cNo;
    String comp;
    String soln;

    public complaint(int cNo, String dept, String comp, String soln) {
        this.cNo = cNo;
        this.dept = dept;
        this.comp = comp;
        this.soln = soln;
    }

    @Override
    public String toString() {
        return (this.cNo + " " + this.dept + " " + this.comp + " " + this.soln);
    }
}


class compRegister implements ActionListener {
    private JDialog win;
    private compFile cfile;
    private JPanel panel1, panel2, panel3;
    private Choice dept;
    private String[] depts = { "Dept1", "Dept2", "Dept3", "Dept4", "Dept5" };
    private JTextArea taComp;
    private JButton submitBtn, cancelBtn;
    private int cno;

    public compRegister(compFile cfile) {
        win = new JDialog();
        this.cfile = cfile;
        cno = cfile.totalComps + 1;

        win.setModalityType(ModalityType.APPLICATION_MODAL);
        win.setTitle("Register Complaint");
        win.setSize(500, 500);
        win.setLayout(new FlowLayout());

        dept = new Choice();
        for (String d : depts) {
            dept.add(d);
        }
        panel1 = new JPanel();
        panel1.add(new JLabel("Department"));
        panel1.add(dept);
        win.add(panel1);

        panel2 = new JPanel();
        panel2.add(new JLabel("Complain no. "));
        panel2.add(new JLabel(cno + ""));
        win.add(panel2);

        taComp = new JTextArea(20, 40);
        win.add(new JScrollPane(taComp));

        panel3 = new JPanel();
        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(this);
        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(this);
        panel3.add(submitBtn);
        panel3.add(cancelBtn);

        win.add(panel3);
        win.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bPressed = (JButton) e.getSource();
        if (bPressed.equals(submitBtn)) {
            complaint newComp = new complaint(cno, dept.getSelectedItem(), taComp.getText(), "");
            cfile.addComp(newComp);
            JOptionPane.showMessageDialog(null, "Compaint has been Registered.\nYour Complaint No. is " + cno);
            win.dispose();
        } else if (bPressed.equals(cancelBtn)) {
            int cancel = JOptionPane.showConfirmDialog(null, "Cancel Complaint Registration ?");
            if (cancel == JOptionPane.YES_OPTION) {
                win.dispose();
            }
        }
    }
}

public class CGClient {

    public static void main(String[] args) {
        new ComplaintGUI();

    }

}