/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Joleen Schwellenbach
 */
public class Pet {
    //Instance variables
    private String name;
    private String breed;
    private String gender;
    private final ArrayList<Pet> petList = new ArrayList<>();

    public Pet() {
        name = "";
        breed = "";
        gender = "";
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
    
    //Create a method to add a Pet object to the ArrayList
    public void addPet(Pet pet) {
        petList.add(pet);
    }
    
    //Create a function to return the ArrayList
    public ArrayList<Pet> getPetList() {
        return petList;
    }
}
