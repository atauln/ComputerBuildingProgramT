package com.atom.cbp.terminal.libraries;

public class CPU {

    //General variable introduction
    String name, releaseDate, memoryType;
    double ghz, turboBoostTo;
    int price, hyperThreading, coreCount, maxMemory, TDP, memoryLanes;
    boolean overclockable;

    //Method declarations
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, int memoryLanes, int hyperThreading) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.hyperThreading = hyperThreading;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.memoryLanes = memoryLanes;
        this.coreCount = coreCount;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, int memoryLanes, double turboBoostTo) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.turboBoostTo = turboBoostTo;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.memoryLanes = memoryLanes;
        this.coreCount = coreCount;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, int memoryLanes, boolean overclockable) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.overclockable = overclockable;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.memoryLanes = memoryLanes;
        this.coreCount = coreCount;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, int memoryLanes, double turboBoostTo, int hyperThreading) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.turboBoostTo = turboBoostTo;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.memoryLanes = memoryLanes;
        this.hyperThreading = hyperThreading;
        this.coreCount = coreCount;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, int memoryLanes, double turboBoostTo, boolean overclockable) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.turboBoostTo = turboBoostTo;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.memoryLanes = memoryLanes;
        this.overclockable = overclockable;
        this.coreCount = coreCount;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, int memoryLanes, double turboBoostTo, int hyperThreading, boolean overclockable) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.turboBoostTo = turboBoostTo;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.memoryLanes = memoryLanes;
        this.hyperThreading = hyperThreading;
        this.coreCount = coreCount;
        this.overclockable = overclockable;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, int memoryLanes) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.memoryLanes = memoryLanes;
        this.coreCount = coreCount;
    }

    //Getter methods
    public String getName() {
        return name;
    }
    public double getGhz() {
        return ghz;
    }
    public int getPrice() {
        return price;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public double getTurboBoostTo() {
        return turboBoostTo;
    }
    public int getCoreCount() {
        return coreCount;
    }
    public int getHyperThreading() {
        return hyperThreading;
    }
    public int getMaxMemory() {
        return maxMemory;
    }
    public String getMemoryType() {
        return memoryType;
    }
    public int getMemoryLanes() {
        return memoryLanes;
    }
    public int getTDP() {
        return TDP;
    }
}