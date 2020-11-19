package com.atom.cbp.terminal.libraries.Drives;
import java.util.List;
public class HDD extends Drive {
    int rpm;
    public HDD(String name, List<Integer> capacities, int rpm) {
        super(name, capacities);
        this.rpm = rpm;
    }
}