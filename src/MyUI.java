import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MyUI
{
	MyUI()//constructor
	{
	JFrame f1=new JFrame("Bank Management System");

	
	 JLabel l1=new JLabel("User Name");
	 JLabel l2=new JLabel("Password");
	 JTextField t1=new JTextField();
	 JTextField t2=new JTextField();
	 l1.setBounds(100, 100, 100, 40);
	 l2.setBounds(100, 200, 100, 40);
	 t1.setBounds(200, 100, 100, 40);
	 t2.setBounds(200, 200, 100, 40);
	 JButton b1=new JButton("Login");
	 b1.setBounds(150,300,70,40);
	 
	 f1.add(l1);
	 f1.add(l2);
	 f1.add(t1);
	 f1.add(t2);
	 f1.add(b1);
	 f1.setSize(400,500);
	 f1.setLayout(null);
	 f1.setVisible(true);
		 b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(t1.getText().equals("admin")&& t2.getText().equals("pass@123"))
				 {
                       mainFrame();
				 }
			}
		});
		 }
	 public void mainFrame()
	{
			JFrame f2=new JFrame();
			f2.setSize(400,500);
			f2.setLayout(null);
			f2.setVisible(true);
			JLabel l3=new JLabel("Account Manager");
			l3.setBounds(50,50,100,40);
			f2.add(l3);
			JButton b2=new JButton("Cash Deposit");
			b2.setBounds(50,100,200,40);
			f2.add(b2);
			JButton b3=new JButton("Cash Withdraw");
			b3.setBounds(50,150,200,40);
			f2.add(b3);
			JButton b4=new JButton("Close Account");
			b4.setBounds(50,200,200,40);
			f2.add(b4);
			JButton b5=new JButton("Generate Report");
			b5.setBounds(50,250,200,40);
			f2.add(b5);
			JButton b6=new JButton("Open New Account");
			b6.setBounds(50,300,200,40);
			f2.add(b6);
			JButton b7=new JButton("Manage Existing Account");
			b7.setBounds(50,350,200,40);
			f2.add(b7);
			JButton b8=new JButton("About Project");
			b8.setBounds(50,400,200,40);
			f2.add(b8);
			b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Deposit();
				}
			});
			b3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Withdraw();
				}
			});
			b4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					CloseAcc();
				}
			});
			b5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
						String[] columnNames={"accNo","name","balance","DOB","gender","account","services","address","identity","addProof","ms"};
	 					JTable table;
	 					JFrame frame1=new JFrame("Database Search Result");
	 					frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 					frame1.setLayout(new BorderLayout());
	 					DefaultTableModel model=new DefaultTableModel();
	 					model.setColumnIdentifiers(columnNames);
	 					table=new JTable();
	 					table.setModel(model);
	 					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	 					table.setFillsViewportHeight(true);
	 					JScrollPane srcoll=new JScrollPane(table);
	 					srcoll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	 					srcoll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	 					String accNo="";
	 					String name="";
	 					String balance="";
	 					String DOB="";
	 					String gender="";
	 					String account="";
	 					String services="";String address="";String identity="";String addProof="";String ms="";
	 					try
	 					{
	 						Connection con=BankDao.getConnection();
	 						PreparedStatement pst=con.prepareStatement("Select*FROM bank");
	 						ResultSet rs=pst.executeQuery();
	 						int i=0;
	 						while(rs.next())
	 						{
	 						    accNo=rs.getString(1);
	 							name= rs.getString(2);
	 							balance=rs.getString(3);
	 							DOB=rs.getString(4);
	 							gender=rs.getString(5);account=rs.getString(6);services=rs.getString(7);address=rs.getString(8);
	 							identity=rs.getString(9);addProof=rs.getString(10);ms=rs.getString(11);
	 							//System.out.println(""+name+" "+address+" "+city);
	 							model.addRow(new Object[]{accNo,name,balance,DOB,gender,account,services,address,identity,addProof,ms});
	 							i++;
	 						}
	 						if(i<1)
	 						{
	 							JOptionPane.showMessageDialog(null, "No Record Found","Error",JOptionPane.ERROR_MESSAGE);
	 						}
	 						if(i==1)
	 						{
	 							System.out.println(i+"Record Found");
	 					    }
	 						else{
	 						System.out.println(i+"Record Found");	
	 						}
	 						}
	 						catch(Exception ex)
	 						{
	 						JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
	 						}
	 					frame1.add(srcoll);
	 					frame1.setVisible(true);
	 					frame1.setSize(400,300);
				}
			});
			b6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Insert();
				}
			});
			b7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Manage();
				}
			});
			b8.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					//Project();
				}
			});
	}
	 public void Insert()
	 {
		    JFrame f3=new JFrame();
			f3.setSize(400,500);
			f3.setLayout(null);
			f3.setVisible(true);
			JLabel l3=new JLabel("New Account");
			l3.setBounds(50,50,100,40);
			f3.add(l3);
			JLabel l4=new JLabel("Name");
			l4.setBounds(50,100,100,40);
			f3.add(l4);
			JTextField t1=new JTextField();
			t1.setBounds(180,100,300,40);
			f3.add(t1);
			JLabel l5=new JLabel("Opening Ammount");
			l5.setBounds(50,150,120,40);
			f3.add(l5);
			JTextField t2=new JTextField();
			t2.setBounds(180,150,300,40);
			f3.add(t2);
			JLabel l6=new JLabel("Date of Birth");
			l6.setBounds(50,200,100,40);
			f3.add(l6);
			JTextField t3=new JTextField();
			t3.setBounds(180,200,300,40);
			f3.add(t3);
			JLabel l7=new JLabel("Gender");
			l7.setBounds(50,250,100,40);
			f3.add(l7);
			JRadioButton r1 =new JRadioButton("Male");
			r1.setBounds(180, 250, 80, 40);
			JRadioButton r2 =new JRadioButton("Female");
			r2.setBounds(270, 250, 80, 40);
			ButtonGroup bg=new ButtonGroup();
	        r1.setActionCommand("Male");
	        r2.setActionCommand("Female");
			bg.add(r1);
			bg.add(r2);
			f3.add(r2);
			f3.add(r1);
			JLabel l8=new JLabel("Maritial Status");
			l8.setBounds(50,300,100,40);
			f3.add(l8);
			JRadioButton r3 =new JRadioButton("Married");
			JRadioButton r4 =new JRadioButton("Single");
			JRadioButton r5 =new JRadioButton("Other");
			r3.setBounds(180, 300, 80, 40);
			r4.setBounds(270, 300, 80, 40);
			r5.setBounds(360, 300, 80, 40);
			ButtonGroup bg1=new ButtonGroup();
			r3.setActionCommand("Married");
			r4.setActionCommand("Single");
			r5.setActionCommand("Other");
			bg1.add(r3);
			bg1.add(r4);
			bg1.add(r5);
			f3.add(r3);
			f3.add(r4);
			f3.add(r5);
			JLabel l9=new JLabel("Type of Account");
			l9.setBounds(50,350,100,40);
			f3.add(l9);
			JRadioButton r6 =new JRadioButton("Saving");
			JRadioButton r7 =new JRadioButton("Current Account");
			r6.setBounds(180, 350, 80, 40);
			r7.setBounds(270, 350, 150, 40);
			ButtonGroup bg3=new ButtonGroup();
			r6.setActionCommand("Saving");
			r7.setActionCommand("Current Account");
			bg3.add(r6);
			bg3.add(r7);
			f3.add(r6);
			f3.add(r7);	
			JLabel l10=new JLabel("Address");
			l10.setBounds(50,400,100,40);
			f3.add(l10);
			JTextField t4=new JTextField();
			t4.setBounds(180, 400, 300, 40);
			f3.add(t4);
			JLabel l11=new JLabel("Services Required");
			l11.setBounds(50,450,170,40);
			f3.add(l11);
			JRadioButton r8 =new JRadioButton("ATM");
			JRadioButton r9 =new JRadioButton("Net Banking");
			JRadioButton r10 =new JRadioButton("Mobile Services");
			JRadioButton r11 =new JRadioButton("Cheque Book");
			r8.setBounds(180,450,50,40);
			r9.setBounds(240,450,150,40);
			r10.setBounds(400,450,150,40);
			r11.setBounds(560,450,150,40);
			ButtonGroup bg4=new ButtonGroup();
			r8.setActionCommand("ATM");
			r9.setActionCommand("Net Banking");
			r10.setActionCommand("Mobile Services");
			r11.setActionCommand("Cheque Book");
			bg4.add(r8);
			bg4.add(r9);
			bg4.add(r10);
			bg4.add(r11);
			f3.add(r8);
			f3.add(r9);
			f3.add(r10);
			f3.add(r11);
			JLabel l12=new JLabel("Identity Proof");
			l12.setBounds(50,500,200,40);
			f3.add(l12);
			String identity[]={"Adhar Card","Lisence","Pan Card"};
			JComboBox c1=new JComboBox(identity);
			c1.setBounds(180,500,200,40);
			JLabel l13=new JLabel("Address Proof");
			l13.setBounds(50,550,200,40);
			f3.add(l13);
			String addProof[]={"Adhar Card","Lisence","Pan Card","Electricity Bill","Ration Card"};
			JComboBox c2=new JComboBox(addProof);
			c2.setBounds(180,550,200,40);
			f3.add(c1);
			f3.add(c2);
			JButton b1=new JButton("Create");
			b1.setBounds(150, 650, 200, 40);
			f3.add(b1);
			b1.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent arg0) {

					String n=t1.getText().trim();
					String o=t2.getText().trim();
					String i=(String) c1.getItemAt(c1.getSelectedIndex());
					String a=(String) c2.getItemAt(c2.getSelectedIndex());
					String d=t3.getText().trim();
					String ad=t4.getText().trim();
				    String g=bg.getSelection().getActionCommand();
				    String m=bg1.getSelection().getActionCommand();
				    String t=bg3.getSelection().getActionCommand();
				    String s=bg4.getSelection().getActionCommand();
				    Bank b=new Bank(n,o,d,g,m,t,ad,s,i,a);
				    try
					{
						int x=BankDao.addCustomer(b);
						if(x>0)
						{
       						JOptionPane.showMessageDialog(f3,"Data Inserted");
							System.out.println("Data Inserted");
						}
						else
						{
							JOptionPane.showMessageDialog(f3, "Data Not Inserted");
							System.out.println("Data not Inseted");
						}
					}
					catch(ClassNotFoundException | SQLException e1)
					{
						e1.printStackTrace();
					}
					
				}
			});
	 }
	 public void Withdraw()
	 {
		    JFrame f1=new JFrame();
			f1.setSize(400,500);
			f1.setLayout(null);
			f1.setVisible(true);
			JLabel l1=new JLabel("Cash Withdraw");
			l1.setBounds(50,50,100,40);
			f1.add(l1);
			JLabel l2=new JLabel("Enter Account Number");
			l2.setBounds(50,100,200,40);
			f1.add(l2);
			JTextField t1=new JTextField();
			t1.setBounds(260,100,300,40);
			f1.add(t1);
			JButton b1=new JButton("Get Info");
			b1.setBounds(570, 100, 100, 40);
			f1.add(b1);
			JLabel l3=new JLabel("Name");
			l3.setBounds(50,150,200,40);
			f1.add(l3);
			JTextField t2=new JTextField();
			t2.setBounds(260,150,200,40);
			f1.add(t2);
			JLabel l4=new JLabel("Balance");
			l4.setBounds(470,150,200,40);
			f1.add(l4);
			JTextField t3=new JTextField();
			t3.setBounds(580,150,200,40);
			f1.add(t3);
			JLabel l5=new JLabel("Withdraw Amount");
			l5.setBounds(50,200,200,40);
			f1.add(l5);
			JTextField t4=new JTextField();
			t4.setBounds(50,250,400,40);
			f1.add(t4);
			JButton b2=new JButton("Withdraw");
			b2.setBounds(250, 300, 100, 40);
			f1.add(b2);
			t2.setEditable(false);
			t3.setEditable(false);
			b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try{
					String s1=t1.getText();
					Connection con=BankDao.getConnection();
					PreparedStatement ps=con.prepareStatement("SELECT*FROM bank WHERE accNo=?");
					ps.setString(1, s1);
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
						String s2=rs.getString(2);
						String s3=rs.getString(3);
						t2.setText(s2);
						t3.setText(s3);
						}}
					catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
				}
			});
			b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String s4=t4.getText();
					String s5=t3.getText();
					int i1=Integer.parseInt(s4);
					int i2=Integer.parseInt(s5);
					int i3=i2-i1;
					String s6=String.valueOf(i3);
					String s7=t1.getText();
					Bank b1=new Bank(s7,s6);
					try
					{
						int x=BankDao.Withdraw(b1);
						JOptionPane.showMessageDialog(f1,"Withdrawal Successful");
					}
					catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
	 }
	 public void Deposit()
	 {
		    JFrame f1=new JFrame();
			f1.setSize(400,500);
			f1.setLayout(null);
			f1.setVisible(true);
			JLabel l1=new JLabel("Cash Withdraw");
			l1.setBounds(50,50,100,40);
			f1.add(l1);
			JLabel l2=new JLabel("Enter Account Number");
			l2.setBounds(50,100,200,40);
			f1.add(l2);
			JTextField t1=new JTextField();
			t1.setBounds(260,100,300,40);
			f1.add(t1);
			JButton b1=new JButton("Get Info");
			b1.setBounds(570, 100, 100, 40);
			f1.add(b1);
			JLabel l3=new JLabel("Name");
			l3.setBounds(50,150,200,40);
			f1.add(l3);
			JTextField t2=new JTextField();
			t2.setBounds(260,150,200,40);
			f1.add(t2);
			JLabel l4=new JLabel("Balance");
			l4.setBounds(470,150,200,40);
			f1.add(l4);
			JTextField t3=new JTextField();
			t3.setBounds(580,150,200,40);
			f1.add(t3);
			JLabel l5=new JLabel("Deposit Amount");
			l5.setBounds(50,200,200,40);
			f1.add(l5);
			JTextField t4=new JTextField();
			t4.setBounds(50,250,400,40);
			f1.add(t4);
			JButton b2=new JButton("Deposit");
			b2.setBounds(250, 300, 100, 40);
			f1.add(b2);
			t2.setEditable(false);
			t3.setEditable(false);
			b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try{
					String s1=t1.getText();//account Number
					Connection con=BankDao.getConnection();
					PreparedStatement ps=con.prepareStatement("SELECT*FROM bank WHERE accNo=?");
					ps.setString(1, s1);
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
						String s2=rs.getString(2);//name from database
						String s3=rs.getString(3);//balance from database
						t2.setText(s2);//setting in name textfeild
						t3.setText(s3);//setting in account balace textfeild
						}}
					catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
			});
			b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String s4=t4.getText();
					String s5=t3.getText();
					int i1=Integer.parseInt(s4);
					int i2=Integer.parseInt(s5);
					int i3=i1+i2;
					String s6=String.valueOf(i3);
					String s7=t1.getText();
					Bank b1=new Bank(s7,s6);
					try
					{
						int x=BankDao.Withdraw(b1);
						JOptionPane.showMessageDialog(f1,"Deposit Successful");
					}
					catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
	 }
	 public void CloseAcc()
	 {
		 JFrame f1=new JFrame();
			f1.setSize(400,500);
			f1.setLayout(null);
			f1.setVisible(true);
			JLabel l1=new JLabel("Close Account");
			l1.setBounds(50,50,100,40);
			f1.add(l1);
			JLabel l2=new JLabel("Enter Account Number");
			l2.setBounds(50,100,200,40);
			f1.add(l2);
			JTextField t1=new JTextField();
			t1.setBounds(260,100,300,40);
			f1.add(t1);
			JButton b1=new JButton("Get Info");
			b1.setBounds(570, 100, 100, 40);
			f1.add(b1);
			JLabel l3=new JLabel("Name");
			l3.setBounds(50,150,200,40);
			f1.add(l3);
			JTextField t2=new JTextField();
			t2.setBounds(260,150,200,40);
			f1.add(t2);
			JLabel l4=new JLabel("Balance");
			l4.setBounds(470,150,200,40);
			f1.add(l4);
			JTextField t3=new JTextField();
			t3.setBounds(580,150,200,40);
			f1.add(t3);
			JButton b2=new JButton("Close Account");
			b2.setBounds(250, 300, 100, 40);
			f1.add(b2);
			b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try{
						String s1=t1.getText();
						Connection con=BankDao.getConnection();
						PreparedStatement ps=con.prepareStatement("SELECT*FROM bank WHERE accNo=?");
						ps.setString(1, s1);
						ResultSet rs=ps.executeQuery();
						if(rs.next()){
							String s2=rs.getString(2);
							String s3=rs.getString(3);
							t2.setText(s2);
							t3.setText(s3);
							}
						}
						catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
				}
			});
			b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String s4=t1.getText();
					try {
						Connection con=BankDao.getConnection();
						Statement st=con.createStatement();
						int c=st.executeUpdate("DELETE from bank WHERE accNo = "+s4+"");
						JOptionPane.showMessageDialog(f1,"Data Deleted");
					} catch (ClassNotFoundException | SQLException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				}
				}); 
	 }
	 public void Manage()
	 {
		 JFrame f3=new JFrame();
			f3.setSize(400,500);
			f3.setLayout(null);
			f3.setVisible(true);
			JLabel l3=new JLabel("Account Details");
			l3.setBounds(50,50,100,40);
			f3.add(l3);
			JLabel l14=new JLabel("Enter Account Number");
			l14.setBounds(200,50,200,40);
			f3.add(l14);
			JTextField acc=new JTextField();
			acc.setBounds(450,50,200,40);
			f3.add(acc);
			JButton b1=new JButton("Get Info");
			b1.setBounds(750, 50, 200, 40);
			f3.add(b1);
			JLabel l4=new JLabel("Name");
			l4.setBounds(50,100,100,40);
			f3.add(l4);
			JTextField t1=new JTextField();
			t1.setBounds(180,100,300,40);
			f3.add(t1);
			JLabel l5=new JLabel("Opening Ammount");
			l5.setBounds(50,150,120,40);
			f3.add(l5);
			JTextField t2=new JTextField();
			t2.setBounds(180,150,300,40);
			f3.add(t2);
			JLabel l6=new JLabel("Date of Birth");
			l6.setBounds(50,200,100,40);
			f3.add(l6);
			JTextField t3=new JTextField();
			t3.setBounds(180,200,300,40);
			f3.add(t3);
			JLabel l7=new JLabel("Gender");
			l7.setBounds(50,250,100,40);
			f3.add(l7);
			JRadioButton r1 =new JRadioButton("Male");
			r1.setBounds(180, 250, 80, 40);
			JRadioButton r2 =new JRadioButton("Female");
			r2.setBounds(270, 250, 80, 40);
			ButtonGroup bg=new ButtonGroup();
	        r1.setActionCommand("Male");
	        r2.setActionCommand("Female");
			bg.add(r1);
			bg.add(r2);
			f3.add(r2);
			f3.add(r1);
			JLabel l8=new JLabel("Maritial Status");
			l8.setBounds(50,300,100,40);
			f3.add(l8);
			JRadioButton r3 =new JRadioButton("Married");
			JRadioButton r4 =new JRadioButton("Single");
			JRadioButton r5 =new JRadioButton("Other");
			r3.setBounds(180, 300, 80, 40);
			r4.setBounds(270, 300, 80, 40);
			r5.setBounds(360, 300, 80, 40);
			ButtonGroup bg1=new ButtonGroup();
			r3.setActionCommand("Married");
			r4.setActionCommand("Single");
			r5.setActionCommand("Other");
			bg1.add(r3);
			bg1.add(r4);
			bg1.add(r5);
			f3.add(r3);
			f3.add(r4);
			f3.add(r5);
			JLabel l9=new JLabel("Type of Account");
			l9.setBounds(50,350,100,40);
			f3.add(l9);
			JRadioButton r6 =new JRadioButton("Saving");
			JRadioButton r7 =new JRadioButton("Current Account");
			r6.setBounds(180, 350, 80, 40);
			r7.setBounds(270, 350, 150, 40);
			ButtonGroup bg3=new ButtonGroup();
			r6.setActionCommand("Saving");
			r7.setActionCommand("Current Account");
			bg3.add(r6);
			bg3.add(r7);
			f3.add(r6);
			f3.add(r7);	
			JLabel l10=new JLabel("Address");
			l10.setBounds(50,400,100,40);
			f3.add(l10);
			JTextField t4=new JTextField();
			t4.setBounds(180, 400, 300, 40);
			f3.add(t4);
			JLabel l11=new JLabel("Services Required");
			l11.setBounds(50,450,170,40);
			f3.add(l11);
			JRadioButton r8 =new JRadioButton("ATM");
			JRadioButton r9 =new JRadioButton("Net Banking");
			JRadioButton r10 =new JRadioButton("Mobile Services");
			JRadioButton r11 =new JRadioButton("Cheque Book");
			r8.setBounds(180,450,50,40);
			r9.setBounds(240,450,150,40);
			r10.setBounds(400,450,150,40);
			r11.setBounds(560,450,150,40);
			ButtonGroup bg4=new ButtonGroup();
			r8.setActionCommand("ATM");
			r9.setActionCommand("Net Banking");
			r10.setActionCommand("Mobile Services");
			r11.setActionCommand("Cheque Book");
			bg4.add(r8);
			bg4.add(r9);
			bg4.add(r10);
			bg4.add(r11);
			f3.add(r8);
			f3.add(r9);
			f3.add(r10);
			f3.add(r11);
			JLabel l12=new JLabel("Identity Proof");
			l12.setBounds(50,500,200,40);
			f3.add(l12);
			String identity[]={"Adhar Card","Lisence","Pan Card"};
			JComboBox c1=new JComboBox(identity);
			c1.setBounds(180,500,200,40);
			JLabel l13=new JLabel("Address Proof");
			l13.setBounds(50,550,200,40);
			f3.add(l13);
			String addProof[]={"Adhar Card","Lisence","Pan Card","Electricity Bill","Ration Card"};
			JComboBox c2=new JComboBox(addProof);
			c2.setBounds(180,550,200,40);
			f3.add(c1);
			f3.add(c2);
			JButton b2=new JButton("Modify");
			b2.setBounds(150, 650, 200, 40);
			f3.add(b2);
			t1.setEditable(true);
			t2.setEditable(true);
			t3.setEditable(true);
			t4.setEditable(true);
            b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try{
						String s1=acc.getText();
						Connection con=BankDao.getConnection();
						PreparedStatement ps=con.prepareStatement("SELECT*FROM bank WHERE accNo=?");
						ps.setString(1, s1);
						ResultSet rs=ps.executeQuery();
						if(rs.next()){
							String s2=rs.getString(2);
							String s3=rs.getString(3);
							String s4=rs.getString(4);
							String s5=rs.getString(8);
							String s6=rs.getString(5);
							String s7=rs.getString(11);
							String s8=rs.getString(6);
							String s9=rs.getString(7);
							String s10=rs.getString(9);
							String s11=rs.getString(10);
							t1.setText(s2);
							t2.setText(s3);
							t3.setText(s4);
							t4.setText(s5);
							if(s6.equals("Male"))
							{
								r2.setSelected(false);
								r1.setSelected(true);
								}
							else
							{
							r1.setSelected(false);
							r2.setSelected(true);
							}
							if(s7.equals("Married"))
							{
							r3.setSelected(true);
							r4.setSelected(false);
							r5.setSelected(false);
							}
							else if(s7.equals("Single"))
							{
								r3.setSelected(false);
								r4.setSelected(true);
								r5.setSelected(false);
								}
							else
							{
								r3.setSelected(false);
								r5.setSelected(true);
								r4.setSelected(false);}
							if(s8.equals("Current Account"))
							{
								r6.setSelected(false);
								r7.setSelected(true);
								}
							else
							{
								r7.setSelected(false);
								r6.setSelected(true);
								}
							if(s9.equals("ATM"))
							{
								r8.setSelected(true);
								r9.setSelected(false);
								r10.setSelected(false);
								r11.setSelected(false);
								}
							else if(s9.equals("Net Banking"))
							{
								r9.setSelected(true);
								r8.setSelected(false);
								r10.setSelected(false);
								r11.setSelected(false);
							}
							else if(s9.equals("Mobile Services"))
							{
							r10.setSelected(true);
							r9.setSelected(false);
							r8.setSelected(false);
							r11.setSelected(false);
							}
							else
							{
							r11.setSelected(true);
							r9.setSelected(false);
							r10.setSelected(false);
							r8.setSelected(false);
							}
							if(s10.equals("Adhar Card"))
							{
								c1.setSelectedIndex(0);
							}
							else if(s10.equals("Lisence"))
							{
								c1.setSelectedIndex(1);
							}
							else
							{
								c1.setSelectedIndex(2);
							}
							if(s11.equals("Adhar Card"))
							{
								c2.setSelectedIndex(0);
							}
							else if(s11.equals("Lisence"))
							{
								c2.setSelectedIndex(1);
							}
							else if(s11.equals("Pan Card"))
							{
								c2.setSelectedIndex(2);
							}
							else if(s11.equals("Electricity Bill")){
								c2.setSelectedIndex(3);
							}
							else
							{
								c2.setSelectedIndex(4);
							}
							
						}
						}
						catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
				}
			});
            b2.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent arg0) {

					String n=t1.getText().trim();
					String o=t2.getText().trim();
					String i=(String) c1.getItemAt(c1.getSelectedIndex());
					String a=(String) c2.getItemAt(c2.getSelectedIndex());
					String d=t3.getText().trim();
					String ad=t4.getText().trim();
				    String g=bg.getSelection().getActionCommand();
				    String m=bg1.getSelection().getActionCommand();
				    String t=bg3.getSelection().getActionCommand();
				    String s=bg4.getSelection().getActionCommand();
				    String a1=acc.getText().trim();
				    Bank b=new Bank(a1,n,o,d,g,m,t,ad,s,i,a);
				    try
					{
						int x=BankDao.UpdateCustomer(b);
						if(x>0)
						{
       						JOptionPane.showMessageDialog(f3,"Data Updated");
							//System.out.println("Data Inserted");
						}
						else
						{
							JOptionPane.showMessageDialog(f3, "Data Not Updated");
							//System.out.println("Data not Inseted");
						}
					}
					catch(ClassNotFoundException | SQLException e1)
					{
						e1.printStackTrace();
					}
					
				}
			});
            
}
	 public void Project()
		{
				JFrame f1=new JFrame("");
				 f1.setSize(400,500);
				 f1.setLayout(null);
				 f1.setVisible(true);
						
		}
	  public void Report()
	 {
	 		 JButton b2=new JButton("Generate Report");
	 		 b2.setBounds(500, 100, 300, 50);
	 		// f1.add(b2);
	 		// b2.addActionListener(new ActionListener() {
	 			
	 				
	 }	      
}
  
