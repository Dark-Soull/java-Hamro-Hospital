package com.nitesh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class setting extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JButton b1 =new JButton("Edit Profile");
    private JButton b2 =new JButton("Change Password");
    private JButton b3 =new JButton("Delete Account");

    public setting(){
        super("Setting");
        this.setSize(300, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        panel.setLayout(null);
        panel.setBackground(theme.title_color);

        b1.setBounds(-5, 20, 250, 30);
        b1.setForeground(theme.panel_color);
        b1.setFont(new Font("TimesRoman",Font.BOLD,25));
        b1.setBackground(null);
        b1.setFocusPainted(false);
        b1.setMargin(new Insets(0, 0, 0, 0));
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.addActionListener(this);
        panel.add(b1);

        b2.setBounds(35, 70, 250, 30);
        b2.setForeground(theme.panel_color);
        b2.setFont(new Font("TimesRoman",Font.BOLD,25));
        b2.setBackground(null);
        b2.setFocusPainted(false);
        b2.setMargin(new Insets(0, 0, 0, 0));
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.addActionListener(this);
        panel.add(b2);

        b3.setBounds(20, 120, 250, 30);
        b3.setForeground(theme.panel_color);
        b3.setFont(new Font("TimesRoman",Font.BOLD,25));
        b3.setBackground(null);
        b3.setFocusPainted(false);
        b3.setMargin(new Insets(0, 0, 0, 0));
        b3.setBorder(BorderFactory.createEmptyBorder());
        b3.addActionListener(this);
        panel.add(b3);
        this.add(panel);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals("b1")){System.out.println("done1");}
        else if (e.getSource().equals("b2")){System.out.println("done2");}
        else if (e.getSource().equals("b3")){System.out.println("done3");}

    }
}
