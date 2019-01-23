/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

import java.sql.*;

/**
 *
 * @author Grzegorz
 */
public class SQL {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public SQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String USERNAME = "root";
            String PASSWORD = "pass123";
            String CONN_STRING
                    = "jdbc:mysql://localhost:3306/mysql";

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
