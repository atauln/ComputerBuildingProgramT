package com.atom.cbp.terminal.libraries;

public class CPU {

    //General variable introduction
    String name, releaseDate, memoryType;
    double ghz, turboBoostTo;
    int price, hyperThreading, coreCount, maxMemory, TDP;
    boolean overclockable;

    //NEED TO ADD
    String socket, architecture;

    //Method declarations
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, String socket, String arch, int hyperThreading) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.hyperThreading = hyperThreading;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.coreCount = coreCount;
        this.socket = socket;
        this.architecture = arch;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, String socket, String arch, double turboBoostTo) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.turboBoostTo = turboBoostTo;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.coreCount = coreCount;
        this.socket = socket;
        this.architecture = arch;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, String socket, String arch, boolean overclockable) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.overclockable = overclockable;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.coreCount = coreCount;
        this.socket = socket;
        this.architecture = arch;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, String socket, String arch, double turboBoostTo, int hyperThreading) {
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
        this.socket = socket;
        this.architecture = arch;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, String socket, String arch, double turboBoostTo, boolean overclockable) {
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
        this.socket = socket;
        this.architecture = arch;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, String socket, String arch, int hyperThreading, double turboBoostTo, boolean overclockable) {
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
        this.socket = socket;
        this.architecture = arch;
    }
    public CPU(String name, double ghz, int coreCount, String releaseDate, int price, int maxMemory, String memoryType, int TDP, String socket, String arch) {
        this.name = name;
        this.ghz = ghz;
        this.releaseDate = releaseDate;
        this.price = price;
        this.maxMemory = maxMemory;
        this.memoryType = memoryType;
        this.TDP = TDP;
        this.coreCount = coreCount;
        this.socket = socket;
        this.architecture = arch;
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
    public boolean isOverclockable() {
        return overclockable;
    }
    public String getSocket() {
        return socket;
    }
    public String getArchitecture() {
        return architecture;
    }
}