package com.atom.cbp.terminal;

import com.atom.cbp.terminal.libraries.*;

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
        while (true) {
            List<String> command = listenforCommand();
            if (command.get(0).equals("end")) {
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
            } else if (command.get(0).equals("bal") || command.get(0).equals("balance")) {
                sysOut("----------\nBalance: " + var.getBal() + "\n----------");
            } else if (command.get(0).equals("shop")) {
                try {
                    if (command.get(1).equals("cpu")) {
                        sysOut("----------\nCPUs:");
                        try {
                            if (command.get(2).equals("intel")) {
                                for (CPU cpu : intelCPUList) {
                                    sysOut(intelCPUList.indexOf(cpu) + 1 + ". " + cpu.getName() +" ($" + cpu.getPrice() + ")");
                                }
                            } else if (command.get(2).equals("amd")) {
                                for (CPU cpu : AMDCPUList) {
                                    sysOut(AMDCPUList.indexOf(cpu) + 1 + ". " + cpu.getName() +" ($" + cpu.getPrice() + ")");
                                }
                            } else {sysOut("Third arg was invalid!");}
                        } catch (Exception e) {
                            if (e instanceof IndexOutOfBoundsException) {
                                sysOut("-----------\nBrands:\nintel\namd\n----------");
                            }
                        }
                        sysOut("----------");
                    } else if (command.get(1).equals("motherboard")) {
                        sysOut("----------\nMotherboards:");
                        for (Motherboard motherboard : motherboardList) {
                            sysOut(motherboardList.indexOf(motherboard) + 1 + ". " + motherboard.getName() +" ($" + motherboard.getPrice() + ")");
                        }
                        sysOut("----------");
                    } else {sysOut("Second arg was invalid!");}
                } catch (Exception e) {
                    if (e instanceof IndexOutOfBoundsException) {
                        sysOut("----------\nTypes:\ncpu\n----------");
                    }
                }
            } else if (command.get(0).equals("details")) {
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
                            }  else if (command.get(2).equals("amd")) {
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
                            } else {sysOut("Third arg was invalid!");}
                        } catch (Exception e) {
                            if (e instanceof IndexOutOfBoundsException) {
                                sysOut("----------\nBrands:\nintel\namd\n----------");
                            }
                        }
                    } else if (command.get(1).equals("motherboard")) {
                        Motherboard motherboard = motherboardList.get(Integer.parseInt(command.get(2)) - 1);
                        sysOut("----------" + "\nMotherboard details: " + "\nName: " + motherboard.getName() + "\nSocket: " + motherboard.getSocket() + "\nSize: " + motherboard.getSize() + "\nUSB Ports: " + motherboard.getUsb2Ports() + " USB-2 ports, " + motherboard.getUsb3Ports() + " USB-3 ports, " + motherboard.getUsbCPorts() + " USB-C ports" + "\nOutputs: " + motherboard.getNumOutputs() + "\nPCIe Slots: " + motherboard.getPcieSlots() + "\nRAM Slots: " + motherboard.getRamSlots() + " (with " + motherboard.getMaxMemory() + " gb of maximum memory)" + "\nNVME Slots: " + motherboard.getNvmeSlots() + "\nSATA Ports: " + motherboard.getSataSlots() + "\nIntegrated WiFi: " + motherboard.isIntWiFi() + "\nIntegrated Bluetooth: " + motherboard.isIntBT() + "\nPrice: $" + motherboard.getPrice() + "\n----------");
                    } else {sysOut("Second arg was invalid!");}
                } catch (Exception e) {
                    if (e instanceof IndexOutOfBoundsException) {
                        sysOut("----------\nTypes:\ncpu\n----------");
                    }
                }
            } else if (command.get(0).equals("startbuild")) {
                List<Object> obj = pcBuild();
            } else {sysOut("First arg was invalid!");}
        }
    }

    public List<Object> pcBuild() {
        List<Object> emptyList = new ArrayList<>();
        List<Object> pcPartsList = new ArrayList<>();

        while (pcPartsList.size() != 1) {
            sysOut("**********\nSelect your CPU:");
            for (CPU cpu : cpuList) {
                sysOut((cpuList.indexOf(cpu) + 1) + ". " + cpu.getName() + " ($" + cpu.getPrice() + ")");
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
    public void setIntelCPUList(List<CPU> intelCPUList) {
        this.intelCPUList = intelCPUList;
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