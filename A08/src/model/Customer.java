/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Joleen Schwellenbach
 */
public class Customer {
    //Instance variables
    private String customerName;
    private String customerPhone;
    private String customerPhoneType;
    private final ArrayList<Customer> customerList = new ArrayList<>(20);
    
    public Customer() {
        customerName = "";
        customerPhone = "";
        customerPhoneType = "";
    }

    public Customer(String customerName, String customerPhone, String customerPhoneType) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerPhoneType = customerPhoneType;
    }
    
    //Getters
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerPhoneType() {
        return customerPhoneType;
    }

    //Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setCustomerPhoneType(String customerPhoneType) {
        this.customerPhoneType = customerPhoneType;
    }
    
    //Create a method to add a Customer object to the ArrayList
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }
    
    //Create a function to return the ArrayList
    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    
}
