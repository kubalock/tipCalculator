/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Grzegorz
 */
public class sqlStatements extends SQL {

    public Set<Person> getPerson() {

        Set<Person> people = new HashSet();

        try {
            System.out.println("Test1");
            ResultSet rs = stmt.executeQuery("SELECT * FROM Person");
            while (rs.next()) {
                String name = rs.getString("Name");
                double hours = rs.getDouble("Hours");
                double money = rs.getDouble("Money");
                Person person = new Person(name, hours, money);
                people.add(person);
                System.out.println(person.getName());
            }
            stmt.close();
            System.out.println("Test2");
        } catch (Exception e) {

        }
        System.out.println("Test3");
        return people;
        
    }
}
