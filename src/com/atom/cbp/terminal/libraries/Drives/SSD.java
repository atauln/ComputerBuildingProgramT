package com.atom.cbp.terminal.libraries.Drives;
import java.util.List;
public class SSD extends Drive {
    int readSpeed, writeSpeed, price;
    String interf;
    public SSD(String name, List<Integer> capacities, int readSpeed, int writeSpeed, String interf) {
        super(name, capacities);
        this.interf = interf;
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
    }
    public SSD(String name, List<Integer> capacities, int chosenCapacity, int readSpeed, int writeSpeed, String interf) {
        super(name, capacities, chosenCapacity);
        this.interf = interf;
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
    }
    public int getReadSpeed() {
        return readSpeed;
    }
    public int getWriteSpeed() {
        return writeSpeed;
    }
    public String getInterf() {
        return interf;
    }
}