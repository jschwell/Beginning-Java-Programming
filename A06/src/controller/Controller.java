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
    //Local instance of the user interface
    private View view = null;
    
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
        
        //Check if the name text field is empty
        if (name.equals("")){
            isValid = false;
            sb.append("Please enter a name.\n");
            view.getNameTextField().requestFocusInWindow();
        }
        
        //Check if the breed text field is empty
        if (breed.equals("")){
            isValid = false;
            sb.append("Please enter a breed.");
            if (!name.equals("")){
                // Set focus to the breed text field only if the name text
                // field is filled in
                view.getBreedTextField().requestFocusInWindow();
            }
        }
        
        //Check if there is any error message and display it
        if (!sb.toString().equals("")){
            view.displayMessage(sb.toString(),"Registration Error");
        }
        
        return isValid;
    }
    
    private void getPet(){
        //Declare and initialize variables
        String name = view.getNameText();
        String breed = view.getBreedText();
        String gender = "";
        
        //Assign gender based on radio button selected
        if (view.getFemaleRadioButton().isSelected()){
            gender = "Female";
        }
        else {
            gender = "Male";
        }
        
        //Create pet object
        Pet pet = new Pet(name, breed, gender);
        
        //Call displayPet
        displayPet(pet);
    }
    
    private void displayPet(Pet pet){
        //Create new StringBuilder object
        StringBuilder sb = new StringBuilder();
        
        //Append pet data to StringBuilder
        sb.append("Thanks for registering your pet.");
        sb.append("\n");
        sb.append("Name: ");
        sb.append(pet.getName());
        sb.append("\n");
        sb.append("Breed: ");
        sb.append(pet.getBreed());
        sb.append("\n");
        sb.append("Gender: ");
        sb.append(pet.getGender());
        
        //Display message in text area
        view.setMessage(sb.toString());
    }
    
    private void resetData(){
        //Clear text fields
        view.setNameText("");
        view.setBreedText("");
        
        //Reset radio buttons
        view.getMaleRadioButton().setSelected(true);
        
        //Clear text area
        view.setMessage("");
        
        //Reset focus to first text field
        view.getNameTextField().requestFocusInWindow();
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
