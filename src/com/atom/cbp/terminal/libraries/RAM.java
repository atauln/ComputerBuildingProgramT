package com.atom.cbp.terminal.libraries;

public class RAM {
    String type;
    int speed, capacity;

    //Method declarations
    public RAM(String type, int speed, int capacity) {
        this.type = type;
        this.speed = speed;
        this.capacity = capacity;
    }

    //Getter method
    public int getCapacity() {
        return capacity;
    }
    public int getSpeed() {
        return speed;
    }
    public String getType() {
        return type;
    }
    public double getPrice() {
        return Math.round(0.0025 * Math.pow(speed, 1.01));
    }
}