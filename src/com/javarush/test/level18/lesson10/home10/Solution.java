package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
     /*   ArrayList<String> fileNames = new ArrayList<>();
        fileNames.add("C:\\test\\test.pp.part5");
        fileNames.add("C:\\test\\test.pp.part4");
        fileNames.add("C:\\test\\test.pp.part3");
        fileNames.add("C:\\test\\test.pp.part2");
        fileNames.add("C:\\test\\test.pp.part1");
        fileNames.add("C:\\test\\test.pp.part10");
        fileNames.add("C:\\test\\test.pp.part9");
        fileNames.add("C:\\test\\test.pp.part8");
        fileNames.add("C:\\test\\test.pp.part7");
        fileNames.add("C:\\test\\test.pp.part6");
        fileNames.add("C:\\test\\test.pp.part100");*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        ArrayList<String> fileNames = new ArrayList<>();
        while (!(fileName = reader.readLine()).equals("end")) {
            fileNames.add(fileName);
        }
        reader.close();

        Collections.sort(fileNames, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                }
                return o1.compareTo(o2);
            }
        });

        byte[] bytes;
        FileOutputStream fileOutputStream = new FileOutputStream(fileNames.get(0).substring(0, fileNames.get(0).lastIndexOf(".")));
        for (String s : fileNames) {
            FileInputStream fileInputStream = new FileInputStream(s);
            bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            fileOutputStream.write(bytes);
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
}
