package com.atom.cbp.terminal.libraries;

import java.util.Map;

public class HDD {
    Map<Integer, int[]> capacityCaches;
    int rpm;
    String name;

    public HDD(String name, int rpm, Map<Integer, int[]> capacityCaches) {
        this.name = name;
        this.rpm = rpm;
        this.capacityCaches = capacityCaches;
    }

    public int getRPM() {
        return rpm;
    }
    public Map<Integer, int[]> getCapacityCaches() {
        return capacityCaches;
    }
}
