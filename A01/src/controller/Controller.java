/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import view.JOption;
import java.text.NumberFormat;

/**
 *
 * @author Joleen Schwellenbach
 */
public class Controller {
    
    //Local variable that is global to this class
    private JOption view = null;

    public Controller(JOption view) {
        //Save the incomming parameter named view 
        //to the local parameter named view
        this.view = view;
        //Call the method getNumber
        getNumber();
    }

    private void getNumber() {
        //Declare variables and constants
        final String message = "Please enter a number between 0 and 100.";
        final String title = "Input Dialog: Number between 0 and 100";
        String userInput;
        
        //Call the function getUserInput which is in the JOption class
        userInput = view.getUserInput(message, title, 
                JOptionPane.QUESTION_MESSAGE);
        
        //Check to see if the Cancel button or X was clicked
        if(userInput == null){
            //Call the method displayMessage which is in the JOption class
            view.displayMessage("I see you clicked the cancel button or \'X\'. \n"
                    + "You must not want to enter a number.", 
                    "Message Dialog: Cancel or X", JOptionPane.ERROR_MESSAGE);
            
            //Stop the program
            System.exit(0);
        }
        //Check if the user input is a valid number
        else{ 
            if(checkNumber(userInput)){
                //Call the method calcNumbers
                calcNumbers(userInput);
            }
            else{
                //Tell user input is invalid and start the process over
                view.displayMessage("An invalid number was entered. \n"
                    + "Please try again.", 
                    "Message Dialog: Invalid Entry", JOptionPane.ERROR_MESSAGE);
                getNumber();
            }
        }
    }

    private boolean checkNumber(String userInput) {
        //Declare variables
        boolean isValid = false;
        double userNumber = 0.0;
        
        //Check if the user input is a number
        if (userInput.matches("^[0-9\\.]+$")){
            userNumber = Double.parseDouble(userInput);
            //Check if the number is between 0 and 100
            if (userNumber < 100 && userNumber >= 0){
                isValid = true;
            }
        }
        return isValid;
    }

    private void calcNumbers(String userInput) {
        //Declare variables
        double userNumber = 0.0;
        double randomNumber = 0.0;
        double newNumber = 0.0;
        String money = "";
        String percentage = "";
        
        //Convert user input to a double
        userNumber = Double.parseDouble(userInput);
        //Generate a random number
        randomNumber = Math.random()*100;
        //Multiply the user number by the random number        
        newNumber = userNumber * randomNumber;
        //Convert newNumber to currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        money = currency.format(newNumber);
        //Convert newNumber to a percent
        NumberFormat percent = NumberFormat.getPercentInstance();
        percentage = percent.format(newNumber);
            
        //Call the method displayMessage which is in the JOption class
        view.displayMessage("Your Number: " + userInput + "\n"
            + "Random Number: " + randomNumber + "\n"
            + "Multiplied: " + newNumber + "\n"
            + "Rounded: " + Math.round(newNumber) + "\n"
            + "Max: " + Math.max(userNumber, randomNumber) + "\n"
            + "Money: " + money + "\n"
            + "Percent: " + percentage  + "\n", 
            "Message Dialog: Results", JOptionPane.INFORMATION_MESSAGE);
        
        //Stop the program
        System.exit(0);
    }
}
