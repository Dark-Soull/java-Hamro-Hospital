package com.nitesh;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userProfile extends JFrame implements ActionListener {

    private userAction da=new userAction();
    private user usr;

    private JPanel panel,header;
    private JLabel title;
    private JButton back;
    private String userID=null;
    private String pass=null;

    public userProfile(String usr,String pass){
        this.userID=usr;
        this.pass=pass;

        this.setSize(theme.frame_width, theme.frame_height);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(theme.panel_color);

        title = new JLabel(da.find_name(userID));
        title.setBounds(30, 40, da.find_name(userID).length()*10+250,75);
        title.setOpaque(true);
        title.setBorder(new EmptyBorder(0,20,0,0));
        title.setFont(theme.title_font);
        title.setForeground(theme.title_color);
        panel.add(title);

        header = new JPanel();
        header.setBackground(theme.title_color);
        header.setOpaque(true);
        header.setLayout(null);
        header.setBounds(0, 0, theme.frame_width, 75);
        panel.add(header);

        back=new JButton("Back");
        back.setBounds(1050, 20, theme.back_width,40);
        back.setFont(new Font("TimesRoman",Font.BOLD,22));
        back.addActionListener(this);
        back.setActionCommand("back");
        header.add(back);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("back")){
            usr=new user(userID,pass);
            usr.setVisible(true);
            this.setVisible(false);
        }
    }
}
