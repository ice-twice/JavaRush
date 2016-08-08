package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consoleStream);

        String[] strings = byteArrayOutputStream.toString().split("\\n");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
            if (i % 2 != 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }

        /*StringBuilder stringBuilder = new StringBuilder();
        boolean isFirst = false;
        for (int i = 0; i < byteArrayOutputStream.toByteArray().length; i++) {
            stringBuilder.append((char) byteArrayOutputStream.toByteArray()[i]);
            if (byteArrayOutputStream.toByteArray()[i] == 10) {
                if (isFirst) {
                    stringBuilder.append("JavaRush - курсы Java онлайн").append(System.getProperty("line.separator"));
                }
                isFirst = !isFirst;
            }
        }
        System.out.println(stringBuilder.toString());*/
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
