package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader bufferedFileReader1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader bufferedFileReader2 = new BufferedReader(new FileReader(fileName2));
        ArrayList<String> linesFile1Array = new ArrayList<>();
        ArrayList<String> linesFile2Array = new ArrayList<>();
        while (true) {
            String currentLine1 = bufferedFileReader1.readLine();
            String currentLine2 = bufferedFileReader2.readLine();
            if (currentLine1 == null && currentLine2 == null) {
                break;
            }
            linesFile1Array.add(currentLine1);
            linesFile2Array.add(currentLine2);
        }
        bufferedFileReader1.close();
        bufferedFileReader2.close();


        for (int i = 0, j = 0; i < linesFile1Array.size() || j < linesFile2Array.size(); i++, j++) {
            String line1 = i < linesFile1Array.size() ? linesFile1Array.get(i) : null;
            String line2 = j < linesFile2Array.size() ? linesFile2Array.get(j) : null;
            String nextLine1 = i + 1 < linesFile1Array.size() ? linesFile1Array.get(i + 1) : null;
            String nextLine2 = j + 1 < linesFile2Array.size() ? linesFile2Array.get(j + 1) : null;
            if (line1 == null && line2 == null) {
                break;
            }
            if (line1 != null && line1.equals(line2)) {
                lines.add(new LineItem(Type.SAME, line1));
            } else if (line1 == null || line1.equals(nextLine2)) {
                lines.add(new LineItem(Type.ADDED, line2));
                i--;
            } else if (line2 == null || nextLine1.equals(line2)) {
                lines.add(new LineItem(Type.REMOVED, linesFile1Array.get(i)));
                j--;
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
