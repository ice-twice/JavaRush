package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution() {
    }

    public Solution(byte b) {
    }

    public Solution(char c) {
    }

    Solution(double v) {

    }

    Solution(int i) {

    }

    Solution(long l) {

    }

    private Solution(short i) {

    }

    private Solution(Boolean aBoolean) {

    }

    private Solution(Byte aByte) {

    }

    protected Solution(Character aChar) {

    }

    protected Solution(Double aDouble) {

    }

    protected Solution(Float aFloat) {

    }


}

