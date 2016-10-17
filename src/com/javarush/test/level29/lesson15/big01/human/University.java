package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student student = null;
        for (Student s : students) {
            if (s.getAverageGrade() == averageGrade) {
                student = s;
                break;
            }
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxAverageGrade = 0;
        Student student = null;
        for (Student s : students) {
            if (maxAverageGrade < s.getAverageGrade()) {
                maxAverageGrade = s.getAverageGrade();
                student = s;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        double minAverageGrade = Double.MAX_VALUE;
        Student student = null;
        for (Student s : students) {
            if (minAverageGrade > s.getAverageGrade()) {
                minAverageGrade = s.getAverageGrade();
                student = s;
            }
        }
        return student;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
