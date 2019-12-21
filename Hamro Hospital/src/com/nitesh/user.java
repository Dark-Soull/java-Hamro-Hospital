package com.nitesh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class user extends JFrame implements ActionListener{
    private JPanel panel=new JPanel();
    private JPanel content=new JPanel();
    private JMenu menu=new JMenu();


    private JMenuItem menuItem1=new JMenuItem("Profile");
    private JMenuItem menuItem2=new JMenuItem("Setting");
    private JMenuItem menuItem3=new JMenuItem("Log Out");
    private String userid=null;
    private String Oldpass=null;

    public user(String usr,String pass){
        this.userid=usr;
        this.Oldpass=pass;
        this.setSize(theme.frame_width, theme.frame_height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //title panel
        panel.setLayout(null);
        panel.setBackground(theme.BACKGROUND_BUTTON);
        panel.setVisible(true);
        panel.setBounds(theme.title_x,theme.title_y,theme.title_width, theme.title_height);
        this.add(panel);

        theme.name.setBounds(theme.name_x,theme.name_y,theme.name_width,theme.name_height);
        theme.name.setFont(new Font("Times_New_Roman",Font.BOLD,68));
        theme.name.setForeground(theme.panel_color);
        panel.add(theme.name);

        content.setBounds(590,170,590,550);
        content.setVisible(true);
        content.setOpaque(false);
        content.setBackground(Color.RED);
        content.setLayout(null);
       // this.add(content);

        theme.background.setBounds(theme.title_x, theme.background_y, theme.frame_width, theme.frame_height);
        //this.add(theme.background);

        //menue work
        theme.mb.setBounds(theme.mb_x,theme.mb_y,theme.mb_w_h,theme.mb_w_h);
        theme.mb.setBackground(Color.WHITE);
        panel.add(theme.mb);
       theme.mb.add(menu);
       menu.setIcon(theme.menuIcon);
        menuItem1.setFont(new Font("TimesRoman",Font.BOLD,15));
        menuItem1.addActionListener(this);
        menuItem1.setActionCommand("item1");
        menuItem2.setFont(new Font("TimesRoman",Font.BOLD,15));
        menuItem2.addActionListener(this);
        menuItem2.setActionCommand("item2");
        menuItem3.setFont(new Font("TimesRoman",Font.BOLD,15));
        menuItem3.addActionListener(this);
        menuItem3.setActionCommand("item3");
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);

    }

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("item1"))
            {userProfile up=new userProfile(userid,Oldpass);
                up.setVisible(true);
                this.setVisible(false);}

            else if (e.getActionCommand().equals("item2")) {
                setting set=new setting();
                set.setVisible(true);
            }

            else if (e.getActionCommand().equals("item3"))
            {
                login log=new login();
                log.setVisible(true);
                this.setVisible(false);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        }

}
