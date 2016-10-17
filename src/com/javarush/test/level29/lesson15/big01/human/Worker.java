package com.javarush.test.level29.lesson15.big01.human;

public class Worker extends Human {
    public String company;
    private double salary;

    public Worker(String name, int age) {
        super(name, age);
    }

    @Override
    public void live() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
