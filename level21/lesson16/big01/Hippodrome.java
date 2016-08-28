package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {
    public static Hippodrome game;
    private ArrayList<Horse> horses = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        ArrayList<Horse> horses = game.getHorses();
        Horse horse1 = new Horse("horse1", 3, 0);
        Horse horse2 = new Horse("horse2", 3, 0);
        Horse horse3 = new Horse("horse3", 3, 0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : getHorses()) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        double maxDistance = 0d;
        Horse horseWinner = null;
        for (Horse horse : getHorses()) {
            if (horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
                horseWinner = horse;
            }
        }
        return horseWinner;
    }

    public void printWinner() {
        Horse horseWinner = getWinner();
        System.out.println("Winner is " + horseWinner.getName() + "!");
    }
}
