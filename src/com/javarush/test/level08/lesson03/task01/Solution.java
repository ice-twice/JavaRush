package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashSet<String> strings = new HashSet<>();
        strings.add("арбуз");
        strings.add("банан");
        strings.add("вишня");
        strings.add("груша");
        strings.add("дыня");
        strings.add("ежевика");
        strings.add("жень-шень");
        strings.add("земляника");
        strings.add("ирис");
        strings.add("картофель");
        for (String s : strings) {
            System.out.println(s);
        }

    }
}
