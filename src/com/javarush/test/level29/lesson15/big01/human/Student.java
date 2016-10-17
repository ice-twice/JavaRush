package com.javarush.test.level29.lesson15.big01.human;

import java.util.Date;

public class Student extends UniversityPerson {
    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    @Override
    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta) {
        setAverageGrade(getAverageGrade() + delta);
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double value) {
        averageGrade = value;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int value) {
        course = value;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }
}
