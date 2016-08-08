package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        //args = new String[]{"span"};

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));
        String currentLine;
        while ((currentLine = bufferedFileReader.readLine()) != null) {
            stringBuilder.append(currentLine);
        }
        bufferedFileReader.close();
        int indexStart = 0;
        String line = stringBuilder.toString();
        while (true) {
            int indexSubstringBegin = line.indexOf("<" + args[0], indexStart);
            if (indexSubstringBegin == -1) {
                break;
            }
            int indexSubstringEnd = line.indexOf("</" + args[0], indexSubstringBegin);
            int indexInnerTag = line.indexOf("<" + args[0], indexSubstringBegin + args[0].length());
            while (true) {
                if (indexInnerTag == -1) {
                    System.out.println(line.substring(indexSubstringBegin, indexSubstringEnd + args[0].length() + 3));
                    indexStart = indexSubstringBegin + args[0].length();
                    break;
                } else if (indexInnerTag < indexSubstringEnd) {
                    indexInnerTag = line.indexOf("<" + args[0], indexInnerTag + args[0].length());
                    indexSubstringEnd = line.indexOf("</" + args[0], indexSubstringEnd + args[0].length());
                } else if (indexInnerTag > indexSubstringEnd) {
                    System.out.println(line.substring(indexSubstringBegin, indexSubstringEnd + args[0].length() + 3));
                    indexStart = line.indexOf("<" + args[0], indexSubstringBegin + args[0].length());
                    break;
                }
            }
        }
    }
}
