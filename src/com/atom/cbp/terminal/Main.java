package com.atom.cbp.terminal;

import com.atom.cbp.terminal.libraries.CPU;

import java.util.*;

public class Main {
    Variables var = new Variables();
    Scanner scan = new Scanner(System.in).useDelimiter("\\n");
    public List<CPU> intelCPUList = new ArrayList<>();

    public static void main(String[] args) {
        Variables var = new Variables();
        Main main = new Main();
        main.initLists();
        while (true) {
            var.setDay(var.getDay() + 1);
            main.day(var.getDay());
        }
    }
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
                switch (command.get(0)) {
                    case "help":
                        sysOut("----------");
                        sysOut("Commands currently available: ");
                        sysOut("startbuild - start building your pc");
                        sysOut("stopbuild - remove current pc");
                        sysOut("shop [type] [brand] - look at the current catalog of items");
                        sysOut("details [type] [brand] [#] - get details for an item");
                        sysOut("----------");
                    case "shop":
                        switch (command.get(1)) {
                            case "cpu":
                                switch (command.get(2)) {
                                    case "intel":
                                        sysOut("----------");
                                        sysOut("Current balance: " + var.getBal());
                                        sysOut("1. Intel Core 2 Duo E8400");
                                        sysOut("2. Intel Core i3-2370M");
                                        sysOut("3. Intel Core i3-8145U");
                                        sysOut("4. Intel Core i3-10100");
                                        sysOut("5. Intel Core i5-2400");
                                        sysOut("6. Intel Core i5-8500");
                                        sysOut("7. Intel Core i7-6700");
                                        sysOut("8. Intel Core i7-8700");
                                        sysOut("9. Intel Core i9-9900K");
                                        sysOut("----------");
                                }
                        }
                    case "details":
                        switch (command.get(1)) {
                            case "cpu":
                                switch (command.get(2)) {
                                    case "intel":
                                        CPU currentCPU = intelCPUList.get(Integer.parseInt(command.get(3)) - 1);
                                        sysOut("----------");
                                        sysOut("CPU Details");
                                        sysOut("Name: " + currentCPU.getName());
                                        sysOut("Core Count: " + currentCPU.getCoreCount());
                                        if (currentCPU.getHyperThreading() > currentCPU.getCoreCount()) {sysOut("Hyperthreading: true (" + currentCPU.getHyperThreading() + " cores)");}
                                        sysOut("Processing Speed: " + currentCPU.getGhz() + " GHz");
                                        if (currentCPU.getTurboBoostTo() > currentCPU.getGhz()) {sysOut("Turbo Boost: true (boosts up to " + currentCPU.getTurboBoostTo() + " GHz)");}
                                        sysOut("Memory: Max of " + currentCPU.getMaxMemory() + " GB\nMemory Channels: " + currentCPU.getMemoryLanes() + " memory lanes\nMemory Type: " + currentCPU.getMemoryType());
                                        sysOut("TDP: " + currentCPU.getTDP());
                                        sysOut("Release Date: " + currentCPU.getReleaseDate());
                                        sysOut("Price: $" + currentCPU.getPrice());
                                        sysOut("----------");
                                }
                        }
                }
            } catch (Exception e) {
                if (e instanceof ArrayIndexOutOfBoundsException) {
                    sysOut("ERROR: Your args were out of bounds!");
                }
            }
        }
    }

    public List<String> listenforCommand() {
        return Arrays.asList(scan.next().split(" "));
    }

    public void initLists() {
        intelCPUList.add(new CPU("Core 2 Duo E8400", 3, 2, "Q1' 2008", 35, 16, "DDR3 1066", 65, 2));
        intelCPUList.add(new CPU("Core i3-2370M", 2.4, 2, "Q1' 2012", 40, 16, "DDR3 1333", 35, 2, 4));
        intelCPUList.add(new CPU("Core i3-8145U", 2.1, 2, "Q3' 2018", 100, 64, "DDR4 2400", 15, 2, 3.9, 4));
        intelCPUList.add(new CPU("Core i3-10100", 3.6, 4, "Q2' 2020", 125, 128, "DDR4 2666", 65, 2, 4.3, 8));
        intelCPUList.add(new CPU("Core i5-2400", 3.1, 4, "Q1' 2011", 50, 32, "DDR3 1333", 95, 2, 3.4));
        intelCPUList.add(new CPU("Core i5-8500", 3, 6, "Q2' 2018", 185, 128, "DDR4 2666", 65, 2, 4.1));
    }

    public void sysOut(String string) {
        System.out.println(string);
    }
}