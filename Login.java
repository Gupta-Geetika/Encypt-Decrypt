import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class Login implements ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7;
JTextField t1;
JPasswordField pt1;
JButton b1,b2,b3;
ImageIcon img1,img2;
Font f1,f2,f3;
Login()
{
f=new JFrame("login");
f.setBounds(330,100,550,560);
f.setLayout(null);
img1=new ImageIcon("iid.png");
l3=new JLabel();
l3.setBounds(90,100,30,30);
l3.setIcon(img1);
f.add(l3);
l1=new JLabel("User id");
f.add(l1);
l1.setBounds(120,100,100,30);
t1=new JTextField();
f.add(t1);
t1.setBounds(250,100,150,30);
img2=new ImageIcon("p.png");
l4=new JLabel();
l4.setBounds(90,200,30,30);
l4.setIcon(img2);
f.add(l4);
l2=new JLabel("Password");
f.add(l2);
l2.setBounds(120,200,100,30);
pt1=new JPasswordField();
f.add(pt1);
pt1.setBounds(250,200,150,30);
l5=new JLabel("Powered by:");
f.add(l5);
f2 = new Font("TimesRoman",Font.ITALIC,13);
l5.setFont(f2);
l5.setBounds(290,440,100,30);
l6=new JLabel("Sarthak,Vishal,Vasu, Virender, Yash");
f1 = new Font("TimesRoman",Font.ITALIC,13);
l6.setFont(f1);
f.add(l6);
l6.setBounds(290,460,400,30);
l7=new JLabel("Moradabad Institute of Technology");
f3 = new Font("TimesRoman",Font.ITALIC,13);
l7.setFont(f3);
f.add(l7);
l7.setBounds(290,480,300,30);
b1=new JButton("Login");
f.add(b1);
b1.setBounds(180,300,130,30);
b1.setBackground(Color.black);
b1.setForeground(Color.white);
b1.addActionListener(this);
b2=new JButton("Register");
f.add(b2);
b2.setBounds(180,350,130,30);
b2.setBackground(Color.black);
b2.setForeground(Color.white);
b2.addActionListener(this);
b3=new JButton("Back");
f.add(b3);
b3.setBounds(180,400,130,30);
b3.setBackground(Color.black);
b3.setForeground(Color.white);
b3.addActionListener(this);
f.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
   if(ae.getSource()==b1)
   {
   String s1=t1.getText();
   String s2=pt1.getText(); 
   try
    {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
Statement stat=con.createStatement();
ResultSet rs=stat.executeQuery("select * from user");
String r1="";
String r2="";
while(rs.next())
{        
r1=rs.getString("id");
r2=rs.getString("password");
/*byte[] ar1=r1.getBytes();
byte[] ar2=r2.getBytes();
r1="";
r2="";
for(int i=0;i<ar1.length;i++)
{
 ar1[i]=(byte)(ar1[i]-10);
r1=r1+String.valueOf((char)ar1[i]);
}
for(int i=0;i<ar2.length;i++)
{
 ar2[i]=(byte)(ar2[i]-10);
r2=r2+String.valueOf((char)ar2[i]);
}*/
if(r1.equals(s1) && r2.equals(s2))
{
new mmain();
f.dispose();
}
}
}
catch(Exception e)
{
System.out.println(e);
}
}
if(ae.getSource()==b2)
{
new regis();
f.dispose();
}
if(ae.getSource()==b3)
   {
	  f.dispose(); 
   }   
  }
  public static void main(String[] args)
  {
	  Login l= new Login();
}
}