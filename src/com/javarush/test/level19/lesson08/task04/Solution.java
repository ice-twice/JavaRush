package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        testString.printSomething();
        System.setOut(consoleStream);
        String outputString = byteArrayOutputStream.toString();
        String[] outputStringArray = outputString.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(outputStringArray[0]).append(" ").append(outputStringArray[1]).append(" ").append(outputStringArray[2]).append(" = ");
        switch (outputStringArray[1]) {
            case "+":
                stringBuilder.append(Integer.parseInt(outputStringArray[0]) + Integer.parseInt(outputStringArray[2]));
                break;
            case "-":
                stringBuilder.append(Integer.parseInt(outputStringArray[0]) - Integer.parseInt(outputStringArray[2]));
                break;
            case "*":
                stringBuilder.append(Integer.parseInt(outputStringArray[0]) * Integer.parseInt(outputStringArray[2]));
                break;
        }
        System.out.println(stringBuilder.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

