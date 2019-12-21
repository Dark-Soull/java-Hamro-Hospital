package com.nitesh;

import javax.swing.*;
import java.sql.*;

public class signupAction {
    private String userid=null;
    private String name=null;
    private String password=null;
    private String contact=null;
    private String email=null;
    private String re_p=null;
    private String result = null;


    public void setMemberName(String name){
        if (!name.isEmpty()) {
            this.name=name;
        }else{
            throw new IllegalArgumentException("Please Enter Name!");
            }
    }

    public void setMemberUserid(String username){
        if (!username.isEmpty()){
            this.userid=username;
        }
        else{
             throw new IllegalArgumentException( "Please Enter Username!");}
    }

    public void setMemberPassword(String password){
        if (!password.isEmpty()){
            this.password=password;
        }
        else {
            throw new IllegalArgumentException("Please Enter Password!");}
    }

    public void setMemberPass(String re_p){
        if (!re_p.isEmpty()){this.re_p=re_p;}
        else{
            throw new IllegalArgumentException("Please Re-Enter Password!");}
    }

    public void setMemberContact(String contact){
        if (!contact.isEmpty()){
            this.contact=contact;
        }
        else {
            throw new IllegalArgumentException("Please Enter Contact No.!");}
    }

    public void setMemberEmail(String email){
        if (!email.isEmpty()){
            this.email=email;
        }
        else{
            throw new IllegalArgumentException("Please Enter Email!");}
    }

    /*public void getMemberid() {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(database.host, database.user, database.pass);
            st = connection.prepareStatement("SELECT `username` FROM login WHERE `username`='" + userid + "';");
            rs = st.executeQuery();
            if (rs.next()) {
                result = rs.getString("username");
            }
        } catch (Exception ex) {}
    }*/
    public void submit() {
        if (!password.isEmpty() && !userid.isEmpty() && !name.isEmpty() && !contact.isEmpty() && !email.isEmpty()) {
        if (re_p.equals(password)) {
            String query = "INSERT INTO `members` VALUES ('" + name + "','" + userid + "','+977" + contact + "','" + email + "');";
            String query1 = "INSERT INTO `login` VALUES ('" + userid + "','" + password + "',0);";
            Connection connection1 = null;
            PreparedStatement st1 = null;
            PreparedStatement st2 = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection1 = DriverManager.getConnection(database.host, database.user, database.pass);
                st1 = connection1.prepareStatement(query);
                st1.execute();
                st2 = connection1.prepareStatement(query1);
                st2.execute();
                JOptionPane.showMessageDialog(null, "Submitted");
            } catch (Exception ex) {
            }
            finally {
                try {
                    if(st1!=null)
                        st1.close();

                    if(st2!=null)
                        st2.close();

                    if(connection1!=null)
                        connection1.close();
                }
                catch(Exception ex) {}
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Password didn't match !");
        }
        }
    }
}
