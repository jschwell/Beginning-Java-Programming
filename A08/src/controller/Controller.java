/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import model.Pet;
import model.Customer;
import model.ListData;
import view.Registration;

/**
 *
 * @author Joleen Schwellenbach
 */
public class Controller {
    //Local instances
    private Registration view = null;
    private final Pet myPet = new Pet();
    
    public Controller(Registration view) {
        this.view = view;
        this.view.addMyListener(new MyButtonListener());
        // Call fillComboBoxes to fill all combo boxes on load
        fillComboBoxes();
    }
    
    private void fillComboBoxes(){   
        // Fill in phone type combo box
        for(String item : ListData.getPhoneTypes()){
            view.setPhoneTypeItem(item);
        }
        // Fill in month combo box
        for(String item : ListData.getMonths()){
            view.setMonthItem(item);
        }
        // Fill in year combo box
        for(int item : ListData.getYears()){
            view.setYearItem(item);
        }
    }
    
    private boolean checkCustomerData(){
        //Declare variables
        boolean isValid = true;
        String name = view.getCusNameText();
        String phone = view.getPhoneText();
        StringBuilder sb = new StringBuilder();
        
        // Remove hyphens from phone text field
        phone = Validator.replaceCharacters(phone);
        
        //Check if the name text field does not have text
        if (!Validator.hasText(name)){
            isValid = false;
            sb.append("Please enter your name.\n");
            view.getCusNameTextField().requestFocusInWindow();
        }
        
        //Check if the phone text field does not have text
        if (!Validator.hasText(phone)){
            isValid = false;
            sb.append("Please enter your phone number.");
            if (Validator.hasText(name)){
                // Set focus to the phone text field only if the name text
                // field is filled in
                view.getPhoneTextField().requestFocusInWindow();
            }
        }
        
        //Check if there is any error message and display it
        if (Validator.hasText(sb.toString())){
            view.displayMessage(sb.toString(),"Registration Error");
        }
        
        return isValid;
    }
    
    private boolean checkPetData(){
        //Declare and initialize variables
        boolean isValid = true;
        String name = view.getPetNameText();
        String breed = view.getBreedText();
        int month = view.getMonthNumber();
        int year = view.getYear();
        LocalDate today = LocalDate.now();
        int todayYear = today.getYear();
        int todayMonth = today.getMonthValue();
        
        StringBuilder sb = new StringBuilder();
        
        //Check if the name text field does not have text
        if (!Validator.hasText(name)){
            isValid = false;
            sb.append("Please enter the name of your pet.\n");
            view.getPetNameTextField().requestFocusInWindow();
        }
        
        //Check if the breed text field does not have text
        if (!Validator.hasText(breed)){
            isValid = false;
            sb.append("Please enter the breed of your pet.\n");
            if (Validator.hasText(name)){
                // Set focus to the breed text field only if the name text
                // field is filled in
                view.getBreedTextField().requestFocusInWindow();
            }
        }
        
        //Check if date is not current      
        if (year == todayYear){
            if (month > todayMonth){
                isValid = false;
                sb.append("The kennel cough date is in the future.");
            }
        }    
        else if (year == (todayYear - 2)){
            if (month < todayMonth){
                isValid = false;
                sb.append("The kennel cough date is over 2 years old.");
            }
        }
                
        //Check if there is any error message and display it
        if (Validator.hasText(sb.toString())){
            view.displayMessage(sb.toString(),"Registration Error");
        }
        
        return isValid;
    }
    
    private void getCustomer(){
        if (checkCustomerData()){
            //Declare variables
            String name = view.getCusNameText();
            String phone = view.getPhoneText();
            String phoneType = view.getPhoneType();
            
            //Create Customer object
            Customer customer = new Customer(name, phone, phoneType);
            
            //Send Customer object to getPet
            getPet(customer);
        }
    }
    
    private void getPet(Customer customer){
        if (checkPetData()){
            //Declare and initialize variables
            String name = view.getPetNameText().trim();
            String breed = view.getBreedText().trim();
            String gender = "";
            String kennelCough;

            //Assign gender based on radio button selected
            if (view.getFemaleRadioButton().isSelected()){
                gender = "Female";
            }
            else {
                gender = "Male";
            }

            //Get month and year for kennel cough date
            kennelCough = view.getMonth() + " " + view.getYear();

            //Add new pet object to the ArrayList
            myPet.addPet(new Pet(name, breed, gender, kennelCough, customer));

            //Display results
            displayPets();
        }
    }
       
    private void displayPets(){
        //Create new StringBuilder object
        StringBuilder sb = new StringBuilder();
        
        //Append all pets with separators
        sb.append(view.getCusNameText());
        sb.append(" is the owner of the next ");
        sb.append(myPet.getPetList().size());
        sb.append(" pet(s) listed below.");
        sb.append("\n");
        sb.append("\n");
        for (Pet newPet : myPet.getPetList()) {
            sb.append("Name: ");
            sb.append(newPet.getPetName());
            sb.append("\n");
            sb.append("Breed: ");
            sb.append(newPet.getBreed());
            sb.append("\n");
            sb.append("Gender: ");
            sb.append(newPet.getGender());
            sb.append("\n");
            sb.append("Last Kennel Cough: ");
            sb.append(newPet.getKennelCough());
            if (myPet.getPetList().size() > 1) {
                sb.append("\n");
                sb.append("****************************************");
                sb.append("\n");
            } 
        }
        
        //Display message in text area
        view.setMessage(sb.toString());
        
        //Reset text fields
        resetPetFields();
    }
    
    private void resetPetFields(){
        //Clear text fields
        view.setPetNameText("");
        view.setBreedText("");
        
        //Reset radio buttons
        view.getMaleRadioButton().setSelected(true);
        
        //Reset month and year's selected index back to 0
        view.setMonth(0);
        view.setYear(0);
        
        //Reset focus to first text field
        view.getPetNameTextField().requestFocusInWindow();
    }
    
    private void resetData(){
        //Clear Customer text fields
        view.setCusNameText("");
        view.setPhoneText("");
        
        //Reset phone type's selected index back to 0
        view.setPhoneType(0);
        
        //Clear text area
        view.setMessage("");
        
        //Clear ArrayList
        myPet.getPetList().clear();
        
        //Reset text fields
        resetPetFields();
        
        //Reset focus to first text field
        view.getCusNameTextField().requestFocusInWindow();
    }
        
    class MyButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(view.getSubmitButton())){
                //When the submit button is clicked, call the method getCustomer
                getCustomer();
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
