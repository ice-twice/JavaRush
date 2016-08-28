package com.javarush.test.level21.lesson05.task03;

import java.util.Date;

/* Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution1 = (Solution) o;
        if (anInt != solution1.anInt) return false;
        if (string != null ? !string.equals(solution1.string) : solution1.string != null) return false;
        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date != null) return false;
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = anInt;
        result = prime * result + (string != null ? string.hashCode() : 0);
        long temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (date != null ? date.hashCode() : 0);
        result = prime * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }
}
