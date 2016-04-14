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
public class Customer {
    //Instance variables
   private String name;
   private int age;
   private String creditCard;
   
   public Customer(){
      //No argument constructor
   }
   public Customer(String name, int age, String creditCard) {
        //Constructor
        this.name = name;
        this.age = age;
        this.creditCard = creditCard;
   }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
    
    public String getLastFour() {
       String lastFour = creditCard.substring(creditCard.length()-4);
       return lastFour;
}
   
}
