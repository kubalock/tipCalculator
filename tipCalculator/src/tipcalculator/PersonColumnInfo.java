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
public class PersonColumnInfo {
    
    private String heading;
    private int minWidth;
    private String property;
    
    public String getHeading() {
        return heading;
    }
    
    public PersonColumnInfo setHeading(String heding){
        this.heading = heading;
        return this;
    }
    
    public int getMinWidth() {
        return minWidth;
    }
    
    public PersonColumnInfo setMinWidth(int minWidth) {
        this.minWidth = minWidth;
        return this;
    }
    
    public String getProperty() {
        return property;
    }
    
    public PersonColumnInfo setProperty(String property) {
        this.property = property;
        return this;
    }
}
