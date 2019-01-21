/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipcalculator;

/**
 *
 * @author Grzegorz
 */
public class Person {
    private String name;
    private double hours;
    
    public Person() {
        
    }
    
    public Person(String Pname, double Phours) {
        name=Pname;
        hours=Phours;
    }
    
    public String getName(){
        return name;
    }
    
    public double getHours(){
        return hours;
    }
    
}
