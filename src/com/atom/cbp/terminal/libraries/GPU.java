package com.atom.cbp.terminal.libraries;

public class GPU {

    //General variables
    String name, releaseDate, memoryType;
    int memorySize, cores, price, baseClock, boostClock;

    //Main constructor method
    public GPU(String name, String releaseDate, String memoryType, int memorySize, int cores, int baseClock, int boostClock, int price) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.memoryType = memoryType;
        this.memorySize = memorySize;
        this.baseClock = baseClock;
        this.boostClock = boostClock;
        this.cores = cores;
        this.price = price;
    }

    //Getter methods
    public String getName() {
        return name;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public String getMemoryType() {
        return memoryType;
    }
    public int getMemorySize() {
        return memorySize;
    }
    public int getCores() {
        return cores;
    }
    public int getPrice() {
        return price;
    }
    public int getBaseClock() {
        return baseClock;
    }
    public int getBoostClock() {
        return boostClock;
    }
}
