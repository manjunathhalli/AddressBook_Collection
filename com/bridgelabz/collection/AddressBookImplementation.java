package com.bridgelabz.collection;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class AddressBookImplementation implements IAddressBook {
    private static AddressBookImplementation addressBookImplementation;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Person> personList = new ArrayList<Person>();

    /**
     * Uc2: Ability to add a new contact to Address Book
     */

    @Override
    public void add() {
        System.out.println("Enter your first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter your address");
        String address = scanner.nextLine();
        System.out.println("Enter your city");
        String city = scanner.nextLine();
        System.out.println("Enter your state");
        String state = scanner.nextLine();
        System.out.println("Enter your phone");
        long mobileNo = scanner.nextLong();
        System.out.println("Enter your zip code");
        int zip = scanner.nextInt();

        Person person1 = new Person(firstName, lastName, address, city, state, mobileNo, zip);
        personList.add(person1);
        System.out.println("Contact added successfully");
    }

    public void display() {
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            System.out.println("FirstName:" + person.getFirstName() + "\n" + "LastName:" + person.getLastName() + "\n"
                    + "Adress:" + person.getAddress() + "\n" + "City:" + person.getCity() + "\n" + "State:"
                    + person.getCity() + "Phone-Number:" + person.getMobileNo() + "\n" + "Pin-code:"
                    + person.getPincode());
        }
    }

    /**
     * Uc3: Ability to edit existing contact person using their name
     */

    @Override
    public void edit(String firstName) {
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);

            System.out.println("Hi " + person.getFirstName() + " please enter your  new Address");
            String address = scanner.nextLine();
            person.setAddress(address);

            System.out.println("Hi " + person.getFirstName() + " please enter your  new city");
            String city = scanner.nextLine();
            person.setCity(city);

            System.out.println("Hi " + person.getFirstName() + " please enter your  new state");
            String state = scanner.nextLine();
            person.setState(state);

            System.out.println("Hi " + person.getFirstName() + " please enter your  new Zip Code");
            int zip = scanner.nextInt();
            person.setPincode(zip);

            System.out.println("Hi " + person.getFirstName() + " please enter your  new Phone No");
            int PhoneNo = scanner.nextInt();
            person.setMobileNo(PhoneNo);

            System.out.println("Hi " + person.getFirstName() + " you have sucessfully updated");
        }

    }

    /**
     * Uc4: Ability to delete a person using persons name
     */

    @Override
    public void delete(String name) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getFirstName().equals(name)) {
                Person person = personList.get(i);
                personList.remove(person);
            }
        }
    }

    /**
     * Uc5: Ability to add multiple person to Address Book
     */

    @Override
    public void addMultiplePerson() {
        System.out.println("Enter a person Name:");
        String firstName = scanner.nextLine();
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);

            /**
             * Uc6: Ability to add multiple adress book to the system each adress book has
             * unique name
             */

            if (personList.get(i).getFirstName().equals(firstName)) {
                System.out.println("Duplicate");
            }
        }
    }

    /**
     * Uc7: Ability to ensure there is no Duplicate Entry of the same Person in a
     * particular Address Book.
     */

    @Override
    public void searchPersonByName(String firstname) {
        List listPerson = (List) personList.stream()
                .filter(person1 -> person1.getFirstName().equalsIgnoreCase(firstname)).collect(Collectors.toList());
        personList.stream().forEach(System.out::println);
    }

    /**
     * Uc8: Ability to search person in a city or state across the multiple
     * AddressBook
     */

    @Override
    public void searchPersonByState(String firstname) {
        List listPerson = (List) personList.stream()
                .filter(person1 -> person1.getFirstName().equalsIgnoreCase(firstname)).collect(Collectors.toList());
        personList.stream().forEach(System.out::println);
    }

    /**
     * Uc9: view person by city or state
     */
    @Override
    public void viewByCity(String city) {
        List people = (List) personList.stream().filter(person1 -> person1.getFirstName().equalsIgnoreCase(city))
                .collect(Collectors.toList());

        for (Person person : personList) {
            System.out.println(person);
        }
    }

    /**
     * Uc10: count by city or state
     */

    @Override
    public void searchPersonInCity(String firstName) {
        Collection<Person> list;
        List people = (List) personList.stream().filter(person1 -> person1.getFirstName().equalsIgnoreCase(firstName))
                .collect(Collectors.toList());

        for (Person person : personList) {
            System.out.println(person.getFirstName() + "---->" + person.getCity());
        }
    }



    /**
     * Uc11: Ability to sort by firstName
     */
    @Override
    public void sortByFirstName() {
        {
            Collections.sort(personList, (name1, name2) -> name1.getFirstName().compareTo(name2.getFirstName()));
            System.out.println(personList);
        }
    }

    /**
     * Uc12: Ability to sort by ZipCode, state, city
     */

    @Override
    public void sortByZipcode() {
        {
            Collections.sort(personList, (z1, z2) -> z1.getFirstName().compareTo(z2.getFirstName()));
            System.out.println(personList);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Problem");
        AddressBookImplementation adressBookImplementation = new AddressBookImplementation() {

        };
        boolean condition = true;

        while (condition == true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(
                    "1.add" + "\n" + "2.Display" + "\n" + "3.Edit" + "\n" + "4.Delete" + "\n" + "5.Add MultiplePerson"
                            + "\n" + "6.SearchByName" + "\n" + "7.SearchByState" + "\n" + "8.viewByCity" + "\n"
                            + "9.SearchPersonInCity" + "\n" + "10.sortByFirstName" + "\n" + "11.sortByZipCode");
            Scanner option = new Scanner(System.in);

            switch (option.nextInt()) {
                case 1:
                    adressBookImplementation.add();
                    break;
                case 2:
                    adressBookImplementation.display();
                    break;
                case 3:
                    System.out.println("Enter the firstName:");
                    String firstName = scanner.nextLine();
                    adressBookImplementation.edit(firstName);
                    break;
                case 4:
                    System.out.println("Enter the Name of the person do you wants to delete");
                    String name = scanner.nextLine();
                    adressBookImplementation.delete(name);
                    break;
                case 5:
                    adressBookImplementation.addMultiplePerson();
                    break;
                case 6:
                    System.out.println("Enter a Name");
                    String firstName1 = scanner.nextLine();
                    adressBookImplementation.searchPersonByName(firstName1);
                    break;
                case 7:
                    System.out.println("Enter a name");
                    String state = scanner.nextLine();
                    addressBookImplementation.searchPersonByState(state);
                    break;
                case 8:
                    System.out.println("Enter the City");
                    String city = scanner.nextLine();
                    addressBookImplementation.viewByCity(city);
                    break;

                case 9:
                    System.out.println("Enter name");
                    String name1 = scanner.nextLine();
                    addressBookImplementation.searchPersonInCity(name1);
                    break;
                case 10:
                    addressBookImplementation.sortByfirstName();
                    break;
                case 11:
                    addressBookImplementation.sortByZipCode();
                    break;
                default:
                    System.out.println();
            }
        }
    }
}
