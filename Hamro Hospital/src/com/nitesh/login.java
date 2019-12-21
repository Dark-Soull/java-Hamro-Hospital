package com.nitesh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener{

    private signup sign=new signup();
     private  JPanel panel=new JPanel();
     private ImageIcon img=new ImageIcon("/root/IdeaProjects/hamro hospital 1/pic/login.png");
     private JLabel background=new JLabel("",img,JLabel.CENTER);

     //login lables
    private JLabel username=new JLabel("Username:");
    private JLabel password=new JLabel("Password:");
    private JTextField usr=new JTextField();
    private JPasswordField pass=new JPasswordField();
    private JButton login=new JButton("Login");
    private JButton b=new JButton("Signup");

     public login() {
         this.setSize(theme.frame_width, theme.frame_height);
         this.setResizable(false);
         this.setLayout(null);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setLocationRelativeTo(null);

         panel.setLayout(null);
         panel.setBounds(600, 300, 520, 400);
         panel.setVisible(true);
         panel.setOpaque(false);
         this.add(panel);

         background.setBounds(0, 0, 1200, 800);
         this.add(background);

         username.setBounds(20, 60, 200, 30);
         username.setFont(new Font("TimesRoman", Font.BOLD, 30));
         username.setOpaque(false);
         panel.add(username);
         password.setBounds(25, 150, 200, 30);
         password.setFont(new Font("TimesRoman", Font.BOLD, 30));
         panel.add(password);
         usr.setBounds(210, 60, 250, 30);
         usr.setOpaque(false);
         usr.setFont(new Font("TimesRoman", Font.BOLD, 20));
         panel.add(usr);
         pass.setBounds(210, 150, 250, 30);
         pass.setOpaque(false);
         pass.setFont(new Font("TimesRoman", Font.BOLD, 20));
         panel.add(pass);
         login.setBounds(70, 240, 170, 40);
         login.setFont(new Font("TimesRoman", Font.BOLD, 30));
         login.setBackground(Color.PINK);
         login.addActionListener(this);
         panel.add(login);
         b.setBounds(280, 240, 170, 40);
         b.setFont(new Font("TimesRoman", Font.BOLD, 30));
         b.setBackground(Color.PINK);
         b.addActionListener(this);
         panel.add(b);

     }
        public void actionPerformed(ActionEvent e) {

            String user=usr.getText();
            String passs=pass.getText();
            Connection connection = null;
            Statement st = null;
            ResultSet rs = null;
          if (e.getSource().equals(b)){
             sign.display();
             this.setVisible(false);

          }
          if (e.getSource().equals(login)){

              try {
                  Class.forName("com.mysql.jdbc.Driver");
                  connection = DriverManager.getConnection(database.host, database.user, database.pass);

                  st = connection.createStatement();
                  rs = st.executeQuery("Select username,password,status from login where username='" + user + "' and password='" + passs + "'");

                  if (rs.next()) {
                      String u=rs.getString("username");
                      String p=rs.getString("password");
                      int s = rs.getInt("status");

                      if (u.equals(user) && p.equals(passs)) {

                          if (s == 0) {
                          user us=new user(user,passs);
                          us.setVisible(true);
                          this.setVisible(false);
                          System.out.println("login");

                      } else if (s == 1) {
                          doctor doc=new doctor(user,passs);
                          doc.setVisible(true);
                          this.setVisible(false);
                          System.out.println("login");
                      } else if (s == 2) {
                          admin ad=new admin(user,passs);
                          ad.setVisible(true);
                          this.setVisible(false);
                          System.out.println("login");
                      }
                  }
              }
                  else {
                      JOptionPane.showMessageDialog(b, "Wrong Username & Password");
                  }
              } catch(SQLException | ClassNotFoundException sqlException){
                  sqlException.printStackTrace();
              }
              finally {
                  try {
                      if(rs!=null)
                          rs.close();

                      if(st!=null)
                          st.close();

                      if(connection!=null)
                          connection.close();
                  }
                  catch(Exception ex) {}
              }
          }

        }
}
