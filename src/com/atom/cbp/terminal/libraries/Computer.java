package com.atom.cbp.terminal.libraries;

public class Computer {
    RAM[] rams;
    CPU cpu;
    Motherboard mobo;
    GPU[] gpus;
    SSD[] ssds;
    HDD[] hdds;

    public Computer(CPU cpu, Motherboard mobo, RAM[] rams, GPU[] gpus, SSD[] ssds, HDD[] hdds) {
        this.rams = rams;
        this.mobo = mobo;
        this.cpu = cpu;
        this.gpus = gpus;
        this.ssds = ssds;
        this.hdds = hdds;
    }

    public RAM[] getRams() {
        return rams;
    }
    public void setRams(RAM[] rams) {
        this.rams = rams;
    }
    public void setSsds(SSD[] ssds) {
        this.ssds = ssds;
    }
    public void setHdds(HDD[] hdds) {
        this.hdds = hdds;
    }
    public CPU getCpu() {
        return cpu;
    }
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
    public Motherboard getMobo() {
        return mobo;
    }
    public void setMobo(Motherboard mobo) {
        this.mobo = mobo;
    }
    public GPU[] getGpus() {
        return gpus;
    }
    public void setGpus(GPU[] gpus) {
        this.gpus = gpus;
    }
    public SSD[] getSsds() {
        return ssds;
    }
    public HDD[] getHdds() {
        return hdds;
    }
}