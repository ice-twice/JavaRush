package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"d:\\2", "d:\\2\\result.txt"};
        File inputFile = new File(args[0]);

        Path source = Paths.get(args[1]);
        Path newPath = Files.move(source, source.resolveSibling("allFilesContent.txt"));

        List<File> selectedFiles = passFileTree(inputFile);

        if (!selectedFiles.isEmpty()) {
            selectedFiles.remove(newPath.toFile());
            Collections.sort(selectedFiles, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            BufferedWriter writer = new BufferedWriter(new FileWriter(newPath.toString()));
            for (File file : selectedFiles) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while (reader.ready()) {
                    writer.write(reader.readLine());
                    writer.newLine();
                }
                reader.close();
            }
            writer.close();
        }
    }

    public static List<File> passFileTree(File inputFile) {
        List<File> files = new ArrayList<>();
        passFileTree(files, inputFile);
        return files;
    }

    public static void passFileTree(List<File> files, File inputFile) {
        for (File file : inputFile.listFiles()) {
            if (file.isDirectory()) {
                if (!file.delete()) {
                    passFileTree(files, file);
                }
            } else {
                if (file.length() > 50) {
                    file.delete();
                } else {
                    files.add(file);
                }
            }
        }
    }
}
