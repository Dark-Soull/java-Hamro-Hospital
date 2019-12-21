package com.nitesh;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changePassword extends JFrame implements ActionListener {
    private adminAction aa = new adminAction();
    private JPanel panel = new JPanel();
    private JLabel oldL = new JLabel("Old Password: ");
    private JLabel newL = new JLabel("New Password:");
    private JLabel retyp = new JLabel("Re-Type :");
    private JPasswordField oldp = new JPasswordField();
    private JPasswordField newp = new JPasswordField();
    private JPasswordField repass = new JPasswordField();
    private JButton Submit = new JButton("Change");
    private JButton Cancel = new JButton("Cancel");
    private String Who=null;
    private String id=null;
    private String pass=null;
    private admin ad;
    private login log=new login();

    public changePassword(admin ad,String who,String usr,String pass) {
        super("Change Password");
        this.Who= who;
        this.id=usr;
        this.pass=pass;
        this.ad=ad;

        this.setSize(500, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        panel.setLayout(null);

        oldL.setBounds(40, 20, 150, 30);
        oldL.setFont(theme.FONT_INPUT);
        panel.add(oldL);

        oldp.setBounds(160, 20, 280, 30);
        oldp.setFont(theme.FONT_INPUT);
        panel.add(oldp);

        newL.setBounds(38, 70, 150, 30);
        newL.setFont(theme.FONT_INPUT);
        panel.add(newL);

        newp.setBounds(160, 70, 280, 30);
        newp.setFont(theme.FONT_INPUT);
        panel.add(newp);

        retyp.setBounds(40, 120, 150, 30);
        retyp.setFont(theme.FONT_INPUT);
        panel.add(retyp);

        repass.setBounds(160, 120, 280, 30);
        repass.setFont(theme.FONT_INPUT);
        panel.add(repass);

        Submit.setBounds(90, 170, theme.back_width, 30);
        Submit.setFont(theme.FONT_BUTTON);
        Submit.setBackground(theme.BACKGROUND_BUTTON);
        Submit.setForeground(theme.COLOR_BUTTON);
        Submit.addActionListener(this);
        panel.add(Submit);

        Cancel.setBounds(300, 170, theme.back_width, 30);
        Cancel.setFont(theme.FONT_BUTTON);
        Cancel.setBackground(theme.BACKGROUND_BUTTON);
        Cancel.setForeground(theme.COLOR_BUTTON);
        Cancel.addActionListener(this);
        panel.add(Cancel);
        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(Submit)) {
            if (pass.equals(oldp.getText())){
            if (newp.getText().equals(repass.getText())) {
                if (Who == "admin"&&!newp.getText().isEmpty()) {
                    aa.changePassword(this, newp.getText(),id,oldp.getText());
                    ad.setVisible(false);
                    log.setVisible(true);
                }
            } else {JOptionPane.showMessageDialog(null,"Password didn't match!");
            }
        }
            else{JOptionPane.showMessageDialog(null,"Old Password didn't match!");}
        }
        else if (ae.getSource().equals(Cancel)) {
            this.setVisible(false);
        }
        else {}
    }
}
