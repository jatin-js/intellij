package studentapp.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import studentapp.dal.Entity.Student;
import studentapp.dal.daoimpl.StudentDaoImpl;

public class StudentJFrame extends JFrame {

	private JPanel contentPane;
	private List<String> cols;
    private List<Student> rows;
    private StudentDaoImpl studentDaoImpl;
    private SimpleTableModel<Student> simpleTableModel;
    private JTable jTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentJFrame frame = new StudentJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentJFrame() {
		setTitle("\u5B66\u751F\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cols=new ArrayList<>();
        cols.add("ID");
        cols.add("����");
        cols.add("����");
        cols.add("��ַ");
        cols.add("ѧ��");
        cols.add("��ϵ��ʽ");       
        studentDaoImpl=new StudentDaoImpl();
        rows=studentDaoImpl.getAllStudent();
        simpleTableModel=new SimpleTableModel<Student>(cols,rows);
    	
        JLabel jLabel = new JLabel();
        jLabel.setText("ѧ������ϵͳ");      
        jLabel.setFont(new Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);        
        getContentPane().add(jLabel, BorderLayout.PAGE_START);
        JScrollPane jScrollPane = new JScrollPane();
        jTable = new JTable();
/*        
        jTable.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
*/
        jTable.setModel(simpleTableModel);
        jScrollPane.setViewportView(jTable);
        getContentPane().add(jScrollPane, BorderLayout.CENTER);
            
        JLabel jLabel2 = new JLabel();
        jLabel2.setText("״̬��");
        getContentPane().add(jLabel2, BorderLayout.PAGE_END);
        
        JMenuBar jMenuBar = new JMenuBar();
        
        JMenu file = new JMenu();
        file.setText("�ļ�");
        	JMenuItem saveAsXML = new JMenuItem();
        		saveAsXML.setText("��ΪXML");
        		file.add(saveAsXML);
        	JMenuItem saveAsExcel = new JMenuItem();
        		saveAsExcel.setText("��ΪExcel");
        	file.add(saveAsExcel);
        	JMenuItem quit = new JMenuItem();
        	quit.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			quitActionPerformed(e);
        		}
        	});
        		quit.setText("�˳�");
        		file.add(quit);
        jMenuBar.add(file);
        
        JMenu edit = new JMenu();
        	edit.setText("�༭");
        	edit.setToolTipText("");
        	JMenuItem insert = new JMenuItem();
        		insert.setText("����");
        		insert.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        insertStudentActionPerformed(evt);
                    }
                });
        	edit.add(insert);
        
        	JMenuItem update = new JMenuItem();
        		update.setText("����");
        		update.addActionListener(new java.awt.event.ActionListener() {
        			public void actionPerformed(ActionEvent evt) {
        				updateStudentActionPerformed(evt);
        			}
        		});
        	edit.add(update);
        
        	JMenuItem refresh = new JMenuItem();
        	refresh.setText("ˢ��");
        	refresh.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent evt) {
        			refreshActionPerformed(evt);
        		}
        	});
        	edit.add(refresh);
        jMenuBar.add(edit);
        
        JMenuItem delete = new JMenuItem("\u5220\u9664");
        delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		delStudentActionPerformed(e);
        	}
        });
        edit.add(delete);
        
        JMenu query = new javax.swing.JMenu();
        	query.setText("��ѯ");
        	JMenuItem queryAll = new JMenuItem();
        	queryAll.setText("��ѯ����");
        	queryAll.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					queryAllActionPerformed(e);
				}
			});
        query.add(queryAll);
        
        	JMenu classifiedQuery = new JMenu();
        	classifiedQuery.setText("�����ѯ");
        		JMenuItem queryBySno = new JMenuItem();
        		queryBySno.setText("��ѧ�Ų�");
        	classifiedQuery.add(queryBySno);
        		JMenuItem queryByName = new JMenuItem();
        		queryByName.setText("��������");
        	classifiedQuery.add(queryByName);       
        		JMenuItem queryByID = new JMenuItem();
        		queryByID.setText("��id��");
                queryByID.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        queryByIDActionPerformed(evt);
                    }
                });
            classifiedQuery.add(queryByID);
        query.add(classifiedQuery);
        jMenuBar.add(query);
        
        JMenu statistics = new JMenu();
        statistics.setText("ͳ��");
        jMenuBar.add(statistics);
        
        JMenu help = new JMenu();
        help.setText("����");
        	JMenuItem about = new JMenuItem();
        	about.setText("����");
        	about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        help.add(about);         
        jMenuBar.add(help);         
        setJMenuBar(jMenuBar);  
        pack();
	}
	
	 private void aboutActionPerformed(ActionEvent evt) {
		 JOptionPane.showMessageDialog(this, "ѧ������ϵͳ ver 1.2.0\n\n  ��Ȩ��yzb","����ѧ������ϵͳ",JOptionPane.PLAIN_MESSAGE);
	 }

	 private void insertStudentActionPerformed(ActionEvent evt) {
	     new InsertStudentJFrame().setVisible(true);
	 }

	 private void refreshActionPerformed(ActionEvent evt) {
		 rows=studentDaoImpl.getAllStudent();
	     simpleTableModel.setRows(rows);
	     simpleTableModel.fireTableDataChanged();
	 }
	 
	 private void updateStudentActionPerformed(ActionEvent evt) {
		 try {
			 	rows=studentDaoImpl.getAllStudent();
			 	simpleTableModel.setRows(rows);
				Student student=rows.get(jTable.getSelectedRow());
				new UpdateStudentJFrame(student).setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "��ѡ�о���ѧ��...","����ѧ����Ϣ",JOptionPane.ERROR_MESSAGE);
		}    	             
	 }
	 
	 private void queryByIDActionPerformed(ActionEvent evt) {
		 rows=studentDaoImpl.getAllStudent();
	     simpleTableModel.setRows(rows);
		 new QueryByIDJFrame(jTable).setVisible(true);
	 }
	 
	 private void delStudentActionPerformed(ActionEvent actionEvent) {		 
	     try {
			Student student=rows.get(jTable.getSelectedRow());
			studentDaoImpl.delStudentbyID(student.getSid());
			rows=studentDaoImpl.getAllStudent();
		    simpleTableModel.setRows(rows);
		    simpleTableModel.fireTableDataChanged();
		    JOptionPane.showMessageDialog(this, "ɾ���ɹ�", "ɾ��ѧ����Ϣ", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "ɾ��ʧ��!��ѡ��ѧ��...", "ɾ��ѧ����Ϣ", JOptionPane.ERROR_MESSAGE);
		}
	 }
	 
	 private void quitActionPerformed(ActionEvent actionEvent) {
		 this.setVisible(false);
		 this.dispose();
	 }
	 private void queryAllActionPerformed(ActionEvent actionEvent) {
		 rows=studentDaoImpl.getAllStudent();
	     simpleTableModel.setRows(rows);
	     simpleTableModel.fireTableDataChanged();
	 }
}
