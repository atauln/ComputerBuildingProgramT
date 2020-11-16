package com.atom.cbp.terminal;

import com.atom.cbp.terminal.libraries.CPU;
import com.atom.cbp.terminal.libraries.Variables;

import java.util.*;

public class Main {
    Variables var = new Variables();
    Scanner scan = new Scanner(System.in).useDelimiter("\\n");

    public static void main(String[] args) {
        Variables var = new Variables();
        Main main = new Main();
        var.initLists();
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
                        break;
                    case "shop":
                        switch (command.get(1)) {
                            case "cpu":
                                sysOut("----------");
                                sysOut("Current balance: " + var.getBal());
                                switch (command.get(2)) {
                                    case "intel":
                                        sysOut("1. Intel Core 2 Duo E8400");
                                        sysOut("2. Intel Core i3-2370M");
                                        sysOut("3. Intel Core i3-8145U");
                                        sysOut("4. Intel Core i3-10100");
                                        sysOut("5. Intel Core i5-2400");
                                        sysOut("6. Intel Core i5-8500");
                                        sysOut("7. Intel Core i7-6700");
                                        sysOut("8. Intel Core i7-8700");
                                        sysOut("9. Intel Core i9-9900K");
                                    case "amd":
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
                                break;
                        }
                    case "details":
                        switch (command.get(1)) {
                            case "cpu":
                                switch (command.get(2)) {
                                    case "intel":
                                        CPU currentCPU = var.getIntelCPUList().get(Integer.parseInt(command.get(3)) - 1);
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
                                        break;
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

    public void sysOut(String string) {
        System.out.println(string);
    }
}