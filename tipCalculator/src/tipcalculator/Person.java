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
    private double money;
    
    public Person() {
        
    }
    
    public Person(String Pname, double Phours, double pMoney) {
        name=Pname;
        hours=Phours;
        money=pMoney;
    }
    
    public String getName(){
        return name;
    }
    
    public double getHours(){
        return hours;
    }
        
    public Person setName(String name) {
        this.name = name;
        return this;
    }
    
    public Person setHours(double hours){
        this.hours = hours;
        return this;
    }
    
    public double getMoney() {
        return money;
    }
    
    public Person setMoney(double money) {
        this.money = money;
        return this;
    }
    
}
