package com.javarush.test.level31.lesson08.home01;

import java.nio.file.Files;
import java.nio.file.Paths;

/* Null Object Pattern
Почитайте на вики про паттерн "Null Object"
Используйте Files, чтобы в конструкторе класса Solution правильно инициализировать поле fileData объектом ConcreteFileData.
Если возникли какие-то проблемы со чтением файла по пути pathToFile, то инициализируйте поле объектом NullFileData.
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            boolean isHidden = Files.isHidden(Paths.get(pathToFile));
            boolean isExecutable = Files.isExecutable(Paths.get(pathToFile));
            boolean isDirectory = Files.isDirectory(Paths.get(pathToFile));
            boolean isWritable = Files.isWritable(Paths.get(pathToFile));
            fileData = new ConcreteFileData(isHidden, isExecutable, isDirectory, isWritable);
        } catch (Exception e) {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
