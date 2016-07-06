package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution {
    public static void main(String[] args) {


    }

    public static class Human {
        //напишите тут ваши переменные и конструкторы
        private boolean sex;
        private int age = 0;
        private int weight = 0;
        private int height = 0;
        private String firstName = null;
        private String lastName = null;

        public Human(boolean sex) {
            this.sex = sex;
        }

        public Human(boolean sex, int age) {
            this.sex = sex;
            this.age = age;
        }

        public Human(boolean sex, int weight, int height) {
            this.sex = sex;
            this.weight = weight;
            this.height = height;
        }

        public Human(boolean sex, String firstName) {
            this.sex = sex;
            this.firstName = firstName;
        }

        public Human(boolean sex, String firstName, String lastName) {
            this.sex = sex;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(boolean sex, int age, int weight, int height, String firstName) {
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.height = height;
            this.firstName = firstName;
        }

        public Human(boolean sex, int age, int weight, int height) {
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        public Human(boolean sex, int age, String firstName, String lastName) {
            this.sex = sex;
            this.age = age;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(boolean sex, int weight, int height, String firstName, String lastName) {
            this.sex = sex;
            this.weight = weight;
            this.height = height;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(boolean sex, int age, int weight, int height, String firstName, String lastName) {
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.height = height;
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}
