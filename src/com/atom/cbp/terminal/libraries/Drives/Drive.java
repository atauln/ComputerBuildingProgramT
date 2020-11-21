package com.atom.cbp.terminal.libraries.Drives;
import java.util.List;
public class Drive {
    String name;
    List<Integer> capacities;
    int chosenCapacity;
    public Drive(String name, List<Integer> capacities) {
        this.name = name;
        this.capacities = capacities;
    }
    public Drive(String name, List<Integer> capacities, int chosenCapacity) {
        this.name = name;
        this.capacities = capacities;
        this.chosenCapacity = chosenCapacity;
    }
    public List<Integer> getCapacities() {
        return capacities;
    }
    public String getName() {
        return name;
    }
    public int getChosenCapacity() {
        return chosenCapacity;
    }
    public void setChosenCapacity(int chosenCapacity) {
        this.chosenCapacity = chosenCapacity;
    }
}