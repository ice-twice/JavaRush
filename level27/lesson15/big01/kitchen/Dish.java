package com.javarush.test.level27.lesson15.big01.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private final int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        if (Dish.values().length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Dish dish : Dish.values()) {
            sb.append(dish);
            if (dish.ordinal() != Dish.values().length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public int getDuration() {
        return duration;
    }
}
