/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.JOption;

/**
 *
 * @author Joleen Schwellenbach
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run(){
                //create the Controller object and pass it a new instance
                //of the JOption() object.
                Controller controller = new Controller(new JOption());
            }
        });
    }
}
