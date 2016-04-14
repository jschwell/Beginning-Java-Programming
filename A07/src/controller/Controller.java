/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Pet;
import view.View;

/**
 *
 * @author Joleen Schwellenbach
 */
public class Controller {
    //Local instances
    private View view = null;
    private final Pet myPet = new Pet();
    
    public Controller(View view) {
        this.view = view;
        this.view.addMyListener(new MyButtonListener());
    }
    
    private boolean checkData(){
        //Declare and initialize variables
        boolean isValid = true;
        String name = view.getNameText();
        String breed = view.getBreedText();
        StringBuilder sb = new StringBuilder();
        
        //Check if the name text field does not have text
        if (!Validator.hasText(name)){
            isValid = false;
            sb.append("Please enter the name of your pet.\n");
            view.getNameTextField().requestFocusInWindow();
        }
        
        //Check if the breed text field does not have text
        if (!Validator.hasText(breed)){
            isValid = false;
            sb.append("Please enter the breed of your pet.");
            if (Validator.hasText(name)){
                // Set focus to the breed text field only if the name text
                // field is filled in
                view.getBreedTextField().requestFocusInWindow();
            }
        }
        
        //Check if there is any error message and display it
        if (Validator.hasText(sb.toString())){
            view.displayMessage(sb.toString(),"Registration Error");
        } else {
        }
        
        return isValid;
    }
    
    private void getPet(){
        //Declare and initialize variables
        String name = view.getNameText().trim();
        String breed = view.getBreedText().trim();
        String gender = "";
        
        //Assign gender based on radio button selected
        if (view.getFemaleRadioButton().isSelected()){
            gender = "Female";
        }
        else {
            gender = "Male";
        }
        
        //Add new pet object to the ArrayList
        myPet.addPet(new Pet(name, breed, gender));
        
        //Call displayPet
        displayPet();
    }
    
    private void displayPet(){
        //Create new StringBuilder object
        StringBuilder sb = new StringBuilder();
        
        //If ArrayList has more than 1 object, append all pets with separators
        if (myPet.getPetList().size() > 1) {
            for (Pet newPet : myPet.getPetList()) {
                sb.append("Name: ");
                sb.append(newPet.getName());
                sb.append("\n");
                sb.append("Breed: ");
                sb.append(newPet.getBreed());
                sb.append("\n");
                sb.append("Gender: ");
                sb.append(newPet.getGender());
                sb.append("\n");
                sb.append("********************");
                sb.append("\n");
            }
        } 
        else { //Append the one pet with thank you message
            sb.append("Thanks for registering your pet.");
            for (Pet newPet : myPet.getPetList()) {
                sb.append("\n");
                sb.append("Name: ");
                sb.append(newPet.getName());
                sb.append("\n");
                sb.append("Breed: ");
                sb.append(newPet.getBreed());
                sb.append("\n");
                sb.append("Gender: ");
                sb.append(newPet.getGender());
            }
        }
        
        //Display message in text area
        view.setMessage(sb.toString());
        
        //Reset text fields
        resetFields();
    }
    
    private void resetFields(){
        //Clear text fields
        view.setNameText("");
        view.setBreedText("");
        
        //Reset radio buttons
        view.getMaleRadioButton().setSelected(true);
        
        //Reset focus to first text field
        view.getNameTextField().requestFocusInWindow();
    }
    
    private void resetData(){
        //Clear text area
        view.setMessage("");
        
        //Clear ArrayList
        myPet.getPetList().clear();
        
        //Reset text fields
        resetFields();
    }
        
    class MyButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(view.getSubmitButton())){
                //When submit button is clicked, validate the form data
                //then call the method getPet
                if (checkData()){
                    getPet();
                }
            }
            else if(e.getSource().equals(view.getResetButton())){
                //When reset button is clicked, call the method resetData
                resetData();
            }
            else {
                //Display that an error occurred
                view.displayMessage("A serious error has occurred.","Error");
            }
        }
    }//end inner class
}//end of class Controller
