package com.atom.cbp.terminal.libraries.Drives;
import java.util.List;
public class HDD extends Drive {
    int rpm;
    public HDD(String name, List<Integer> capacities, int rpm) {
        super(name, capacities);
        this.rpm = rpm;
    }
    public HDD(String name, List<Integer> capacities, int chosenCapacity, int rpm) {
        super(name, capacities, chosenCapacity);
        this.rpm = rpm;
    }
    public int getRpm() {
        return rpm;
    }
    public int getRating() {
        return (int) (( Math.pow( rpm, 2 ) * chosenCapacity ) / 60_000_000);
    }
}