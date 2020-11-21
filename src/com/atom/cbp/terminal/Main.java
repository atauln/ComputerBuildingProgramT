package com.atom.cbp.terminal;

import com.atom.cbp.terminal.libraries.*;
import com.atom.cbp.terminal.libraries.Drives.*;

import java.util.*;

public class Main {

    //Local variable declaration
    Variables var = new Variables();
    Scanner scan = new Scanner(System.in).useDelimiter("\\n");
    List<CPU> intelCPUList = new ArrayList<>();
    List<CPU> AMDCPUList = new ArrayList<>();
    List<CPU> cpuList = new ArrayList<>();
    List<Motherboard> motherboardList = new ArrayList<>();
    List<GPU> gpuList = new ArrayList<>();
    List<Drive> driveList = new ArrayList<>();
    List<SSD> ssdList = new ArrayList<>();
    List<HDD> hddList = new ArrayList<>();
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
        main.setGpuList(var.getGpuList());
        main.setSsdList(var.getSsdList());
        main.setHddList(var.getHddList());
        main.setDriveList(var.getDriveList());
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
            if (command.get(0).equals("end") || command.get(0).equals("]end")) {
                break;
            }
            //checking command, and outputting result
            if (command.get(0).equals("help") || command.get(0).equals("]help")) {
                sysOut("----------");
                sysOut("Commands currently available: ");
                sysOut("startbuild - start building your pc");
                sysOut("stopbuild - remove current pc");
                sysOut("shop [type] [brand] - look at the current catalog of items");
                sysOut("details [type] [brand] [#] - get details for an item");
                sysOut("----------");
            } else if (command.get(0).equals("bal") || command.get(0).equals("balance") || command.get(0).equals("]bal") || command.get(0).equals("]balance")) {
                sysOut("----------\nBalance: " + var.getBal() + "\n----------");
            } else if (command.get(0).equals("shop") || command.get(0).equals("]shop")) {
                try {
                    if (command.get(1).equals("cpu")) {
                        sysOut("----------\nCPUs:");
                        try {
                            if (command.get(2).equals("intel")) {
                                for (CPU cpu : intelCPUList) {
                                    sysOut(intelCPUList.indexOf(cpu) + 1 + ". " + cpu.getName() + " ($" + cpu.getPrice() + ")");
                                }
                            } else if (command.get(2).equals("amd")) {
                                for (CPU cpu : AMDCPUList) {
                                    sysOut(AMDCPUList.indexOf(cpu) + 1 + ". " + cpu.getName() + " ($" + cpu.getPrice() + ")");
                                }
                            } else {
                                sysOut("Third arg was invalid!");
                            }
                        } catch (Exception e) {
                            if (e instanceof IndexOutOfBoundsException) {
                                sysOut("-----------\nBrands:\nintel\namd\n----------");
                            }
                        }
                        sysOut("----------");
                    } else if (command.get(1).equals("motherboard")) {
                        sysOut("----------\nMotherboards:");
                        for (Motherboard motherboard : motherboardList) {
                            sysOut(motherboardList.indexOf(motherboard) + 1 + ". " + motherboard.getName() + " ($" + motherboard.getPrice() + ")");
                        }
                        sysOut("----------");
                    } else if (command.get(1).equals("gpu")) {
                        sysOut("----------\nGPUs:");
                        for (GPU gpu : gpuList) {
                            sysOut(gpuList.indexOf(gpu) + 1 + ". " + gpu.getName() + " ($" + gpu.getPrice() + ")");
                        }
                        sysOut("----------");
                    } else {
                        sysOut("Second arg was invalid!");
                    }
                } catch (Exception e) {
                    if (e instanceof IndexOutOfBoundsException) {
                        sysOut("----------\nTypes:\ncpu\nmotherboard\ngpu\n----------");
                    }
                }
            } else if (command.get(0).equals("details") || command.get(0).equals("]details")) {
                try {
                    if (command.get(1).equals("cpu")) {
                        try {
                            if (command.get(2).equals("intel")) {
                                try {
                                    currentCPU = intelCPUList.get(Integer.parseInt(command.get(3)) - 1);
                                    getCPUdetails(currentCPU);
                                } catch (Exception e) {
                                    if (e instanceof IndexOutOfBoundsException) {
                                        sysOut("Please use a number for the details of an item!");
                                    }
                                }
                            } else if (command.get(2).equals("amd")) {
                                try {
                                    currentCPU = AMDCPUList.get(Integer.parseInt(command.get(3)) - 1);
                                    getCPUdetails(currentCPU);
                                } catch (Exception e) {
                                    if (e instanceof IndexOutOfBoundsException) {
                                        sysOut("Please use a number for the details of an item!");
                                    }
                                }
                            } else {
                                sysOut("Third arg was invalid!");
                            }
                        } catch (Exception e) {
                            if (e instanceof IndexOutOfBoundsException) {
                                sysOut("----------\nBrands:\nintel\namd\n----------");
                            }
                        }
                    } else if (command.get(1).equals("motherboard")) {
                        try {
                            Motherboard motherboard = motherboardList.get(Integer.parseInt(command.get(2)) - 1);
                            sysOut("----------" + "\nMotherboard details: " + "\nName: " + motherboard.getName() + "\nSocket: " + motherboard.getSocket() + "\nSize: " + motherboard.getSize() + "\nUSB Ports: " + motherboard.getUsb2Ports() + " USB-2 ports, " + motherboard.getUsb3Ports() + " USB-3 ports, " + motherboard.getUsbCPorts() + " USB-C ports" + "\nOutputs: " + motherboard.getNumOutputs() + "\nPCIe Slots: " + motherboard.getPcieSlots() + "\nRAM Slots: " + motherboard.getRamSlots() + " (with " + motherboard.getMaxMemory() + " gb of maximum memory)" + "\nNVME Slots: " + motherboard.getNvmeSlots() + "\nSATA Ports: " + motherboard.getSataSlots() + "\nIntegrated WiFi: " + motherboard.isIntWiFi() + "\nIntegrated Bluetooth: " + motherboard.isIntBT() + "\nPrice: $" + motherboard.getPrice() + "\n----------");
                        } catch (Exception e) {
                            if (e instanceof IndexOutOfBoundsException) {
                                sysOut("Please use a number for the details of the item!");
                            }
                        }
                    } else if (command.get(1).equals("gpu")) {
                        try {
                            GPU gpu = gpuList.get(Integer.parseInt(command.get(2)) - 1);
                            sysOut("----------" + "\nGPU Details:" + "\nName: " + gpu.getName() + "\nRelease Date: " + gpu.getReleaseDate() + "\nCore clock: " + gpu.getBaseClock() + " MHz (Boost Clock: " + gpu.getBoostClock() + " MHz)" + "\nMemory: " + gpu.getMemorySize() + "GB " + gpu.getMemoryType() + "\nCores: " + gpu.getCores() + "\nPrice: $" + gpu.getPrice() + "\n----------");
                        } catch (Exception e) {
                            if (e instanceof IndexOutOfBoundsException) {
                                sysOut("Please use a number for the details of the item!");
                            }
                        }
                    } else {
                        sysOut("Second arg was invalid!");
                    }
                } catch (Exception e) {
                    if (e instanceof IndexOutOfBoundsException) {
                        sysOut("----------\nTypes:\ncpu\nmotherboard\ngpu\n----------");
                    }
                }
            } else if (command.get(0).equals("startbuild") || command.get(0).equals("]startbuild")) {
                List<Object> obj = pcBuild();
            } else {
                sysOut("First arg was invalid!");
            }
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
            String userCommand = scan.nextLine();
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
            if (m.getSocket().equals(((CPU) pcPartsList.get(0)).getSocket())) {
                motherboardListA.add(m);
            }
        }
        while (pcPartsList.size() != 2) {
            sysOut("**********\nSelect your motherboard:");
            for (Object m : motherboardListA) {
                sysOut(motherboardListA.indexOf(m) + 1 + ". " + ((Motherboard) m).getName() + " ($" + ((Motherboard) m).getPrice() + ")");
            }
            sysOut("**********");
            String userCommand = scan.nextLine();
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
        String[] ramSpeeds = {"DDR3-800", "DDR3-1066", "DDR3-1333", "DDR3-1600", "DDR4-2400", "DDR4-2666", "DDR4-2933", "DDR4-3000", "DDR4-3200", "DDR4-3600", "DDR4-4000", "DDR4-4400"};
        List<String> chosenSpeeds = new ArrayList<>();
        String ramSpeedChoice = "";
        for (String s : ramSpeeds) {
            int speed = 0;
            if (s.length() == 9) {
                speed = Integer.parseInt(s.substring(s.length() - 4));
            } else if (s.length() == 8) {
                speed = Integer.parseInt(s.substring(s.length() - 3));
            }
            if (speed <= Integer.parseInt(((CPU) pcPartsList.get(0)).getMemoryType().substring(((CPU) pcPartsList.get(0)).getMemoryType().length() - 4))) {
                chosenSpeeds.add(s);
            }
        }
        List<String> ramConfig = new ArrayList<>();
        for (int ramModules = 1; ramModules <= ((Motherboard) pcPartsList.get(1)).getRamSlots(); ramModules = ramModules * 2) {
            for (int ramCapacity = 1; ramCapacity <= ((Motherboard) pcPartsList.get(1)).getMaxMemory() && ramCapacity <= ((CPU) pcPartsList.get(0)).getMaxMemory(); ramCapacity = ramCapacity * 2) {
                ramConfig.add(ramModules + "x" + ramCapacity);
            }
        }
        while (pcPartsList.size() != 3) {
            sysOut("**********\nSelect your RAM speed:");
            for (String s : chosenSpeeds) {
                sysOut(chosenSpeeds.indexOf(s) + 1 + ". " + s + " ($" + calculateRAMPrices(s) + " per gb)");
            }
            sysOut("**********");
            String userCommand = scan.nextLine();
            if (userCommand.equals("end") || userCommand.equals("stop")) {
                return emptyList;
            }
            try {
                ramSpeedChoice = chosenSpeeds.get(Integer.parseInt(userCommand) - 1);
            } catch (Exception e) {
                sysOut("Please type a valid integer!");
            }
            sysOut("**********\nSelect your RAM configuration: ");
            for (String s : ramConfig) {
                sysOut(ramConfig.indexOf(s) + 1 + ". " + s + "gb" + " ($" + Math.round(calculateRAMPrices(ramSpeedChoice) * Character.getNumericValue(s.toCharArray()[0]) * Integer.parseInt(s.substring(s.length() - (s.length() - 2)))) + ")");
            }
            sysOut("**********");
            userCommand = scan.nextLine();
            if (userCommand.equals("stop") || userCommand.equals("end")) {
                return emptyList;
            }
            try {
                RAM[] rams = new RAM[ramConfig.get(Integer.parseInt(userCommand)).toCharArray()[0]];
                for (int i = 1; i <= (ramConfig.get(Integer.parseInt(userCommand)).toCharArray()[0]); i++) {
                    rams[i - 1] = new RAM(ramSpeedChoice.substring(0, 4), Integer.parseInt(ramSpeedChoice.substring(ramSpeedChoice.length() - (ramSpeedChoice.length() - 5))), Integer.parseInt(ramConfig.get(Integer.parseInt(userCommand)).substring(ramConfig.get(Integer.parseInt(userCommand)).length() - (ramConfig.get(Integer.parseInt(userCommand)).length() - 2))));
                }
                pcPartsList.add(rams);
            } catch (Exception e) {
                if (e instanceof IndexOutOfBoundsException) {
                    sysOut("Please type a valid integer!");
                }
            }
        }
        while (pcPartsList.size() != 4) {
            GPU chosenGPU = null;
            sysOut("**********\nSelect your GPU: ");
            for (GPU gpu : gpuList) {
                sysOut(gpuList.indexOf(gpu) + 1 + ". " + gpu.getName() + " ($" + gpu.getPrice() + ")");
            }
            sysOut("**********");
            String userCommand = scan.nextLine();
            if (userCommand.equals("stop") || userCommand.equals("end")) {
                return emptyList;
            }
            try {
                chosenGPU = gpuList.get(Integer.parseInt(userCommand) - 1);
            } catch (Exception e) {
                if (e instanceof IndexOutOfBoundsException) {
                    sysOut("Please type a valid integer!");
                }
            }
            sysOut("**********\nHow many GPUs would you like?: (max: " + ((Motherboard) pcPartsList.get(1)).getPcieSlots() + ")");
            userCommand = scan.nextLine();
            try {
                if (0 < Integer.parseInt(userCommand) && Integer.parseInt(userCommand) <= ((Motherboard) pcPartsList.get(1)).getPcieSlots()) {
                    GPU[] gpus = new GPU[Integer.parseInt(userCommand)];
                    for (int i=1; i <= Integer.parseInt(userCommand); i++) {
                        gpus[i-1] = chosenGPU;
                    }
                    pcPartsList.add(gpus);
                }
            } catch (Exception e) {
                if (e instanceof IndexOutOfBoundsException) {
                    sysOut("Please type a valid integer!");
                }
            }
        }
        List<SSD> nvmeList = new ArrayList<>();
        List<Drive> sataList = new ArrayList<>();
        List<SSD> chosenNVMeList = new ArrayList<>();
        List<Drive> chosenSATAList = new ArrayList<>();
        List<Drive> chosenDriveList = new ArrayList<>();
        for (Drive drive : driveList) {
            if (drive instanceof SSD) {
                if (((SSD) drive).getInterf().equals("NVMe")) {
                    nvmeList.add((SSD) drive);
                } else if (((SSD) drive).getInterf().equals("SATA")) {
                    sataList.add((SSD) drive);
                }
            } else if (drive instanceof HDD) {
                sataList.add((HDD) drive);
            } else {
                sysOut("Drive unable to be added!");
            }
        }
        while (pcPartsList.size() != 5) {
            int nvmeSlots = ((Motherboard) pcPartsList.get(1)).getNvmeSlots() - chosenNVMeList.size();
            int sataSlots = ((Motherboard) pcPartsList.get(1)).getSataSlots() - chosenSATAList.size();
            Drive chosenDrive = null;
            if (nvmeSlots == 0) {
                driveList.removeAll(nvmeList);
            }
            if (sataSlots == 0) {
                driveList.removeAll(sataList);
            }
            sysOut("**********\nChoose a drive: (" + sataSlots + " SATA slots, " + nvmeSlots + " NVMe slots)");
            for (Drive drive : driveList) {
                if (drive instanceof SSD) {
                    sysOut(driveList.indexOf(drive) + 1 + ". " + drive.getName() + " [SSD]");
                } else if (drive instanceof HDD) {
                    sysOut(driveList.indexOf(drive) + 1 + ". " + drive.getName() + " [HDD]");
                }
            }
            sysOut("**********\nYou can also type 'done' to finish.");
            String userCommand = scan.nextLine();
            if (userCommand.equals("stop") || userCommand.equals("end")) {
                return emptyList;
            }
            if (userCommand.equals("done")) {
                if (nvmeList.size() >= 1 || sataList.size() >= 1) {
                    chosenDriveList.addAll(chosenNVMeList);
                    chosenDriveList.addAll(chosenSATAList);
                    pcPartsList.add(chosenDriveList);
                    break;
                }
            }
            try {
                chosenDrive = driveList.get(Integer.parseInt(userCommand) - 1);
            } catch (Exception e) {
                sysOut(e.toString());
            }
            sysOut("**********\nSelect the capacity for your drive: ");
            for (int capacityOpt : chosenDrive.getCapacities()) {
                sysOut(chosenDrive.getCapacities().indexOf(capacityOpt) + 1 + ". " + capacityOpt + "GB"); //ADD PRICE
            }
            sysOut("**********");
            userCommand = scan.nextLine();
            try {
                chosenDrive.setChosenCapacity(chosenDrive.getCapacities().get(Integer.parseInt(userCommand) - 1));
            } catch (Exception e) {
                sysOut(e.toString());
            }
            if (chosenDrive instanceof SSD) {
                if (((SSD) chosenDrive).getInterf().equals("NVMe")) {
                    sysOut("**********\nSelect the amount: (" + nvmeSlots + " NVMe slots)");
                } else {
                    sysOut("**********\nSelect the amount: (" + sataSlots + " SATA slots)");
                }
            } else {
                sysOut("**********\nSelect the amount: (" + sataSlots + " SATA slots)");
            }
            userCommand = scan.nextLine();
            try {
                if (chosenDrive instanceof SSD) {
                    if (((SSD) chosenDrive).getInterf().equals("NVMe")) {
                        if (Integer.parseInt(userCommand) > 0 && Integer.parseInt(userCommand) <= nvmeSlots) {
                            for (int i=1; i <= Integer.parseInt(userCommand); i++) {
                                chosenNVMeList.add((SSD) chosenDrive);
                            }
                        }
                    } else {
                        if (Integer.parseInt(userCommand) > 0 && Integer.parseInt(userCommand) <= sataSlots) {
                            for (int i=1; i <= Integer.parseInt(userCommand); i++) {
                                chosenSATAList.add(chosenDrive);
                            }
                        }
                    }
                } else {
                    if (Integer.parseInt(userCommand) > 0 && Integer.parseInt(userCommand) <= sataSlots) {
                        for (int i=1; i <= Integer.parseInt(userCommand); i++) {
                            chosenSATAList.add(chosenDrive);
                        }
                    }
                }
            } catch (Exception e) {
                sysOut(e.toString());
            }
        }
        sysOut("**********\nPC Details: " + "\nCPU: " + ((CPU) pcPartsList.get(0)).getName() + "\nMotherboard: " + ((Motherboard) pcPartsList.get(1)).getName() + "\nRAM: " + ((RAM[]) pcPartsList.get(2)).length + "x" + (((RAM[]) pcPartsList.get(2))[0]).getCapacity() + "GB " + (((RAM[]) pcPartsList.get(2))[0]).getType() + "-" + (((RAM[]) pcPartsList.get(2))[0]).getSpeed() + "\nGPU(s): " + ((GPU[]) pcPartsList.get(3))[0].getName() + " (" + ((GPU[]) pcPartsList.get(3)).length + ")\nDrives:");
        for (Drive drive : ((List<Drive>) pcPartsList.get(4))) {
            if (drive instanceof SSD) {
                if (((SSD) drive).getInterf().equals("NVMe")) {
                    sysOut(" - " + drive.getName() + " [NVMe | SSD | " + drive.getChosenCapacity() + "GB]");
                } else {
                    sysOut(" - " + drive.getName() + " [SATA | SSD | " + drive.getChosenCapacity() + "GB]");
                }
            } else {
                sysOut(" - " + drive.getName() + " [SATA | HDD | " + drive.getChosenCapacity() + "GB]");
            }
        }
        sysOut("**********");
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
        return Arrays.asList(scan.nextLine().split(" "));
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
    public void setGpuList(List<GPU> gpuList) {
        this.gpuList = gpuList;
    }
    public double calculateRAMPrices(String s) {
        String sub = null;
        if (s.length() == 9) {
            sub = s.substring(s.length() - 4);
        } else if (s.length() == 8) {
            sub = s.substring(s.length() - 3);
        }
        assert sub != null;
        int su = Integer.parseInt(sub);
        return Math.round(0.0025 * Math.pow(su, 1.01));
    }
    public void getCPUdetails(CPU currentCPU) {
        sysOut("----------");
        sysOut("CPU Details");
        sysOut("Name: " + currentCPU.getName());
        sysOut("Socket: " + currentCPU.getSocket());
        sysOut("Architecture/Family: " + currentCPU.getArchitecture());
        sysOut("Core Count: " + currentCPU.getCoreCount());
        if (currentCPU.getHyperThreading() > currentCPU.getCoreCount()) {
            sysOut("Hyperthreading: true (" + currentCPU.getHyperThreading() + " cores)");
        } else {
            sysOut("Hyperthreading: false");
        }
        sysOut("Processing Speed: " + currentCPU.getGhz() + " GHz");
        if (currentCPU.getTurboBoostTo() > currentCPU.getGhz()) {
            sysOut("Turbo Boost: true (boosts up to " + currentCPU.getTurboBoostTo() + " GHz)");
        } else {
            sysOut("Turbo Boost: false");
        }
        sysOut("Overclockable: " + currentCPU.isOverclockable());
        sysOut("Memory: Max of " + currentCPU.getMaxMemory() + " GB\nMemory Type: " + currentCPU.getMemoryType());
        sysOut("TDP: " + currentCPU.getTDP() + "W");
        sysOut("Release Date: " + currentCPU.getReleaseDate());
        sysOut("Price: $" + currentCPU.getPrice());
        sysOut("----------");
    }
    public void setDriveList(List<Drive> driveList) {
        this.driveList = driveList;
    }
    public void setSsdList(List<SSD> ssdList) {
        this.ssdList = ssdList;
    }
    public void setHddList(List<HDD> hddList) {
        this.hddList = hddList;
    }
}