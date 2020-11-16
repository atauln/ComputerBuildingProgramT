package com.atom.cbp.terminal;

import com.atom.cbp.terminal.libraries.CPU;
import com.atom.cbp.terminal.libraries.Variables;

import java.util.*;

public class Main {

    //Local variable declaration
    Variables var = new Variables();
    Scanner scan = new Scanner(System.in).useDelimiter("\\n");
    List<CPU> intelCPUList = new ArrayList<>();
    List<CPU> AMDCPUList = new ArrayList<>();
    CPU currentCPU;

    //Main class
    public static void main(String[] args) {
        Variables var = new Variables();
        Main main = new Main();
        var.initLists();
        main.setIntelCPUList(var.getIntelCPUList());
        main.setAMDCPUList(var.getAmdCPUList());
        while (true) {
            var.setDay(var.getDay() + 1);
            main.day(var.getDay());
        }
    }

    //day function
    public void day(int day) {
        sysOut("It is now day " + day + ".");
        boolean dayEnd = false;
        while (!dayEnd) {
            dayEnd = false;
            List<String> command = listenforCommand();
            if (command.get(0).equals("end")) {
                dayEnd = true;
                break;
            }
            try {
                //checking command, and outputting result
                if (command.get(0).equals("help")) {
                    sysOut("----------");
                    sysOut("Commands currently available: ");
                    sysOut("startbuild - start building your pc");
                    sysOut("stopbuild - remove current pc");
                    sysOut("shop [type] [brand] - look at the current catalog of items");
                    sysOut("details [type] [brand] [#] - get details for an item");
                    sysOut("----------");
                }
                if (command.get(0).equals("shop")) {
                    if (command.get(1).equals("cpu")) {
                        sysOut("----------");
                        sysOut("Current balance: " + var.getBal());
                        if (command.get(2).equals("intel")) {
                            sysOut("1. Intel Core 2 Duo E8400");
                            sysOut("2. Intel Core i3-2370M");
                            sysOut("3. Intel Core i3-8145U");
                            sysOut("4. Intel Core i3-10100");
                            sysOut("5. Intel Core i5-2400");
                            sysOut("6. Intel Core i5-8500");
                            sysOut("7. Intel Core i7-6700");
                            sysOut("8. Intel Core i7-8700");
                            sysOut("9. Intel Core i9-9900K");
                        } else if (command.get(2).equals("amd")) {
                            sysOut("1. AMD Athlon 3000G");
                            sysOut("2. AMD Ryzen 3 1200");
                            sysOut("3. AMD Ryzen 3 3200G");
                            sysOut("4. AMD Ryzen 5 1600");
                            sysOut("5. AMD Ryzen 5 2400G");
                            sysOut("6. AMD Ryzen 5 3600");
                            sysOut("7. AMD Ryzen 7 2700X");
                            sysOut("8. AMD Ryzen 7 3800X");
                            sysOut("9. AMD Ryzen 9 3900X");
                            sysOut("10. AMD Ryzen Threadripper 2950X");
                            sysOut("11. AMD Ryzen Threadripper 3970X");
                        }
                        sysOut("----------");
                    }
                }
                if (command.get(0).equals("details")) {
                    if (command.get(1).equals("cpu")) {
                        if (command.get(2).equals("intel")) {
                            CPU currentCPU = intelCPUList.get(Integer.parseInt(command.get(3)) - 1);
                            sysOut("----------");
                            sysOut("CPU Details");
                            sysOut("Name: " + currentCPU.getName());
                            sysOut("Core Count: " + currentCPU.getCoreCount());
                            if (currentCPU.getHyperThreading() > currentCPU.getCoreCount()) {sysOut("Hyperthreading: true (" + currentCPU.getHyperThreading() + " cores)");}
                            else {sysOut("Hyperthreading: false");}
                            sysOut("Processing Speed: " + currentCPU.getGhz() + " GHz");
                            if (currentCPU.getTurboBoostTo() > currentCPU.getGhz()) {sysOut("Turbo Boost: true (boosts up to " + currentCPU.getTurboBoostTo() + " GHz)");}
                            else {sysOut("Turbo Boost: false");}
                            sysOut("Memory: Max of " + currentCPU.getMaxMemory() + " GB\nMemory Type: " + currentCPU.getMemoryType());
                            sysOut("TDP: " + currentCPU.getTDP() + "W");
                            sysOut("Release Date: " + currentCPU.getReleaseDate());
                            sysOut("Price: $" + currentCPU.getPrice());
                            sysOut("----------");
                        } else if (command.get(2).equals("amd")) {
                            currentCPU = AMDCPUList.get(Integer.parseInt(command.get(3)) - 1);
                            sysOut("----------");
                            sysOut("CPU Details");
                            sysOut("Name: " + currentCPU.getName());
                            sysOut("Core Count: " + currentCPU.getCoreCount());
                            if (currentCPU.getHyperThreading() > currentCPU.getCoreCount()) {sysOut("Hyperthreading: true (" + currentCPU.getHyperThreading() + " cores)");}
                            else {sysOut("Hyperthreading: false");}
                            sysOut("Processing Speed: " + currentCPU.getGhz() + " GHz");
                            if (currentCPU.getTurboBoostTo() > currentCPU.getGhz()) {sysOut("Turbo Boost: true (boosts up to " + currentCPU.getTurboBoostTo() + " GHz)");}
                            else {sysOut("Turbo Boost: false");}
                            sysOut("Memory: Max of " + currentCPU.getMaxMemory() + " GB\nMemory Type: " + currentCPU.getMemoryType());
                            sysOut("TDP: " + currentCPU.getTDP() + "W");
                            sysOut("Release Date: " + currentCPU.getReleaseDate());
                            sysOut("Price: $" + currentCPU.getPrice());
                            sysOut("----------");
                        }
                    }
                }
            } catch (Exception e) {
                sysOut(e.toString());
            }
        }
    }

    //Mini-methods
    public List<CPU> getIntelCPUList() {
        return intelCPUList;
    }
    public void setIntelCPUList(List<CPU> intelCPUList) {
        this.intelCPUList = intelCPUList;
    }
    public List<CPU> getAMDCPUList() {
        return AMDCPUList;
    }
    public void setAMDCPUList(List<CPU> AMDCPUList) {
        this.AMDCPUList = AMDCPUList;
    }
    public List<String> listenforCommand() {
        return Arrays.asList(scan.next().split(" "));
    }
    public void sysOut(String string) {
        System.out.println(string);
    }
}