import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
class regis implements ActionListener
{
JFrame f;
JTextField t,t1,t2;
JButton b1,b2,b3;
regis()
{
f=new JFrame("Register");
f.setSize(400,400);
f.setResizable(false);
f.setLocation(700,300);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setLayout(null);
JLabel l=new JLabel("Register");
JLabel l1=new JLabel("Name");
JLabel l2=new JLabel("ID");
JLabel l3=new JLabel("Password");
t=new JTextField();
t1=new JTextField();
t2=new JTextField();
b1=new JButton("Register");
b2=new JButton("back");
l.setBounds(150,50,100,40);
l1.setBounds(50,100,100,40);
l2.setBounds(50,150,100,40);
l3.setBounds(50,200,100,40);
t.setBounds(150,100,200,40);
t1.setBounds(150,150,200,40);
t2.setBounds(150,200,200,40);
b1.setBounds(100,250,100,30);
b2.setBounds(100,300,100,30);
f.add(l);
f.add(l1);
f.add(l2);
f.add(l3);
f.add(t);
f.add(t1);
f.add(t2);
f.add(b1);
f.add(b2);
f.setVisible(true);
b1.addActionListener(this);
b2.addActionListener(this);
b1.setBackground(Color.black);
b1.setForeground(Color.white);
b2.setBackground(Color.black);
b2.setForeground(Color.white);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{ 
String s1=t.getText();
String s2=t1.getText();
String s3=t2.getText();
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
Statement stat=con.createStatement();
/*byte[] ar1=s1.getBytes();
byte[] ar2=s2.getBytes();
byte[] ar3=s3.getBytes();
s1="";
s2="";
s3="";
for(int i=0;i<ar1.length;i++)
{
 ar1[i]=(byte)(ar1[i]+10);
s1=s1+String.valueOf((char)ar1[i]);
}
for(int i=0;i<ar2.length;i++)
{
 ar2[i]=(byte)(ar2[i]+10);
s2=s2+String.valueOf((char)ar2[i]);
}
for(int i=0;i<ar3.length;i++)
{
 ar3[i]=(byte)(ar3[i]+10);
s3=s3+String.valueOf((char)ar3[i]);
}*/
stat.executeUpdate("insert into user values('"+s1+"','"+s2+"','"+s3+"')");
t.setText("");
t1.setText("");
t2.setText("");
}
catch(Exception e)
{
System.out.println(e);
}
}
if(ae.getSource()==b2)
{
f.dispose();
new Login();
}
}
public static void main(String[] arg)
{
	regis r =new regis();
}
}