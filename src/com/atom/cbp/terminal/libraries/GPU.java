package com.atom.cbp.terminal.libraries;

public class GPU {

    //General variables
    String name, releaseDate, memoryType;
    int memorySize, cores, price, baseClock, boostClock, tdp;

    //Main constructor method
    public GPU(String name, String releaseDate, String memoryType, int memorySize, int cores, int baseClock, int boostClock, int price, int tdp) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.memoryType = memoryType;
        this.memorySize = memorySize;
        this.baseClock = baseClock;
        this.boostClock = boostClock;
        this.cores = cores;
        this.price = price;
        this.tdp = tdp;
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
    public int getTdp() {
        return tdp;
    }
    public int getRating() {
        int rating = (int) (this.getBaseClock()*Math.pow(this.getBoostClock() / this.getBaseClock(), 3)*Math.sqrt(Math.sqrt(this.getCores())));
        if (this.getMemoryType().equals("GDDR5")) {
            rating *= Math.pow(this.getMemorySize(), 1);
        } else if (this.getMemoryType().equals("GDDR5X")) {
            rating *= Math.pow(this.getMemorySize(), 1.5);
        } else if (this.getMemoryType().equals("GDDR6")) {
            rating *= Math.pow(this.getMemorySize(), 2);
        } else if (this.getMemoryType().equals("GDDR6X")) {
            rating *= Math.pow(this.getMemorySize(), 2.5);
        }
        return rating;
    }
}
