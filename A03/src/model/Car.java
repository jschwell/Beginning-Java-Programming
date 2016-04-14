/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Joleen Schwellenbach
 */
public class Car {
    //Instance variables
   private String type;
   private int days;
   private double cost;
   
   public Car(){
      //No argument constructor
   }
   public Car(String type, int days) {
        //Constructor
        this.type = type;
        this.days = days;
   }

    public String getType() {
        return type;
    }

    public int getDays() {
        return days;
    }

    public double getCost() {
        return cost;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDays(int days) {
        this.days = days;
    }
   
    private void calcCost(){
        
    }
}
