package com.atom.cbp.terminal;

import com.atom.cbp.terminal.libraries.CPU;
import com.atom.cbp.terminal.libraries.Motherboard;
import com.atom.cbp.terminal.libraries.Variables;

import java.rmi.MarshalledObject;
import java.util.*;

public class Main {

    //Local variable declaration
    Variables var = new Variables();
    Scanner scan = new Scanner(System.in).useDelimiter("\\n");
    List<CPU> intelCPUList = new ArrayList<>();
    List<CPU> AMDCPUList = new ArrayList<>();
    List<CPU> cpuList = new ArrayList<>();
    List<Motherboard> motherboardList = new ArrayList<>();
    CPU currentCPU;

    //Main class
    public static void main(String[] args) {
        Variables var = new Variables();
        Main main = new Main();
        var.initLists();
        main.setIntelCPUList(var.getIntelCPUList());
        main.setAMDCPUList(var.getAmdCPUList());
        main.setCpuList(var.getCPUList());
        main.setMotherboardList(var.getMotherboardList());
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
                try {
                    if (command.get(1).equals("cpu")) {
                        sysOut("----------");
                        sysOut("Current balance: " + var.getBal());
                        try {
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
                        } catch (Exception e) {
                            if (e instanceof IndexOutOfBoundsException) {
                                sysOut("-----------\nBrands:\nintel\namd\n----------");
                            }
                        }
                        sysOut("----------");
                    }
                } catch (Exception e) {
                    if (e instanceof IndexOutOfBoundsException) {
                        sysOut("----------\nTypes:\ncpu\n----------");
                    }
                }
            }
            if (command.get(0).equals("details")) {
                try {
                    if (command.get(1).equals("cpu")) {
                        try {
                            if (command.get(2).equals("intel")) {
                                try {
                                    CPU currentCPU = intelCPUList.get(Integer.parseInt(command.get(3)) - 1);
                                } catch (Exception e) {
                                    if (e instanceof  IndexOutOfBoundsException) {
                                        sysOut("Please use a number for the details of an item!");
                                    }
                                }
                            }
                            else if (command.get(2).equals("amd")) {
                                try {
                                    currentCPU = AMDCPUList.get(Integer.parseInt(command.get(3)) - 1);
                                } catch (Exception e) {
                                    if (e instanceof IndexOutOfBoundsException) {
                                        sysOut("Please use a number for the details of an item!");
                                    }
                                }
                                sysOut("----------");
                                sysOut("CPU Details");
                                sysOut("Name: " + currentCPU.getName());
                                sysOut("Socket: " + currentCPU.getSocket());
                                sysOut("Architecture/Family: " + currentCPU.getArchitecture());
                                sysOut("Core Count: " + currentCPU.getCoreCount());
                                if (currentCPU.getHyperThreading() > currentCPU.getCoreCount()) {sysOut("Hyperthreading: true (" + currentCPU.getHyperThreading() + " cores)");}
                                else {sysOut("Hyperthreading: false");}
                                sysOut("Processing Speed: " + currentCPU.getGhz() + " GHz");
                                if (currentCPU.getTurboBoostTo() > currentCPU.getGhz()) {sysOut("Turbo Boost: true (boosts up to " + currentCPU.getTurboBoostTo() + " GHz)");}
                                else {sysOut("Turbo Boost: false");}
                                sysOut("Overclockable: " + currentCPU.isOverclockable());
                                sysOut("Memory: Max of " + currentCPU.getMaxMemory() + " GB\nMemory Type: " + currentCPU.getMemoryType());
                                sysOut("TDP: " + currentCPU.getTDP() + "W");
                                sysOut("Release Date: " + currentCPU.getReleaseDate());
                                sysOut("Price: $" + currentCPU.getPrice());
                                sysOut("----------");
                            }
                        } catch (Exception e) {
                            if (e instanceof IndexOutOfBoundsException) {
                                sysOut("----------\nBrands:\nintel\namd\n----------");
                            }
                        }
                    }
                } catch (Exception e) {
                    if (e instanceof IndexOutOfBoundsException) {
                        sysOut("----------\nTypes:\ncpu\n----------");
                    }
                }
            }
            if (command.get(0).equals("startbuild")) {
                List<Object> obj = pcBuild();
            }
        }
    }

    public List<Object> pcBuild() {
        List<Object> emptyList = new ArrayList<>();
        List<Object> pcPartsList = new ArrayList<>();

        while (pcPartsList.size() != 1) {
            sysOut("**********\nSelect your CPU:");
            for (CPU cpu : cpuList) {
                sysOut((cpuList.indexOf((Object) cpu) + 1) + ". " + cpu.getName() + " ($" + cpu.getPrice() + ")");
            }
            sysOut("**********");
            String userCommand = scan.next();
            if (userCommand.equals("stop") || userCommand.equals("end")) {
                return emptyList;
            }
            try {
                pcPartsList.add(cpuList.get(Integer.parseInt(userCommand) - 1));
            } catch (Exception e) {
                if (e instanceof IndexOutOfBoundsException) {
                    sysOut("Please type a valid integer!");
                }
            }
        }
        List<Object> motherboardListA = new ArrayList<>();
        for (Motherboard m : motherboardList) {
            if (m.getSocket().equals( ( (CPU) pcPartsList.get(0) ).getSocket() ) ) {
                motherboardListA.add(m);
            }
        }
        while (pcPartsList.size() != 2) {
            sysOut("**********\nSelect your motherboard:");
            for (Object m : motherboardListA) {
                sysOut(motherboardListA.indexOf(m) + 1 + ". " + ((Motherboard) m).getName() + " ($" + ((Motherboard) m).getPrice() + ")");
            }
            sysOut("**********");
            String userCommand = scan.next();
            if (userCommand.equals("stop") || userCommand.equals("end")) {
                return emptyList;
            }
            try {
                pcPartsList.add(motherboardListA.get(Integer.parseInt(userCommand) - 1));
            } catch (Exception e) {
                if (e instanceof IndexOutOfBoundsException) {
                    sysOut("Please type a valid integer!");
                }
            }
        }
        return pcPartsList;
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
    public void setMotherboardList(List<Motherboard> motherboardList) {
        this.motherboardList = motherboardList;
    }
    public void setCpuList(List<CPU> cpuList) {
        this.cpuList = cpuList;
    }
}