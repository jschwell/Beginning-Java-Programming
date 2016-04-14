/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Joleen Schwellenbach
 */
public class Pet {
    //Instance variables
    private String name;
    private String breed;
    private String gender;

    public Pet() {
    }

    public Pet(String name, String breed, String gender) {
        this.name = name;
        this.breed = breed;
        this.gender = gender;
    }
    
    //Getters
    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getGender() {
        return gender;
    }
    
    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
