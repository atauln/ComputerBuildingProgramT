package com.atom.cbp.terminal.libraries;
import com.atom.cbp.terminal.Main;
import com.atom.cbp.terminal.libraries.Drives.*;

import java.util.List;
public class Computer {
    Main m = new Main();
    int dayMade;
    RAM[] rams;
    CPU cpu;
    Motherboard mobo;
    GPU[] gpus;
    List<Drive> driveList;
    Case chosenCase;
    PowerSupply powerSupply;
    public Computer(int dayMade, CPU cpu, Motherboard mobo, RAM[] rams, GPU[] gpus, List<Drive> driveList, Case chosenCase, PowerSupply powerSupply) {
        this.rams = rams;
        this.mobo = mobo;
        this.cpu = cpu;
        this.gpus = gpus;
        this.driveList = driveList;
        this.chosenCase = chosenCase;
        this.powerSupply = powerSupply;
        this.dayMade = dayMade;
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
    public void setDay(int day) {
        this.dayMade = day;
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
        System.out.println("Price: $" + getPrice());
        System.out.println("**********");
    }
    public double getPrice() {
        double drivePrices = 0;
        for (Drive drive : driveList) {
            drivePrices += m.calculatePriceDrive(drive);
        }
        return Math.round(cpu.getPrice() + mobo.getPrice() + gpus.length*gpus[0].getPrice() + rams.length*rams[0].getPrice() + drivePrices + chosenCase.getPrice() + powerSupply.getPrice());
    }
    public double getRatings() {
        //RAM range (up to 90,112)
        int ramRating = (int) Math.pow(Integer.parseInt(rams[0].getType().substring(rams[0].getType().length() - 1)), 2) * ((rams.length * rams[0].getCapacity() * rams[0].getSpeed()) / 100);

        //CPU range (up to 109,057)
        int cpuRating = cpu.getRating();

        //Motherboard range (up to 8,000)
        int motherboardRating = mobo.getRating();

        //GPU range (up to 736,584)
        int gpuRating = gpus[0].getRating() * gpus.length;

        //Drive range (up to 160,545 [EACH])
        int driveRating = 0;
        for (Drive drive: driveList) {
            if (drive instanceof SSD) {
                driveRating = ((SSD) drive).getRating();
            } else if (drive instanceof HDD) {
                driveRating = ((HDD) drive).getRating();
            }
        }

        //Case range (up to 128,000)
        int caseRating = chosenCase.getRating();
        
        return ramRating + cpuRating + motherboardRating + gpuRating + driveRating + caseRating;
    }
}