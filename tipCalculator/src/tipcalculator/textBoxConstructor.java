/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

import java.awt.*;
import static java.awt.SystemColor.text;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author Grzegorz
 */
public class textBoxConstructor extends JPanel {

    static JTextField textField;

    public textBoxConstructor() {

    }

    public void addPerson() {

        JFrame f = new JFrame("Add Person");
        JButton b = new JButton("Submit");
        b.setBounds(100, 100, 140, 40);

        JLabel label = new JLabel();
        label.setText("Enter person's name");
        label.setBounds(10, 10, 100, 100);

        JLabel label2 = new JLabel();
        label2.setBounds(10, 110, 200, 100);

        JTextField textField = new JTextField();
        textField.setBounds(110, 50, 130, 30);

        int x = 350;
        int y = 460;
        f.add(label2);
        f.add(textField);
        f.add(label);
        f.add(b);
        f.setSize(300, 300);
        f.setLocation(x, y);
        f.setLayout(null);
        f.setVisible(true);

        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                SQL sql = new SQL();
                FXMLController fx = new FXMLController();

                String name = textField.getText();
                sql.addPerson(name);
                label2.setText(textField.getText() + " has been submitted.");
            }
        });

    }

    public void editHours(Person p) {

        JFrame f = new JFrame("Edit " + p.getName() + " hours");
        JButton b = new JButton("Submit");
        b.setBounds(100, 100, 140, 40);

        JLabel label = new JLabel();
        label.setText("Enter hours");
        label.setBounds(10, 10, 100, 100);

        JLabel label2 = new JLabel();
        label2.setBounds(10, 110, 200, 100);

        JTextField textField = new JTextField();
        textField.setBounds(110, 50, 130, 30);

        int x = 350;
        int y = 460;
        f.add(label2);
        f.add(textField);
        f.add(label);
        f.add(b);
        f.setSize(300, 300);
        f.setLocation(x, y);
        f.setLayout(null);
        f.setVisible(true);

        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                SQL sql = new SQL();
                String name = textField.getText();
                sql.editHours(p.getName(), textField.getText());
                f.dispose();
            }
        });

        //f.dispose();
    }

    public void splitTips() {

        JFrame f = new JFrame("Enter total money");
        JButton b = new JButton("Submit");
        b.setBounds(100, 100, 140, 40);

        JLabel label = new JLabel();
        label.setText("Money collected");
        label.setBounds(10, 10, 100, 100);

        JLabel label2 = new JLabel();
        label2.setBounds(10, 110, 200, 100);

        JTextField textField = new JTextField();
        textField.setBounds(110, 50, 130, 30);

        int x = 350;
        int y = 460;
        f.add(label2);
        f.add(textField);
        f.add(label);
        f.add(b);
        f.setSize(300, 300);
        f.setLocation(x, y);
        f.setLayout(null);
        f.setVisible(true);

        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                SQL sql = new SQL();
                Set<Person> people = new HashSet();
                double totalHours = 0;
                people = sql.getPerson();

                for (Person p : people) {
                    totalHours = totalHours + Double.valueOf(p.getHours());
                    //System.out.println(totalHours);
                }
                
                double hourWorth = Double.valueOf(textField.getText()) / totalHours;
                //System.out.println(hourWorth);
                for (Person p : people) {
                     double hour = Double.valueOf(p.getHours());
                     System.out.println(hour);
                     double money = hour * hourWorth;
                     sql.setMoney(p.getName(), String.valueOf(money));
                     //System.out.println(money);
                }
                f.dispose();
            }
        });
    }
}
