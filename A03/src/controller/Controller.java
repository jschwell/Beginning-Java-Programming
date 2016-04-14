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
        
    }
    
    private void displayResults() {
        
    }
}
