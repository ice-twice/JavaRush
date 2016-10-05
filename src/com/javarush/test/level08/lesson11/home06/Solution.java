package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> children = new ArrayList<>();
        Human child1 = new Human(children, "child1", true, 10);
        Human child2 = new Human(children, "child2", false, 11);
        Human child3 = new Human(children, "child3", false, 12);
        children.add(child1);
        children.add(child2);
        children.add(child3);
        Human father = new Human(children, "father", true, 35);
        Human mother = new Human(children, "mother", false, 30);
        children.clear();
        children.add(father);
        Human grandfather1 = new Human(children, "grandfather1", true, 50);
        Human grandmother1 = new Human(children, "grandmother1", false, 50);
        children.clear();
        children.add(mother);
        Human grandfather2 = new Human(children, "grandfather2", true, 55);
        Human grandmother2 = new Human(children, "grandmother2", false, 55);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(grandfather1);
        System.out.println(grandmother1);
        System.out.println(grandfather2);
        System.out.println(grandmother2);

    }

    public static class Human {
        //напишите тут ваш код
        private String name;
        private Boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(ArrayList<Human> children, String name, Boolean sex, int age) {
            this.children = new ArrayList<>(children);
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
