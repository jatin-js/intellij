import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



/**     Admin Section       **/

class AdminLogin implements ActionListener{
    private JLabel l1, l2;
    private JTextField t1, t2;
    private JFrame f;
    private JButton b;
    AdminLogin(){
        f = new JFrame("Admin Login page");
        f.setLayout(new GridLayout(8, 1, 5, 5));
        f.setSize(400, 600);
        f.setVisible(true);
        l1 = new JLabel("Admin User Id:");
        l2 = new JLabel("Admin password:");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        b = new JButton("submit");
        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(b);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        f.dispose();
        AdminFacility stdFasc = new AdminFacility();
    }
}

class AdminFacility implements ActionListener{
    private JButton b1, b2, b3, b4, b5, b6;
    private JFrame f;
    private JLabel l;
    AdminFacility(){
        f = new JFrame("ADMIN facility");
        f.setVisible(true);
        f.setSize(400, 600);
        f.setLayout(new GridLayout(8, 1, 5, 5));
        l = new JLabel("select facility form following options: ");
        b1 = new JButton("add Student");
        b2 = new JButton("Fill Attendance");
        b3 = new JButton("Manage Leave");
        b4 = new JButton("Manage Complain");
        b5 = new JButton("Manage Report");
        b6 = new JButton("Change Password");
        f.add(l);
        f.add(b1); f.add(b2); f.add(b3); f.add(b4); f.add(b5); f.add(b6);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        f.dispose();
        if(e.getSource()==b1){
            addDivisionORclass addDib = new addDivisionORclass();
        }
        else if(e.getSource()==b2){
            addFaculty addF = new addFaculty();
        }
    }
}

class addDivisionORclass{
    private JFrame f;
    private JLabel l3, l4;
    private JButton b;
    private JTextField f3, f4;
    addDivisionORclass(){
        f = new JFrame("Add Class OR Sections");

        l3 = new JLabel("Class:");
        l4 = new JLabel("Section:");

        f3 = new JTextField(20);
        f4 = new JTextField(20);
        b = new JButton("submit");
        f.setVisible(true);
        f.setSize(400, 600);
        f.setLayout(new GridLayout(5, 2, 7, 5));

        f.add(l3); f.add(f3);
        f.add(l4); f.add(f4);
        f.add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

    }
}

class addFaculty{
    private JFrame f;
    private JLabel l1, l2, l3;
    private JButton b;
    private JTextField f1, f2,f3;
    addFaculty(){
        f = new JFrame("Add Faculty");
        l1 = new JLabel("Name:");
        l2 = new JLabel("Reg. No.:");
        l3 = new JLabel("Subject:");

        f1 = new JTextField(20);
        f2 = new JTextField(20);
        f3 = new JTextField(20);

        b = new JButton("submit");
        f.setVisible(true);
        f.setSize(400, 600);
        f.setLayout(new GridLayout(5, 2, 7, 5));
        f.add(l1); f.add(f1);
        f.add(l2); f.add(f2);
        f.add(l3); f.add(f3);

        f.add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

    }
}


/**         Faculty Section         **/

class FacultyLogin implements ActionListener{
    private JLabel l1, l2;
    private JTextField t1, t2;
    private JFrame f;
    private JButton b;
    FacultyLogin(){
        f = new JFrame("Faculty Login page");
        f.setLayout(new GridLayout(8, 1, 5, 5));
        f.setSize(400, 600);
        f.setVisible(true);
        l1 = new JLabel("Faculty User Id:");
        l2 = new JLabel("Faculty password:");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        b = new JButton("submit");
        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(b);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        f.dispose();
        FacultyFacility stdFasc = new FacultyFacility();
    }
}

class FacultyFacility implements ActionListener{
    private JButton b1, b2, b3, b4, b5, b6;
    private JFrame f;
    private JLabel l;
    FacultyFacility(){
        f = new JFrame("FACULTY facility");
        f.setVisible(true);
        f.setSize(400, 600);
        f.setLayout(new GridLayout(8, 1, 5, 5));
        l = new JLabel("select facility form following options: ");
        b1 = new JButton("add Student");
        b2 = new JButton("Fill Attendance");
        b3 = new JButton("Manage Leave");
        b4 = new JButton("Manage Complain");
        b5 = new JButton("Manage Report");
        b6 = new JButton("Change Password");
        f.add(l);
        f.add(b1); f.add(b2); f.add(b3); f.add(b4); f.add(b5); f.add(b6);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        f.dispose();
        if(e.getSource()==b1){
            addStudent adStd = new addStudent();
        }
        else if(e.getSource()==b2){
            FillAttendance fill = new FillAttendance();
        }
        else if(e.getSource()==b3){
            ManageLeave leave = new ManageLeave();
        }
        else if(e.getSource()==b6){
            ChangePasswordF chP = new ChangePasswordF();
        }
    }
}

class addStudent{
    private JFrame f;
    private JLabel l1, l2, l3, l4;
    private JButton b;
    private JTextField f1, f2,f3, f4;
    addStudent(){
        f = new JFrame("Add Student");
        l1 = new JLabel("Name:");
        l2 = new JLabel("Roll No.:");
        l3 = new JLabel("Class:");
        l4 = new JLabel("Section:");
        f1 = new JTextField(20);
        f2 = new JTextField(20);
        f3 = new JTextField(20);
        f4 = new JTextField(20);
        b = new JButton("submit");
        f.setVisible(true);
        f.setSize(400, 600);
        f.setLayout(new GridLayout(5, 2, 7, 5));
        f.add(l1); f.add(f1);
        f.add(l2); f.add(f2);
        f.add(l3); f.add(f3);
        f.add(l4); f.add(f4);
        f.add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

    }
}

class FillAttendance{
    private Choice c;
    private JFrame f;
    private CheckboxGroup cbg;
    private Checkbox chk1, chk2;
    private JButton b;
    private JLabel l;
    FillAttendance(){
        f = new JFrame("Fill Attendance");
        l = new JLabel("Select Roll No.:");
        c = new Choice();
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        c.add("5");
        c.add("6");
        c.add("7");
        c.add("8");
        c.add("9");
        c.add("10");
        c.add("11");
        cbg = new CheckboxGroup();
        chk1 = new Checkbox("Present", cbg, false);
        chk2 = new Checkbox("Absent", cbg, false);
        b = new JButton("submit");
        f.add(l);
        f.add(c);
        f.add(chk1);
        f.add(chk2);
        f.add(b);

        f.setLayout(new GridLayout(7, 2,5,5));
        f.setSize(400, 600);
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roll = c.getItem(c.getSelectedIndex());
                chk1.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent E) {
                        if(E.getStateChange()==1){
                            //Code for increasing no. of present days in database
                        }
                        else{
                            //Not changing no. of present days
                        }
                    }
                });
                chk2.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent eE) {
                        if(eE.getStateChange()==1){
                            //Code for increasing no. of present days in database
                        }
                        else{
                            //Not changing no. of present days
                        }
                    }
                });
                f.dispose();
            }

        });

    }
}

class ManageLeave {
    private JLabel l1, l2, l3;
    private JButton b1, b2, b3;
    private JFrame f;
    private JTextField f1;
    ManageLeave(){
        f = new JFrame("Manage Leave");
        b3 = new JButton("Show total Allowed leave");
        l1 = new JLabel();
        b1 =new JButton("Show total Leave taken");
        l2 = new JLabel();
        l3 = new JLabel("Enter how many leave can be granted:");
        f1 = new JTextField(20);
        b2 = new JButton("Grant");


        
        f.add(b3); f.add(l1);
        f.add(b1); f.add(l2);
        f.add(l3); f.add(f1);
        f.add(b2);

        f.setSize(400, 600);
        f.setVisible(true);
        f.setLayout(new FlowLayout());

        b3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    l1.setText("15");
                }
            }
        });
        b1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    l2.setText("Total leave taken.");
                }
            }
        });
        b2.setActionCommand("if l2.getText()<l1.getText()");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //activate grant button
                f.dispose();
            }
        });
    }
}

class ChangePasswordF {
    private JButton b1;
    private JTextField f1, f2, f3;
    private JLabel l1, l2, l3;
    private JFrame f;

    ChangePasswordF() {
        f = new JFrame("Change Password");
        f1 = new JTextField(40);
        f2 = new JTextField(40);
        f3 = new JTextField(40);
        l1 = new JLabel("Enter Old Password");
        l2 = new JLabel("Enter new Password");
        l3 = new JLabel("ReEnter new Password");
        b1 = new JButton("Confirm");
        f.add(l1);
        f.add(f1);
        f.add(l2);
        f.add(f2);
        f.add(l3);
        f.add(f3);
        f.add(b1);
        f.setSize(400, 600);
        f.setLayout(new GridLayout(6, 2, 10, 10));
        f.setVisible(true);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
    }
}


/**         Student Section         **/

class StudentLogin implements ActionListener{
    private JLabel l1, l2, l3;
    private JTextField t1, t2;
    private JFrame f;
    private JButton b;
    StudentLogin(){
        f = new JFrame("Student Login page");
        f.setLayout(new GridLayout(8, 1, 5, 5));
        f.setSize(400, 600);
        f.setVisible(true);
        l1 = new JLabel("Student User Id:");
        l2 = new JLabel("Student password:");
        t1 = new JTextField(20);
        l3 = new JLabel("sahil");
        t2 = new JTextField(20);
        b = new JButton("submit");
        f.add(l1); f.add(t1);
        f.add(l2); f.add(t2);
        f.add(b);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        f.dispose();
        StudentFacility stdFasc = new StudentFacility();
    }
}

class StudentFacility implements ActionListener{
    private JButton b1, b2, b3, b4, b5;
    private JFrame f;
    private JLabel l;
    StudentFacility(){
        f = new JFrame("STUDENT facility");
        f.setVisible(true);
        f.setSize(400, 600);
        f.setLayout(new GridLayout(8, 1, 5, 5));
        l = new JLabel("select facility from following options: ");
        b1 = new JButton("Manage Account");
        b2 = new JButton("Make Complain");
        b3 = new JButton("Apply for Leave");
        b4 = new JButton("Attendance Report");
        b5 = new JButton("Change Password");
        f.add(l);
        f.add(b1); f.add(b2); f.add(b3); f.add(b4); f.add(b5);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e){
        f.dispose();
        if(e.getSource()==b1){
            ManageAccount mngAct = new ManageAccount();
        }
        else if(e.getSource()==b2){
            MakeComplain mkCmpln = new MakeComplain();
        }
        else if(e.getSource()==b3){
            ApplyForLeave leave = new ApplyForLeave();
        }
        else if(e.getSource()==b4){
            AttendanceReport atr = new AttendanceReport();
        }
        else if(e.getSource()==b5){
            ChangePassword chP = new ChangePassword();
        }
    }
}

class ManageAccount implements ActionListener{
    private JButton b1, b2, b3;
    private JTextField f3, f2;
    private JLabel l2, l3;
    private JFrame f;
    ManageAccount(){
        f = new JFrame("Manage Account: student");
        b1 = new JButton("Sign Out");
        b2 = new JButton("confirm");
        b3 = new JButton("OK");
        l2 = new JLabel("change your user id");
        l3 = new JLabel("Add Bio");
        f2 = new JTextField(200);
        f3 = new JTextField(200);
        l2.setBounds(20, 10, 380, 50);
        f2.setBounds(20, 80, 180, 50);
        b2.setBounds(220, 80,100, 50 );
        l3.setBounds(20, 180, 380, 50);
        f3.setBounds(20, 250, 180, 50);
        b3.setBounds(220, 250, 100, 50);
        b1.setBounds(140,400, 100, 50);

        f.setSize(400, 600);
        f.setLayout(null);
        f.setVisible(true);

        f.add(l2); f.add(f2); f.add(b2);
        f.add(l3); f.add(f3); f.add(b3);
        f.add(b1);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        f.dispose();
    }


}

class MakeComplain implements ActionListener{
    private JTextArea A;
    private JLabel l1, l2;
    private JButton b1, b2, b3;
    private JFrame f;
    MakeComplain(){
        f = new JFrame("Complain Page");
        l1 = new JLabel("Write Your complain here:");
        A = new JTextArea(20, 40);
        A.setSize(300, 400);
        l2 = new JLabel("To whom do you want to complain?");
        b1 = new JButton("H warden");
        b2 = new JButton("ADMIN");
        b3 = new JButton("FACULTY");
        f.add(l1); f.add(A);
        f.add(l2);
        f.add(b1);
        f.add(b2);
        f.add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        f.setSize(400, 600);
        f.setVisible(true);
        f.setLayout(new FlowLayout());
    }
    public void actionPerformed(ActionEvent e){
        f.dispose();
    }
}

class ApplyForLeave{
    private JFrame f;
    private JLabel l1, l2, l3;
    private JTextField f1, f2, f3;
    private JButton b;
    ApplyForLeave(){
        f = new JFrame("Leave Request");
        l1 = new JLabel("Write Reason:");
        l2 = new JLabel("No. of Days:");
        l3 = new JLabel("Returning Date:");
        f1 = new JTextField(250);
        f2 = new JTextField(20);
        f3 = new JTextField(20);
        b = new JButton("Request");

        f.add(l1); f.add(f1);
        f.add(l2); f.add(f2);
        f.add(l3); f.add(f3);
        f.add(b);

        f.setLayout(new GridLayout(6, 4, 7, 7));
        f.setSize(200, 200);
        f.setVisible(true);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
    }

}

class AttendanceReport implements ActionListener{
    private JButton b1, b2, b3;
    private JFrame f;
    AttendanceReport(){
        f = new JFrame("Attendance Report");

        b1= new JButton("Total working days");
        b2 = new JButton("Total present days");
        b3 = new JButton("Total absent days");

        f.add(b1); f.add(b2); f.add(b3);

        f.setSize(400, 600);
        f.setVisible(true);
        f.setLayout((new GridLayout(9, 2, 12, 12)));

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        f.dispose();
    }
}

class ChangePassword{
    private JButton b1;
    private JTextField f1, f2, f3;
    private JLabel l1, l2, l3;
    private JFrame f;
    ChangePassword(){
        f = new JFrame("Change Password");
        f1 = new JTextField(30);
        f2 = new JTextField(30);
        f3 = new JTextField(30);
        l1 = new JLabel("Enter Old Password");
        l2 = new JLabel("Enter New Password");
        l3 = new JLabel("Reenter new Password");
        b1 = new JButton("Confirm");
        f.add(l1);
        f.add(f1);
        f.add(l2);
        f.add(f2);
        f.add(l3);
        f.add(f3);
        f.add(b1);
        f.setSize(400, 600);
        f.setLayout(new GridLayout(8, 4, 12, 12));
        f.setVisible(true);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
    }
}


/**         Select User         **/

class select implements ActionListener{
    private JLabel l;
    private JButton b1, b2, b3;
    private JFrame f;
    select(){
        l = new JLabel("select one option");
        b1 = new JButton("STUDENT ZONE");
        b2 = new JButton("FACULTY ZONE");
        b3 = new JButton("ADMIN ZONE");
        f = new JFrame("Select User");
        f.setVisible(true);
        f.setSize(400, 600);
        f.setLayout(new GridLayout(10, 10, 8, 8));
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        f.add(l); f.add(b1); f.add(b2); f.add(b3);
    }
    public void actionPerformed(ActionEvent e){
        f.dispose();
        if(e.getSource()==b1) {
            StudentLogin stdLogIn = new StudentLogin();
        }
        else if(e.getSource()==b2){
            FacultyLogin fl = new FacultyLogin();
        }else if(e.getSource()==b3){
            AdminLogin al = new AdminLogin();
        }
    }
}

/**         Main Section          **/

public class Attendance{
    public static void main(String[] args) {
        select s1 = new select();
    }
}


