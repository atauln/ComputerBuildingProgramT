package com.atom.cbp.terminal.libraries;

import com.atom.cbp.terminal.libraries.Drives.Drive;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    RAM[] rams;
    CPU cpu;
    Motherboard mobo;
    GPU[] gpus;
    List<Drive> driveList;
    public Computer(CPU cpu, Motherboard mobo, RAM[] rams, GPU[] gpus, List<Drive> driveList) {
        this.rams = rams;
        this.mobo = mobo;
        this.cpu = cpu;
        this.gpus = gpus;
        this.driveList = driveList;
    }

    public RAM[] getRams() {
        return rams;
    }
    public void setRams(RAM[] rams) {
        this.rams = rams;
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
    public List<Drive> getDriveList() {
        return driveList;
    }
    public void setDriveList(List<Drive> driveList) {
        this.driveList = driveList;
    }
}