package com.nitesh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class signup {
    private JFrame frame=new JFrame();
    private JPanel title=new JPanel();
    private JPanel content=new JPanel();


    //label for signup
    private JLabel l1=new JLabel("Full Name:");
    private JLabel l2=new JLabel("Username:");
    private JLabel l3=new JLabel("Password:");
    private JLabel l4=new JLabel("Re-Type:");
    private JLabel l5=new JLabel("Contact No.:");
    private JLabel l6=new JLabel("Email:");

    //text fields for signup
    private JTextField t1=new JTextField();
    private JTextField t2=new JTextField();
    private JPasswordField t3=new JPasswordField();
    private JPasswordField t4=new JPasswordField();
    private JTextField t5=new JTextField("+977");
    private JTextField t6=new JTextField();
    private JTextField t7=new JTextField();

    private JButton button=new JButton("submit");
    private JButton back=new JButton(theme.back);

    String result;

    public void display(){
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(theme.frame_width, theme.frame_height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        //label bounds
        content.setBounds(590,170,590,550);
        content.setVisible(true);
        content.setOpaque(false);
        content.setLayout(null);
        frame.add(content);

        theme.background.setBounds(theme.title_x,theme.background_y,theme.frame_width,theme.frame_height);
        frame.add(theme.background);

        //panel for title
        title.setBounds(theme.title_x, theme.title_y, theme.title_width, theme.title_height);
        title.setBackground(theme.title_color);
        title.setLayout(null);
        frame.add(title);
        back.setBounds(theme.back_x,theme.back_y,theme.back_width,theme.back_height);
        back.addActionListener(new click());
        back.setActionCommand("back");
        title.add(back);
        theme.name.setBounds(theme.name_x,theme.name_y,theme.name_width,theme.name_height);
        theme.name.setFont(new Font("Times_New_Roman",Font.BOLD,68));
        theme.name.setForeground(theme.panel_color);
        title.add(theme.name);

        l1.setBounds(10,10,200,30);
        l1.setFont(new Font("TimesRoman",Font.BOLD,30));
        t1.setBounds(230,10,300,30);
        t1.setFont(new Font("TimesRoman", Font.BOLD, 20));
        t1.setOpaque(false);
        content.add(t1);
        content.add(l1);
        l2.setBounds(10,80,200,30);
        l2.setFont(theme.label_font);
        t2.setBounds(230,80,300,30);
        t2.setFont(new Font("TimesRoman", Font.BOLD, 20));
        t2.setOpaque(false);
        content.add(t2);
        content.add(l2);
        l3.setBounds(10,150,200,30);
        l3.setFont(new Font("TimesRoman",Font.BOLD,30));
        t3.setBounds(230,150,300,30);
        t3.setFont(new Font("TimesRoman", Font.BOLD, 20));
        t3.setOpaque(false);
        content.add(t3);
        content.add(l3);
        l4.setBounds(10,220,250,40);
        l4.setFont(new Font("TimesRoman",Font.BOLD,30));
        t4.setBounds(230,220,300,30);
        t4.setFont(new Font("TimesRoman", Font.BOLD, 20));
        t4.setOpaque(false);
        content.add(t4);
        content.add(l4);
        l5.setBounds(10,290,250,40);
        l5.setFont(new Font("TimesRoman",Font.BOLD,30));
        t5.setBounds(230,290,50,30);
        t5.setEnabled(false);
        t5.setFont(new Font("TimesRoman", Font.BOLD, 15));
        t5.setDisabledTextColor(Color.BLACK);
        t6.setBounds(280,290,250,30);
        t6.setOpaque(false);
        t6.setFont(new Font("TimesRoman", Font.BOLD, 20));
        content.add(t6);
        content.add(t5);
        content.add(l5);
        l6.setBounds(10,360,250,40);
        l6.setFont(new Font("TimesRoman",Font.BOLD,30));
        t7.setBounds(230,360,300,30);
        t7.setFont(new Font("TimesRoman", Font.BOLD, 20));
        t7.setOpaque(false);
        content.add(t7);
        content.add(l6);

        button.setBounds(190,450,200,40);
        button.setFont(new Font("TimesRoman",Font.BOLD,30));
        button.setBackground(theme.title_color);
        button.setForeground(theme.panel_color);
        button.addActionListener(new click());
        button.setActionCommand("Register");
        content.add(button);


    }
    private class click implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            signupAction a = new signupAction();
            String name = t1.getText();
            String user = t2.getText();
            String password = t3.getText();
            String re_p = t4.getText();
            String contact = t6.getText();
            String email = t7.getText();

            Connection connection = null;
            PreparedStatement st = null;
            ResultSet rs = null;
            if (e.getActionCommand().equals("Register")) {

                try {
                    a.setMemberName(name);
                    a.setMemberUserid(user);
                    a.setMemberPassword(password);
                    a.setMemberPass(re_p);
                    a.setMemberContact(contact);
                    a.setMemberEmail(email);

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connection = DriverManager.getConnection(database.host, database.user, database.pass);
                        st = connection.prepareStatement("SELECT `username` FROM login WHERE `username`='" + user + "';");
                        rs = st.executeQuery();
                        if (rs.next()) {
                            result = rs.getString("username");
                        }
                    } catch (Exception ex) {
                    }
                    if (result != user) {
                        a.submit();
                    } else {
                        JOptionPane.showMessageDialog(null, "Username Already Used!");
                    }

                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
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

        else if(e.getActionCommand().equals("back")){
            login log=new login();
            log.setVisible(true);
            frame.setVisible(false);
            }

        }
    }
}
