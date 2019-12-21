package com.nitesh;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class adminAction {

    public void changePassword(changePassword a,String newPass,String Usr,String oldPass) {
        String query = "UPDATE `login` SET `password`='" +newPass+ "' WHERE (`username`='" +Usr+ "' AND `password`='" +oldPass+ "');";
        Connection con = null;
        Statement st = null;
        System.out.println(query);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(database.host, database.user, database.pass);
            st = con.createStatement();
            int res = st.executeUpdate(query);
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Password Updated!");
                a.setVisible(false);
            }
        } catch (Exception ex) {
        } finally {
            try {
                if (st != null)
                    st.close();

                if (con != null)
                    con.close();
            } catch (Exception ex) {
            }
        }
    }
}