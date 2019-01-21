/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Grzegorz
 */
public class TipCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the number of people");
        int n = reader.nextInt();
        System.out.println("Enter the number of the tips (money)");
        double m = reader.nextDouble();

        double totalHours = 0;

        ArrayList<Person> people = new ArrayList<Person>();

        for (int i = 0; i < n; i++) {
            System.out.println("Name");
            String name = reader.next();
            System.out.println("Hours");
            double hours = reader.nextDouble();
            people.add(new Person(name, hours));
            totalHours = totalHours + hours;
            System.out.println();
        }
        double moneyPerHour = m / totalHours;

        //people.forEach(lstitem->System.out.println(lstitem.getHours()));
        System.out.println("Total Hours: " + totalHours);
        System.out.println("Money per hour: " + moneyPerHour);
        System.out.println();

        for (Person p : people) {
            double earnings = moneyPerHour * p.getHours();
            System.out.println(p.getName() + "'s tips = " + earnings);
            System.out.println();
        }
    }

}
