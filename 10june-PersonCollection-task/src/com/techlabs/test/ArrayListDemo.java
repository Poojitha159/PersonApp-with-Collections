

package com.techlabs.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import com.techlabs.model.Person;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<Person> person = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter name of the person: ");
            String name = scanner.next();
            System.out.println("Enter age of the person: ");
            int age = scanner.nextInt();
            System.out.println("Enter address of the person: ");
            String address = scanner.next();
            person.add(new Person(name, age, address));
        }

        details(person);

        boolean x = true;
        while (x) {
            System.out.println("1.Add at the beginning of the ArrayList\n2.Add at the end of the ArrayList\n3.Add the object at specified position\n4.Enter the position of object of which details you want\n5.Display first and last objects\n6.Exit");
            System.out.println("Enter number: ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println("Add at beginning");
                    add(person, 0, scanner);
                    System.out.println(person);
                    break;
                case 2:
                    System.out.println("Add at End");
                    add(person, person.size(), scanner);
                    System.out.println(person);
                    break;
                case 3:
                    System.out.println("Add at specified position");
                    System.out.println("Enter the position: ");
                    add(person, scanner.nextInt(), scanner);
                    System.out.println(person);
                    break;
                case 4:
                    System.out.println("Enter the position of object you want");
                    particularObjectDetails(person, scanner.nextInt());
                    break;
                case 5:
                    System.out.println("Display first and last objects");
                    firstAndLast(person);
                    break;
                case 6:
                    System.out.println("Exit app.");
                    x = false;
                    break;
            }
        }

        boolean y = true;
        while (y) {
            System.out.println("1.Update elements\n2.Remove elements\n3.Search elements\n4.Exit");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    updateObject(person, scanner);
                    break;
                case 2:
                    removeObject(person, scanner);
                    break;
                case 3:
                    searchObject(person, scanner);
                    break;
                case 4:
                    System.out.println("Exit from app");
                    y = false;
                    break;
            }
        }

        boolean z = true;

        while (z) {
            System.out.println("Traversing the Array List");
            System.out.println("1.Traverse with for loop\n2.Traverse with for each loop\n3.Clear all the elements in the ArrayList\n4.Exit");
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    forLoopTraversing(person);
                    break;
                case 2:
                    forEachTraversing(person);
                    break;
                case 3:
                    clearAll(person);
                    break;
                case 4:
                    System.out.println("Exit from app");
                    z = false;
                    break;
            }
        }
    }

    private static void clearAll(ArrayList<Person> person) {
        person.clear();
        Iterator<Person> personIterator = person.iterator();
        while (personIterator.hasNext()) {
            System.out.println(personIterator.next());
        }
        System.out.println("All the elements are removed from Array List");
    }

    private static void forEachTraversing(ArrayList<Person> person) {
        System.out.println("Traversing using for each loop");
        for (Person persons : person) {
            System.out.println(persons);
        }
    }

    private static void forLoopTraversing(ArrayList<Person> person) {
        System.out.println("Traversing using for loop");
        for (int i = 0; i < person.size(); i++) {
            System.out.println(person.get(i));
        }
    }

    private static void searchObject(ArrayList<Person> person, Scanner scanner) {
        System.out.println("Select criteria in which you want to search");
        System.out.println("1.Name\n2.Age\n3.Address\n4.Exit");
        int criteria = scanner.nextInt();
        switch (criteria) {
            case 1:
                checkName(person, scanner);
                break;
            case 2:
                checkAge(person, scanner);
                break;
            case 3:
                checkAddress(person, scanner);
                break;
            case 4:
                System.out.println("Exit from criteria");
                break;
        }
    }

    private static boolean checkAddress(ArrayList<Person> person, Scanner scanner) {
        System.out.println("Enter Address: ");
        String address = scanner.next();
        for (Person persons : person) {
            if (persons.getPersonAddress().equals(address)) {
                System.out.println("Yes, the person exists.");
                System.out.println("Index of that person is: " + (person.indexOf(persons) + 1));
                return false;
            }
        }
        System.out.println("Sorry! No such person exists in record.");
        return true;
    }

    private static boolean checkAge(ArrayList<Person> person, Scanner scanner) {
        System.out.println("Enter Age: ");
        int age = scanner.nextInt();
        for (Person persons : person) {
            if (persons.getPersonAge() == age) {
                System.out.println("Yes, the person exists");
                System.out.println("Index of that person is: " + (person.indexOf(persons) + 1));
                return false;
            }
        }
        System.out.println("Sorry! No such person exists in record.");
        return true;
    }

    private static boolean checkName(ArrayList<Person> person, Scanner scanner) {
        System.out.println("Enter name: ");
        String name = scanner.next();
        for (Person persons : person) {
            if (persons.getPersonName().equals(name)) {
                System.out.println("Yes, the person exists.");
                System.out.println("Index of that person is: " + (person.indexOf(persons) + 1));
                return false;
            }
        }
        System.out.println("Sorry! No such person exists in record.");
        return true;
    }

    private static void removeObject(ArrayList<Person> person, Scanner scanner) {
        System.out.println("Enter the position of object which you want to remove");
        int position = scanner.nextInt();
        person.remove(position - 1);

        System.out.println("Object is removed");
        System.out.println("ArrayList after removing object");

        Iterator<Person> personIterator = person.iterator();
        while (personIterator.hasNext()) {
            System.out.println(personIterator.next());
        }
    }

    private static void updateObject(ArrayList<Person> person, Scanner scanner) {
        System.out.println("Enter the position in which you want to change the object: ");
        int k = scanner.nextInt();
        System.out.println("Enter name of the person: ");
        String name = scanner.next();
        System.out.println("Enter age of the person: ");
        int age = scanner.nextInt();
        System.out.println("Enter address of the person: ");
        String address = scanner.next();

        person.set(k - 1, new Person(name, age, address));

        System.out.println("Update completed!");
        System.out.println("Updated Array List:");

        Iterator<Person> personIterator = person.iterator();
        while (personIterator.hasNext()) {
            System.out.println(personIterator.next());
        }
    }

    private static void firstAndLast(ArrayList<Person> person) {
        System.out.println(person.get(0));
        System.out.println(person.get(person.size() - 1));
    }

    private static void particularObjectDetails(ArrayList<Person> person, int position) {
        System.out.println(person.get(position - 1));
    }

    private static void add(ArrayList<Person> person, int position, Scanner scanner) {
        System.out.println("Enter name of the person: ");
        String name = scanner.next();
        System.out.println("Enter age of the person: ");
        int age = scanner.nextInt();
        System.out.println("Enter address of the person: ");
        String address = scanner.next();
        person.add(position, new Person(name, age, address));
    }

    private static void details(ArrayList<Person> person) {
        for (Person persons : person) {
            System.out.println(persons);
        }
    }
}
