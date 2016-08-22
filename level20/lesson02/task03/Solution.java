package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties property = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        InputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        property.putAll(properties);
        property.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        property.load(inputStream);
        for (Map.Entry<Object, Object> entry : property.entrySet()) {
            properties.put((String) entry.getKey(), (String) entry.getValue());
        }
    }

    /*public static void main(String[] args) throws Exception {
        *//*properties.put("key1", "value1");
        properties.put("key2", "value2");
        properties.put("key3", "value3");
        properties.put("key4", "value4");
        properties.put("key5", "value5");*//*

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        Solution solution = new Solution();

        *//*OutputStream outputStream = new FileOutputStream(fileName);
        solution.save(outputStream);
        outputStream.close();*//*

        InputStream inputStream = new FileInputStream(fileName);
        solution.load(inputStream);
        inputStream.close();

        for (Map.Entry<String, String> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }*/
}
