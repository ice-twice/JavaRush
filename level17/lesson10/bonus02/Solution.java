package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public volatile static List<Person> allPeople = Collections.synchronizedList(new ArrayList<Person>());

    static {
        synchronized (allPeople) {
            allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
            allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
        }
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String ADD_HUMAN = "-c";
        String UPDATE_HUMAN = "-u";
        String DELETE_HUMAN = "-d";
        String SHOW_INFORMATION_HUMAN = "-i";
        String MALE = "м";

        // String parameter = "-c Миронов м 15/04/1990 Плов ж 23/08/1995 Чпок м 19/12/2000";
        // String parameter = "-u 0 Миронов м 15/04/1990 1 Плов ж 23/08/1995";
        // String parameter = "-d 0 1";
        // String parameter = "-i 0 1";
        // args = parameter.split(" ");

        synchronized (allPeople) {
            if (args[0].equals(ADD_HUMAN)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                for (int i = 1; i < args.length; i += 3) {
                    Date date = simpleDateFormat.parse(args[i + 2]);
                    Person person = args[i + 1].equals(MALE) ? Person.createMale(args[i], date) : Person.createFemale(args[i], date);
                    allPeople.add(person);
                    System.out.println(allPeople.size() - 1);
                }
            } else if (args[0].equals(UPDATE_HUMAN)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                for (int i = 1; i < args.length; i += 4) {
                    Date date = simpleDateFormat.parse(args[i + 3]);
                    Person person = allPeople.get(Integer.parseInt(args[i]));
                    person.setName(args[i + 1]);
                    person.setSex(args[i + 2].equals(MALE) ? Sex.MALE : Sex.FEMALE);
                    person.setBirthDay(date);
                }
            } else if (args[0].equals(DELETE_HUMAN)) {
                for (int i = 1; i < args.length; i++) {
                    allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                }
            } else if (args[0].equals(SHOW_INFORMATION_HUMAN)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                for (int i = 1; i < args.length; i++) {
                    Person person = allPeople.get(Integer.parseInt(args[i]));
                    System.out.println(person.getName() + " " + ((person.getSex() == Sex.MALE) ? "м" : "ж") + " " + simpleDateFormat.format(person.getBirthDay()));
                }
            }
        }
        /*for (Person person : allPeople) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(person.getName() + " " + ((person.getSex() == Sex.MALE) ? "м" : "ж") + " " + simpleDateFormat.format(person.getBirthDay()));
        }*/
    }
}
