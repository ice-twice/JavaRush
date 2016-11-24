package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        boolean containNumber = false;
        boolean containLowerLetter = false;
        boolean containUpperLetter = false;

        while (true) {
            if (stringBuilder.length() == 8) {
                if (containNumber && containLowerLetter && containUpperLetter) {
                    break;
                } else {
                    stringBuilder.delete(0, stringBuilder.length());
                    containNumber = containLowerLetter = containUpperLetter = false;
                }
            }
            int asciiSymbol = (int) Math.floor(Math.random() * 122);
            if (asciiSymbol >= 48 && asciiSymbol <= 57) {
                containNumber = true;
                stringBuilder.append((char) asciiSymbol);
            } else if (asciiSymbol >= 65 && asciiSymbol <= 90) {
                containUpperLetter = true;
                stringBuilder.append((char) asciiSymbol);
            } else if (asciiSymbol >= 97 && asciiSymbol <= 122) {
                containLowerLetter = true;
                stringBuilder.append((char) asciiSymbol);
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(stringBuilder.toString().getBytes());
        return byteArrayOutputStream;
    }
}
