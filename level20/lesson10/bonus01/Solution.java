package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int n) {
        /*HashMap<String, Integer> sortedCharsMap = new HashMap<>();
        HashMap<Character, Integer> powerNumbersMap = new HashMap<>();
        ArrayList<Integer> powNumbersList = new ArrayList<>();

        int length = 1;
        for (int i = 1; i < n; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            int power = chars.length;
            if (length != power) {
                sortedCharsMap.clear();
                if (powerNumbersMap.size() != 0) {
                    for (Map.Entry<Character, Integer> entry : powerNumbersMap.entrySet()) {
                        powerNumbersMap.put(entry.getKey(), Character.getNumericValue(entry.getKey()) * entry.getValue());
                    }
                }
                length = power;
            }
            Arrays.sort(chars);
            String sortedChars = String.valueOf(chars);
            int sum = 0;
            if (sortedCharsMap.containsKey(sortedChars)) {
                sum = sortedCharsMap.get(sortedChars);
            } else {
                for (int j = 0; j < power; j++) {
                    char c = chars[power - j - 1];
                    if (c == '0' || c == '1') {
                        sum += Character.getNumericValue(c);
                    } else if (powerNumbersMap.containsKey(c)) {
                        sum += powerNumbersMap.get(c);
                    } else {
                        //int powNumber = (int) Math.pow(Character.getNumericValue(c), power);
                        int powNumber = 1;
                        for (int k = 0; k < power; k++) {
                            powNumber *= Character.getNumericValue(c);
                        }
                        sum += powNumber;
                        powerNumbersMap.put(c, powNumber);
                    }
                }
                sortedCharsMap.put(sortedChars, sum);
            }
            if (i == sum) {
                powNumbersList.add(sum);
                System.out.println(sum);
            }
        }*/
        ArrayList<Integer> powNumbersList = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int number = i;
            int length = (int) Math.ceil(Math.log10(i + 0.5));
            int sum = 0;
            while (number != 0) {
                for (int j = 0; j < length; j++) {
                    int digit = number % 10;
                    if (digit == 1 || digit == 0) {
                        sum += digit;
                    } else {
                        //sum += (int) Math.pow(digit, length);
                        int powNumber = 1;
                        for (int k = 0; k < length; k++) {
                            powNumber *= digit;
                        }
                        sum += powNumber;
                    }
                    number = number / 10;
                    if (sum > i) {
                        break;
                    }
                }
                if (sum > i) {
                    break;
                }
            }
            if (sum == i) {
                powNumbersList.add(sum);
            }
        }
        int[] result = new int[powNumbersList.size()];
        for (int i = 0; i < powNumbersList.size(); i++) {
            result[i] = powNumbersList.get(i);
        }
        return result;
    }

    /*public static void main(String[] args) {
        Date date = new Date();
        getNumbers(214748364);
        Date date1 = new Date();
        System.out.println("time = " + (date1.getTime() - date.getTime()) + " ms");
    }*/
}
