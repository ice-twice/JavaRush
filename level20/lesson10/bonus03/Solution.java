package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> wordList = detectAllWords(crossword, "home", "same");
        for (Word word : wordList) {
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> wordsList = new ArrayList<>();
        for (String word1 : words) {
            outer:
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == word1.charAt(0)) {
                        for (int l = -1; l < 2; l++) {
                            for (int m = -1; m < 2; m++) {
                                if (i + l < 0) {
                                    l += 1;
                                }
                                if (j + m < 0) {
                                    m += 1;
                                }
                                if (i + l >= crossword.length || j + m >= crossword[i].length) {
                                    break;
                                }
                                if (crossword[i + l][j + m] == word1.charAt(1)) {
                                    int tempI = i + l + l;
                                    int tempJ = j + m + m;
                                    if (tempI >= crossword.length || tempJ >= crossword[i].length) {
                                        break;
                                    }
                                    for (int n = 2; n < word1.length(); n++) {
                                        if (word1.charAt(n) != crossword[tempI][tempJ]) {
                                            break;
                                        }
                                        if (word1.length() - 1 == n) {
                                            Word word = new Word(word1);
                                            word.setStartPoint(j, i);
                                            word.setEndPoint(tempJ, tempI);
                                            wordsList.add(word);
                                            break outer;
                                        }
                                        tempI += l;
                                        tempJ += m;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return wordsList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
