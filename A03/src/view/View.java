/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Joleen Schwellenbach
 */
public class View extends JOptionPane {
    public View(){
        this.setVisible(true);  
    }

    public void displayMessage(String message, String title, int messageType){
        //Display a message to the end-user
        JOptionPane.showMessageDialog(this, message,title, messageType);
    }
    
    public String getUserInput(String message, String title, int messageType){
        String input;
        //Set your input variable equal to what the end-user entered
        //HOWEVER, the button they clicked also matters!
        input = JOptionPane.showInputDialog(this, message,title,
                messageType);
        return input;
    }
    
    public int getConfirmation(String message, String title, 
            int option, int messageType){ 
        
        int userAnswer;
        //Set your option variable equal to the button the end-user clicks
        userAnswer = JOptionPane.showConfirmDialog(this, message,
                title, option, messageType);

        return userAnswer;   
    }
    
    public int getCustomOption(String message, String title, int defaultOption, 
            int messageType, Object[] options, String initialOption){
        
        int chosenOption;
        //Set your chosenOption variable equal to the button the end-user clicks
        chosenOption = JOptionPane.showOptionDialog(this, message, 
                title, defaultOption, messageType, null, options, initialOption); 
        
        return chosenOption;
    }
}
