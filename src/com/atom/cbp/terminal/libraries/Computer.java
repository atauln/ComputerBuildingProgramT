package com.atom.cbp.terminal.libraries;
import com.atom.cbp.terminal.Main;
import com.atom.cbp.terminal.libraries.Drives.Drive;
import com.atom.cbp.terminal.libraries.Drives.SSD;

import java.util.List;
public class Computer {
    Main m = new Main();

    RAM[] rams;
    CPU cpu;
    Motherboard mobo;
    GPU[] gpus;
    List<Drive> driveList;
    Case chosenCase;
    PowerSupply powerSupply;
    public Computer(CPU cpu, Motherboard mobo, RAM[] rams, GPU[] gpus, List<Drive> driveList, Case chosenCase, PowerSupply powerSupply) {
        this.rams = rams;
        this.mobo = mobo;
        this.cpu = cpu;
        this.gpus = gpus;
        this.driveList = driveList;
        this.chosenCase = chosenCase;
        this.powerSupply = powerSupply;
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
    public PowerSupply getPowerSupply() {
        return powerSupply;
    }
    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
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
    public Case getChosenCase() {
        return chosenCase;
    }
    public void setChosenCase(Case chosenCase) {
        this.chosenCase = chosenCase;
    }
    public int getWatts() {
        return cpu.getTDP() + gpus[0].getTdp() + 75 + rams.length*rams[0].getCapacity() + driveList.size()*15;
    }
    public void sysOutput() {
        System.out.println("**********\nPC Details: " +
                "\nCase: " + chosenCase.getName() +
                "\nCPU: " + cpu.getName() +
                "\nMotherboard: " + mobo.getName() +
                "\nRAM: " + rams.length + "x" + rams[0].getCapacity() + "GB " + rams[0].getType() + "-" + rams[0].getSpeed() +
                "\nGPU(s): " + gpus[0].getName() + " (" + gpus.length + ")" +
                "\nPower Supply: " + powerSupply.getName() + " (" + powerSupply.getType() + " | " + powerSupply.getRating() + " | " + powerSupply.getChosenWatts() + "W)" +
                "\nDrives: ");
        for (Drive drive : driveList) {
            if (drive instanceof SSD) {
                if (((SSD) drive).getInterf().equals("NVMe")) {
                    System.out.println(" - " + drive.getName() + " [NVMe | SSD | " + drive.getChosenCapacity() + "GB] ($" + m.calculatePriceDrive(drive) + ")");
                } else {
                    System.out.println(" - " + drive.getName() + " [SATA | SSD | " + drive.getChosenCapacity() + "GB] ($" + m.calculatePriceDrive(drive) + ")");
                }
            } else {
                System.out.println(" - " + drive.getName() + " [SATA | HDD | " + drive.getChosenCapacity() + "GB] ($" + m.calculatePriceDrive(drive) + ")");
            }
        }
        System.out.println("Watts: " + getWatts());
        System.out.println("**********");
    }
}