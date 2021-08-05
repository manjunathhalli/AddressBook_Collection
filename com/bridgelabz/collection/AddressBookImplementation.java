package com.bridgelabz.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookImplementation implements IAddressBook {

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

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Problem");
        AddressBookImplementation adressBookImplementation = new AddressBookImplementation();
        boolean condition = true;

        while (condition == true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.add" + "\n" + "2.Display" + "\n" + "3.Edit");
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
                default:
                    System.out.println();
            }
        }
    }
}
