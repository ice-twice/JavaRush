package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty()) {
            throw new TooShortStringException();
        } else {
            int countSpaces = string.length() - string.replace(" ", "").length();
            if (countSpaces >= 4) {
                int tempCountSpaces = 0;
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == ' ') {
                        tempCountSpaces++;
                    }
                    if (tempCountSpaces == 4) {
                        i++;
                        while (i < string.length() && string.charAt(i) != ' ') {
                            i++;
                        }
                        return string.substring(string.indexOf(" ") + 1, i);
                    }
                }
            } else {
                throw new TooShortStringException();
            }
        }
        return null;
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обученияJava."));
        System.out.println(getPartOfString(null));
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
