package com.bridgelabz.collection;

public interface IAddressBook {
    void add();
    void display();
    void edit(String firstName);
    void delete(String firstName);
    void addMultiplePerson();
    void searchPersonByName(String firstname);
    void searchPersonByState(String firstName);
    void viewByCity(String city);
    void searchPersonInCity(String firstName);
    void sortByfirstName();
}
