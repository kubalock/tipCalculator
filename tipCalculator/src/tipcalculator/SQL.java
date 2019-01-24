/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

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
            String USERNAME = "root";
            String PASSWORD = "pass123";
            String CONN_STRING
                    = "jdbc:mysql://localhost:3306/mysql";

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

            //stmt = conn.createStatement();
            System.out.println("Connected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<Person> getPerson() {
        Set<Person> people = new HashSet();
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Person");
            while (rs.next()) {
                String name = rs.getString("Name");
                String hours = rs.getString("Hours");
                if (hours == "0") {
                    hours = "";
                }
                String money = rs.getString("Money");
                if (money == "0") {
                    money = "";
                }
                Person person = new Person(name, hours, money);
                people.add(person);

            }
            stmt.close();
        } catch (Exception e) {

        }
        return people;
    }

    public void addPerson(String name) {
        try {
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO Person (Name, Hours, Money) VALUES ('" + name + "', '0', '0')");
            stmt.close();
        } catch (Exception e) {
        }
    }

    public void deletePerson(String name) {
        try {
            stmt = conn.createStatement();
            stmt.execute("DELETE FROM Person WHERE Name = '" + name + "'");
            stmt.close();
        } catch (Exception e) {

        }
    }

    public void editHours(String name, String hours) {
        try {
            stmt = conn.createStatement();
            stmt.execute("UPDATE Person SET Hours = '" + hours + "' WHERE Name = '" + name + "'");
            stmt.close();
        } catch (Exception e) {

        }
    }

    public String getOne(String name) {
        String hours = "0";

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM People WHERE Name = '" + name + "'");
            hours = rs.getString("Hours");

            stmt.close();
        } catch (Exception e) {

        }

        return hours;
    }
    
    public void setMoney(String name, String money) {
        try {
            stmt = conn.createStatement();
            stmt.execute("UPDATE Person SET Money = '"+money+"' WHERE Name = '"+name+"'");
            stmt.close();
        } catch (Exception e) {
            
        }
    }
}
