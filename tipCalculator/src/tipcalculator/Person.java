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
    private String hours;
    private String money;
    
    public Person() {
        
    }
    
    public Person(String Pname, String Phours, String pMoney) {
        name=Pname;
        hours=Phours;
        money=pMoney;
    }
    
    public String getName(){
        return name;
    }
    
    public String getHours(){
        return hours;
    }
        
    public Person setName(String name) {
        this.name = name;
        return this;
    }
    
    public Person setHours(String hours){
        this.hours = hours;
        return this;
    }
    
    public String getMoney() {
        return money;
    }
    
    public Person setMoney(String money) {
        this.money = money;
        return this;
    }
    
}
