package com.atom.cbp.terminal.libraries;

public class SSD {
    String interf, name;
    int readSpeed, writeSpeed;
    int[] capacity;

    public SSD(String name, int[] capacity, String interf, int readSpeed, int writeSpeed) {
        this.name = name;
        this.capacity = capacity;
        this.interf = interf;
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
    }

    public String getInterf() {
        return interf;
    }
    public int getReadSpeed() {
        return readSpeed;
    }
    public int getWriteSpeed() {
        return writeSpeed;
    }
}