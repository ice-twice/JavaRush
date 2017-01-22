package com.javarush.test.level33.lesson05.home03;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/* Десериализация JSON объекта
НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1

В метод convertFromJsonToNormal первым параметром приходит имя файла, который содержит один ДЖЕЙСОН объект.
Вторым параметром приходит имя класса, объект которого находится в файле.
Метод convertFromJsonToNormal должен вычитать объект из файла, преобразовать его из JSON и вернуть его.
*/
public class Solution {
    /*public static void main(String[] args) throws IOException {
        Cat cat = convertFromJsonToNormal("D:\\1\\1.txt", Cat.class);
    }*/

    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuffer = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuffer.append(line);
        }
        reader.close();
        StringReader stringReader = new StringReader(stringBuffer.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(stringReader, clazz);
    }

    @JsonAutoDetect
    public static class Cat {
        public String name;
        public int age;
    }
}