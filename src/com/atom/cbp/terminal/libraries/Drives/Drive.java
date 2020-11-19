package com.atom.cbp.terminal.libraries.Drives;
import java.util.ArrayList;
import java.util.List;
public class Drive {
    String name;
    List<Integer> capacities;
    public Drive(String name, List<Integer> capacities) {
        this.name = name;
        this.capacities = capacities;
    }
    public List<Integer> getCapacities() {
        return capacities;
    }
    public String getName() {
        return name;
    }
}
