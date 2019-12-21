package com.nitesh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class userAction {

    public static String find_name(String user) {
        String name = null;
        String query = "SELECT `name` FROM `members` WHERE username='"+user+"'" ;
        Connection con = null;
        Statement st = null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(database.host, database.user, database.pass);
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                name = rs.getString("name");
                System.out.println(name);
            }
        } catch (Exception ex) {System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(rs!=null)
                    rs.close();

                if(st!=null)
                    st.close();

                if(con!=null)
                    con.close();
            }
            catch(Exception ex) {}
        }
        return name;
    }
}
