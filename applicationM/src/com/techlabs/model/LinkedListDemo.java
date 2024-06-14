package com.techlabs.model;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		
        LinkedList<Person> personList = new LinkedList<>();
        
        //Person[] p=new Person[5];
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a person");
            System.out.println("2. Insert a person at a specific position");
            System.out.println("3. Update a person's details");
            System.out.println("4. Remove a person");
            System.out.println("5. View all people");
            System.out.println("6. Search for a person");
            System.out.println("7. TO clear");
            System.out.println("8. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addPerson(personList, scanner);
                    break;
                case 2:
                    insertPersonAtPosition(personList, scanner);
                    break;
                case 3:
                    updatePerson(personList, scanner);
                    break;
                case 4:
                    removePerson(personList, scanner);
                    break;
                case 5:
                    printPersonList(personList);
                    break;
                case 6:
                    searchPerson(personList, scanner);
                    break;
                case 8:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                case 7:
                	personList.clear();
                    System.out.println("\nAfter clearing the list:");
                    System.out.println(personList);
                default:
                	/*personList.clear();
                    System.out.println("\nAfter clearing the list:");
                    System.out.println(personList);*/
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPerson(LinkedList<Person> personList, Scanner scanner) {
    	for(int i=0;i<5;i++) {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();  
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        personList.add(new Person(name, age, address));
        System.out.println("Person added successfully!");
    	}
    }

    private static void insertPersonAtPosition(LinkedList<Person> personList, Scanner scanner) {
        System.out.println("Enter position (0-based index):");
        int position = scanner.nextInt();
        scanner.nextLine(); 
        if (position < 0 || position > personList.size()) {
            System.out.println("Invalid position.");
            return;
        }
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();  
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        personList.add(position, new Person(name, age, address));
        System.out.println("Person inserted successfully at position " + position + "!");
    }

    private static void updatePerson(LinkedList<Person> personList, Scanner scanner) {
        System.out.println("Enter position (0-based index) of the person to update:");
        int position = scanner.nextInt();
        scanner.nextLine();  
        if (position < 0 || position >= personList.size()) {
            System.out.println("Invalid position.");
            return;
        }
        System.out.println("Enter new name:");
        String name = scanner.nextLine();
        System.out.println("Enter new age:");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter new address:");
        String address = scanner.nextLine();
        personList.set(position, new Person(name, age, address));
        System.out.println("Person details updated successfully!");
    }

    private static void removePerson(LinkedList<Person> personList, Scanner scanner) {
        System.out.println("Enter position (0-based index) of the person to remove:");
        int position = scanner.nextInt();
        scanner.nextLine();  
        if (position < 0 || position >= personList.size()) {
            System.out.println("Invalid position.");
            return;
        }
        personList.remove(position);
        System.out.println("Person removed successfully!");
    }

    private static void searchPerson(LinkedList<Person> personList, Scanner scanner) {
        System.out.println("Enter name of the person to search:");
        String name = scanner.nextLine();
        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            if (person.getName().equalsIgnoreCase(name)) {
                System.out.println("Person found at position " + i + ": " + person);
                return;
            }
        }
        System.out.println("Person not found.");
    }

    private static void printPersonList(LinkedList<Person> personList) {
        if (personList.isEmpty()) {
            System.out.println("No people in the list.");
            return;
        }
       
        // Traversing the LinkedList using a for-loop
        System.out.println("\nTraversing using a for-loop:");
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
        
        //using for each loop
        System.out.println("\nTraversing using a for each-loop:");
        for(Person per:personList) {
        	System.out.println(per);
        }

    }
}
