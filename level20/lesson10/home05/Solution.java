package com.javarush.test.level20.lesson10.home05;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    enum Sex {
        MALE,
        FEMALE
    }

    public static class Person implements Serializable {
        transient final String greetingString;
        String firstName;
        String lastName;
        transient String fullName;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    /*public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:\\1.txt"));
        objectOutputStream.writeObject(new Person("firstName", "lastName", "country", Sex.MALE));
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:\\1.txt"));
        Person person = (Person) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(person.firstName);
        System.out.println(person.lastName);
        System.out.println(person.fullName);
        System.out.println(person.greetingString);
        System.out.println(person.country);
        System.out.println(person.sex);
        System.out.println(person.outputStream);
        System.out.println(person.logger);
    }*/
}
