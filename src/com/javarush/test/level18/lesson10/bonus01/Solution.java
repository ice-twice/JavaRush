package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String DO_ENCRYPT = "-e";
        String DO_DECRYPT = "-d";

        // String parameter = "-e d:\\1.txt d:\\2.txt";
        // String parameter = "-d d:\\2.txt d:\\3.txt";
        // args = parameter.split(" ");
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();
        byte[] handleBytes = new byte[bytes.length];
        if (args[0].equals(DO_ENCRYPT)) {
            for (int i = 0; i < bytes.length; i++) {
                handleBytes[i] = (byte) (bytes[i] + 1);
            }
        } else if (args[0].equals(DO_DECRYPT)) {
            for (int i = 0; i < bytes.length; i++) {
                handleBytes[i] = (byte) (bytes[i] - 1);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
        fileOutputStream.write(handleBytes);
        fileOutputStream.close();
    }
}
