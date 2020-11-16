package com.atom.cbp.terminal.libraries;

public class CPU {

    //General variable introduction
    String name, releaseDate, memoryType;
    double ghz, turboBoostTo;
    int price, hyperThreading, coreCount, maxMemory, TDP;
    boolean overclockable;

    //Method declarations
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, int hyperThreading) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.hyperThreading = hyperThreading;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.coreCount = coreCount;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, double turboBoostTo) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.turboBoostTo = turboBoostTo;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.coreCount = coreCount;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, boolean overclockable) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.overclockable = overclockable;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.coreCount = coreCount;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, double turboBoostTo, int hyperThreading) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.turboBoostTo = turboBoostTo;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.hyperThreading = hyperThreading;
        this.coreCount = coreCount;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, double turboBoostTo, boolean overclockable) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.turboBoostTo = turboBoostTo;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.overclockable = overclockable;
        this.coreCount = coreCount;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, int hyperThreading, double turboBoostTo, boolean overclockable) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.turboBoostTo = turboBoostTo;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.hyperThreading = hyperThreading;
        this.coreCount = coreCount;
        this.overclockable = overclockable;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
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
    public int getTDP() {
        return TDP;
    }
}