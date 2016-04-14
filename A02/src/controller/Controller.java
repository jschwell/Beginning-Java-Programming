/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import view.JOption;

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
        //Call the method confirmStart
        confirmStart();
    }

    private void confirmStart() {
        //Declare variables
        String message = "This program converts any inch value you enter into centimeters. " +
                         "Would you like to give it a try?";
        String title = "Confirm Dialog: Try it out?";
        int option = JOptionPane.YES_NO_OPTION;
        int messageType = JOptionPane.QUESTION_MESSAGE;
        int answer;
        
        //Call the function getConfirmation in the JOption class
        answer = view.getConfirmation(message, title, option, messageType);
                
        if(answer == JOptionPane.YES_OPTION){
            //If the user hit the yes button, call the method getUserEntries
            getUserEntries();
        }
        else if(answer == JOptionPane.NO_OPTION){
            //If the user hit the no button, call the method displayMessage in the JOption class
            view.displayMessage("Okay, maybe next time.", "Message dialog: Not feeling it today.",
                JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            //If the user hit the cancel or x button, call the method displayMessage in the JOption class
             view.displayMessage("You must have closed the confirm dialog \n"
                     + "without selecting a button.", "Message dialog: Closed Option", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void getUserEntries() {
        //Declare variables and constants
        final String message = "Please enter a number greater than zero that you want to convert into centimeters.";
        final String title = "Input Dialog: Enter a number";
        final int SIZE = 10;
        String userInput = "";
        int index = 0;
        double[] numbers = new double[SIZE];
        
        //Get the user's entries
        userInput = view.getUserInput(message, title, JOptionPane.QUESTION_MESSAGE);
        while (userInput != null && index < SIZE) {
            //Check if the number is valid by calling the function checkForNumber
            if(checkForNumber(userInput)){
                //If entry is a number, save it to the array and advance in the loop
                numbers[index] = Double.parseDouble(userInput);
                index++;
            }
            //Only ask for another number if index is less than SIZE
            if (index < SIZE) {
                userInput = view.getUserInput(message, title, JOptionPane.QUESTION_MESSAGE);
            }
        }
        
        //Check if any entries were entered
        if (index == 0) {
            //If no entries were entered, call the method displayMessage in the JOption class
            view.displayMessage("I see you clicked the cancel button or \'X\'. \n"
                    + "You must not want to enter a number.", 
                    "Message Dialog: Cancel or X", JOptionPane.ERROR_MESSAGE);
            
            //Stop the program
            System.exit(0);
        }
        else {
            //Call the method covertToCentimeters
            convertToCentimeters(numbers, index);
        }
    }
    
    private boolean checkForNumber(String userInput) {
        //Declare and initialize variables
        boolean isValid = false;
        double number = 0.0;
        
        //Check if the user input is a number and if that number is greater than 0
        try {
            number = Double.parseDouble(userInput);
            if(number > 0) {
                isValid = true;
            }
            else {
                //Display a message if the number isn't greater than 0
                view.displayMessage("Please enter a number greater than 0.", 
                    "Message Dialog: Invalid Entry", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException e) {
            //Display a message if the entry isn't a valid number
            view.displayMessage("Please enter a valid number.", 
                    "Message Dialog: Invalid Entry", JOptionPane.ERROR_MESSAGE);
        }
        return isValid;
    }
    
    private void convertToCentimeters(double[] inches, int numberOfEntries) {
        //Declare and initialize variables
        String[] conversions = new String[numberOfEntries];
        double centimeters = 0.0;
        
        //Convert all entries to centimeters
        for (int index = 0; index < numberOfEntries; index++){
            centimeters = inches[index] * 2.54;
            conversions[index] = inches[index] + " inches is " + centimeters + " centimeters.\n";
        }
        //Call the method displayResults
        displayResults(conversions);
    }
    
    private void displayResults(String[] myArray) {
        //Declare and initialize variable
        String message = "";
        
        //Concatenate the array into one message
        for (int index = 0; index < myArray.length; index++){
            message += myArray[index];
        }
        
        //Display the results
        view.displayMessage(message, "Message Dialog: Results", JOptionPane.INFORMATION_MESSAGE);
        
        //Stop the program
        System.exit(0);
    }
}
