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
    private int petId;
    private String petName;
    private String breed;
    private String gender;
    private String kennelCough;
    private Customer customer;
    private final ArrayList<Pet> petList = new ArrayList<>();
 
    private static int numberOfPets;

    public Pet() {
        petId = ++numberOfPets;
        petName = "";
        breed = "";
        gender = "";
        kennelCough = "";
        customer = new Customer();
    }

    public Pet(String petName, String breed, String gender, String kennelCough,
            Customer customer) {
        petId = ++numberOfPets;
        this.petName = petName;
        this.breed = breed;
        this.gender = gender;
        this.kennelCough = kennelCough;
        this.customer = customer;
    }
    
    //Getters
    public int getPetId() {
        return petId;
    }
    
    public String getPetName() {
        return petName;
    }

    public String getBreed() {
        return breed;
    }

    public String getGender() {
        return gender;
    }    

    public String getKennelCough() {
        return kennelCough;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    //Setters
    public void setPetName(String petName) {
        this.petName = petName;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setKennelCough(String kennelCough) {
        this.kennelCough = kennelCough;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
