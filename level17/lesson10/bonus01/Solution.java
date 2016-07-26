package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String ADD_HUMAN = "-c";
        String UPDATE_HUMAN = "-u";
        String DELETE_HUMAN = "-d";
        String SHOW_INFORMATION_HUMAN = "-i";
        String MALE = "м";

        if (args[0].equals(ADD_HUMAN)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date = simpleDateFormat.parse(args[3]);
            Person person = args[2].equals(MALE) ? Person.createMale(args[1], date) : Person.createFemale(args[1], date);
            allPeople.add(person);
            System.out.println(allPeople.size() - 1);
        } else if (args[0].equals(UPDATE_HUMAN)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date = simpleDateFormat.parse(args[4]);
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(args[2]);
            person.setSex(args[3].equals(MALE) ? Sex.MALE : Sex.FEMALE);
            person.setBirthDay(date);
        } else if (args[0].equals(DELETE_HUMAN)) {
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
        } else if (args[0].equals(SHOW_INFORMATION_HUMAN)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Person person = allPeople.get(Integer.parseInt(args[1]));
            System.out.println(person.getName() + " " + ((person.getSex() == Sex.MALE) ? "м" : "ж") + " " + simpleDateFormat.format(person.getBirthDay()));
        }
    }
}
