/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import view.View;
import model.Customer;
import model.Car;

/**
 *
 * @author Joleen Schwellenbach
 */
public class Controller {
    //Local instance of the user interface
    private View view = null;

    public Controller(View view) {
        //Set the local instance of the user interface 
        //equal to the incoming user interface
        this.view = view;
        //Call the method getUserInfo
        getUserInfo();
    }

    private void getUserInfo() {
        //Declare and initialize variables
        String name = "";
        int age = 0;
        String creditCard = "";
        String userInput = "";
        
        //Ask end-user for name
        userInput = view.getUserInput("Please enter your name as it appears on your credit card.", 
                "Reliable Car Rental", JOptionPane.QUESTION_MESSAGE);
        //Check if the cancel button or x was clicked
        checkIfNull(userInput);
        //Validate user input and save it into the variable name
        name = validateName(userInput);
        
        //Ask end-user for age
        userInput = view.getUserInput("Please enter your age as a whole numeric value.", 
                "Reliable Car Rental", JOptionPane.QUESTION_MESSAGE);
        //Check if the cancel button or x was clicked
        checkIfNull(userInput);
        //Validate user input and save it into the variable age
        age = validateAge(userInput);
        
        //Ask end-user for their credit card
        userInput = view.getUserInput("Please enter your credit card number.", 
                "Reliable Car Rental", JOptionPane.QUESTION_MESSAGE);
        //Check if the cancel button or x was clicked
        checkIfNull(userInput);
        //Validate user input and save it into the variable creditCard
        creditCard = validateCard(userInput);
        
        //Create a new customer object
        Customer newCustomer = new Customer(name, age, creditCard);
        
        //Call displayResults
        displayResults(newCustomer);
    }
    
    private String validateName(String userInput) {
        //Check if userInput is alphabetic
        while(!Validator.isAlphabetic(userInput)){
            userInput = view.getUserInput("Please enter a valid name.", 
                    "Message Dialog: Non-alphabetic Name", JOptionPane.ERROR_MESSAGE);
            //Check if the cancel button or x was clicked
            checkIfNull(userInput);
        }
        return userInput;
    }
    
    private int validateAge(String userInput) {
        //Check if userInput is a whole number
        while(!Validator.isPositiveWholeNumber(userInput)){
            userInput = view.getUserInput("Please enter a valid age.", 
                    "Message Dialog: Invalid Age", JOptionPane.ERROR_MESSAGE);
            //Check if the cancel button or x was clicked
            checkIfNull(userInput);
        }
        //Check if userInput is outside of the required age range and if so, end the program
        if (Integer.parseInt(userInput) < 25 || Integer.parseInt(userInput) > 79){
            //Call the method displayMessage which is in the JOption class
            view.displayMessage("Your age is not between 25 and 79. \n"
                    + "You can not rent a car.", 
                    "Message Dialog: Age Not Between 25 and 79", JOptionPane.ERROR_MESSAGE);
            
            //Stop the program
            System.exit(0);
        }
        return Integer.parseInt(userInput);
    }
    
    private String validateCard(String userInput) {
        //Check if userInput is a valid credit card number
        while(!Validator.isValidCreditCard(userInput)){
            userInput = view.getUserInput("Please enter a valid credit card.", 
                    "Message Dialog: Invalid Credit Card", JOptionPane.ERROR_MESSAGE);
            //Check if the cancel button or x was clicked
            checkIfNull(userInput);
        }
        return userInput;
    }
    
    private void checkIfNull(String userInput) {
        if(userInput == null){
            //Call the method displayMessage which is in the JOption class
            view.displayMessage("I see you clicked the cancel button or \'X\'. \n"
                    + "You must not want to rent a car.", 
                    "Message Dialog: Cancel or X", JOptionPane.ERROR_MESSAGE);
            
            //Stop the program
            System.exit(0);
        }
    }
    
    private void displayResults(Customer c) {
        //Build a string using literals and the info from the Customer object
        StringBuilder sb = new StringBuilder();
        sb.append("Hello, ");
        sb.append(c.getName());
        sb.append(".\n");
        sb.append("Your credit card ending in ****");
        sb.append(c.getLastFour());
        sb.append(" has been approved.");
        
        view.displayMessage(sb.toString(), "Reliable Car Rental", 
               JOptionPane.INFORMATION_MESSAGE); 
    } 
}
