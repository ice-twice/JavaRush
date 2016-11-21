package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // args = new String[]{"d:\\1\\file.dll", "d:\\1\\file.zip.001", "d:\\1\\file.zip.003", "d:\\1\\file.zip.005", "d:\\1\\file.zip.004", "d:\\1\\file.zip.002"};

        Set<String> partsName = new TreeSet<>();
        for (int i = 1; i < args.length; i++) {
            Path path = Paths.get(args[i]);
            partsName.add(path.toString());
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (String filePath : partsName) {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            inputStream.close();
            byteArrayOutputStream.write(bytes);
        }

        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        BufferedOutputStream outputStreamResult = new BufferedOutputStream(new FileOutputStream(args[0]));
        while (zipInputStream.getNextEntry() != null) {
            byte[] bytes = new byte[1024];
            int count;
            while ((count = zipInputStream.read(bytes)) != -1) {
                outputStreamResult.write(bytes, 0, count);
            }
        }
        zipInputStream.close();
        outputStreamResult.close();
    }
}
