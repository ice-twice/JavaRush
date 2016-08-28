package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Solution solution = (Solution) obj;
        if (first != null ? !first.equals(solution.first) : solution.first != null)
            return false;
        return last != null ? last.equals(solution.last) : solution.last == null;
    }

    public int hashCode() {
        int prime = 31;
        int result = first != null ? first.hashCode() : 0;
        result = prime * result + (last != null ? last.hashCode() : 0);
        return result;
    }
}
