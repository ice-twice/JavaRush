package com.javarush.test.level27.lesson06.home01;

public class Apartment {
    private final RealEstate realEstate;
    private String location;

    public Apartment(RealEstate realEstate) {
        this.realEstate = realEstate;
        setLocation(String.valueOf(Math.random() * 10));
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public synchronized void revalidate(boolean isEmpty) {
        if (isEmpty)
            realEstate.up(this);
    }
}
