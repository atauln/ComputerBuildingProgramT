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
    List<Case> caseList = new ArrayList<>();
    List<PowerSupply> powerSupplyList = new ArrayList<>();
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
        main.setCaseList(var.getCaseList());
        main.setPowerSupplyList(var.getPowerSupplyList());
        while (true) {
            var.nextDay();
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
                sysOut("balance - check your balance");
                sysOut("list - list your pcs");
                sysOut("shop [type] [brand] - look at the current catalog of items");
                sysOut("details [type] [brand] [#] - get details for an item");
                sysOut("----------");
            } else if (command.get(0).equals("bal") || command.get(0).equals("balance") || command.get(0).equals("]bal") || command.get(0).equals("]balance")) {
                sysOut("----------\nBalance: " + var.getBal() + "\n----------");
            } else if (command.get(0).equals("shop") || command.get(0).equals("]shop")) {
                try {
                    switch (command.get(1)) {
                        case "cpu":
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
                            break;
                        case "motherboard":
                            sysOut("----------\nMotherboards:");
                            for (Motherboard motherboard : motherboardList) {
                                sysOut(motherboardList.indexOf(motherboard) + 1 + ". " + motherboard.getName() + " ($" + motherboard.getPrice() + ")");
                            }
                            sysOut("----------");
                            break;
                        case "gpu":
                            sysOut("----------\nGPUs:");
                            for (GPU gpu : gpuList) {
                                sysOut(gpuList.indexOf(gpu) + 1 + ". " + gpu.getName() + " ($" + gpu.getPrice() + ")");
                            }
                            sysOut("----------");
                            break;
                        case "drive":
                            try {
                                if (command.get(2).equals("ssd")) {
                                    for (SSD ssd : ssdList) {
                                        sysOut(ssdList.indexOf(ssd) + 1 + ". " + ssd.getName() + " [" + ssd.getInterf() + " | SSD]");
                                    }
                                } else if (command.get(2).equals("hdd")) {
                                    for (HDD hdd : hddList) {
                                        sysOut(hddList.indexOf(hdd) + 1 + ". " + hdd.getName() + " [SATA | HDD]");
                                    }
                                }
                            } catch (Exception e) {
                                sysOut("Options: ssd, hdd");
                            }
                            break;
                        case "case":
                            for (Case chosenCase : caseList) {
                                sysOut(caseList.indexOf(chosenCase) + 1 + ". " + chosenCase.getName() + " (" + chosenCase.getManufacturer() + " | $" + chosenCase.getPrice() + ")");
                            }
                            break;
                        case "psu":
                            for (PowerSupply psu : powerSupplyList) {
                                sysOut(powerSupplyList.indexOf(psu) + 1 + ". " + psu.getName() + " (" + psu.getType() + " | " + psu.getRating() + ")");
                            }
                            break;
                        default:
                            sysOut("Second arg was invalid!");
                            break;
                    }
                } catch (Exception e) {
                    if (e instanceof IndexOutOfBoundsException) {
                        sysOut("----------\nTypes:\ncpu\nmotherboard\ngpu\ndrive\ncase\npsu\n----------");
                    }
                }
            } else if (command.get(0).equals("details") || command.get(0).equals("]details")) {
                try {
                    switch (command.get(1)) {
                        case "cpu":
                            try {
                                if (command.get(2).equals("intel")) {
                                    try {
                                        currentCPU = intelCPUList.get(Integer.parseInt(command.get(3)) - 1);
                                        getCPUDetails(currentCPU);
                                    } catch (Exception e) {
                                        if (e instanceof IndexOutOfBoundsException) {
                                            sysOut("Please use a number for the details of an item!");
                                        }
                                    }
                                } else if (command.get(2).equals("amd")) {
                                    try {
                                        currentCPU = AMDCPUList.get(Integer.parseInt(command.get(3)) - 1);
                                        getCPUDetails(currentCPU);
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
                            break;
                        case "motherboard":
                            try {
                                Motherboard motherboard = motherboardList.get(Integer.parseInt(command.get(2)) - 1);
                                sysOut("----------" +
                                        "\nMotherboard details: " +
                                        "\nName: " + motherboard.getName() +
                                        "\nSocket: " + motherboard.getSocket() +
                                        "\nSize: " + motherboard.getSize() +
                                        "\nUSB Ports: " + motherboard.getUsb2Ports() + " USB-2 ports, " + motherboard.getUsb3Ports() + " USB-3 ports, " + motherboard.getUsbCPorts() + " USB-C ports" +
                                        "\nOutputs: " + motherboard.getNumOutputs() +
                                        "\nPCIe Slots: " + motherboard.getPcieSlots() +
                                        "\nRAM Slots: " + motherboard.getRamSlots() + " (with " + motherboard.getMaxMemory() + " gb of maximum memory)" +
                                        "\nNVME Slots: " + motherboard.getNvmeSlots() +
                                        "\nSATA Ports: " + motherboard.getSataSlots() +
                                        "\nIntegrated WiFi: " + motherboard.isIntWiFi() +
                                        "\nIntegrated Bluetooth: " + motherboard.isIntBT() +
                                        "\nPrice: $" + motherboard.getPrice() +
                                        "\n----------");
                            } catch (Exception e) {
                                if (e instanceof IndexOutOfBoundsException) {
                                    sysOut("Please use a number for the details of the item!");
                                }
                            }
                            break;
                        case "gpu":
                            try {
                                GPU gpu = gpuList.get(Integer.parseInt(command.get(2)) - 1);
                                sysOut("----------" +
                                        "\nGPU Details:" +
                                        "\nName: " + gpu.getName() +
                                        "\nRelease Date: " + gpu.getReleaseDate() +
                                        "\nCore clock: " + gpu.getBaseClock() + " MHz (Boost Clock: " + gpu.getBoostClock() + " MHz)" +
                                        "\nMemory: " + gpu.getMemorySize() + "GB " + gpu.getMemoryType() +
                                        "\nCores: " + gpu.getCores() +
                                        "\nPrice: $" + gpu.getPrice() +
                                        "\n----------");
                            } catch (Exception e) {
                                if (e instanceof IndexOutOfBoundsException) {
                                    sysOut("Please use a number for the details of the item!");
                                }
                            }
                            break;
                        case "drive":
                            try {
                                if (command.get(2).equals("ssd")) {
                                    try {
                                        SSD ssd = ssdList.get(Integer.parseInt(command.get(3)) - 1);
                                        sysOut("---------\nSSD:" +
                                                "\nName: " + ssd.getName() +
                                                "\nInterface: " + ssd.getInterf() +
                                                "\nRead Speeds: " + ssd.getReadSpeed() +
                                                "\nWrite Speeds: " + ssd.getWriteSpeed() +
                                                "\nCapacities: ");
                                        for (int cap : ssd.getCapacities()) {
                                            sysOut(" - " + cap + "GB ($" + calculatePriceDrive(ssd, cap) + ")");
                                        }
                                    } catch (Exception e) {
                                        sysOut("Please use a valid integer!");
                                    }
                                } else if (command.get(2).equals("hdd")) {
                                    try {
                                        HDD hdd = hddList.get(Integer.parseInt(command.get(3)) - 1);
                                        sysOut("----------\nHDD:" +
                                                "\nName: " + hdd.getName() +
                                                "\nInterface: SATA\nRPM: " + hdd.getRpm() +
                                                "\nCapacities: ");
                                        for (int cap : hdd.getCapacities()) {
                                            sysOut(" - " + cap + "GB ($" + calculatePriceDrive(hdd, cap) + ")");
                                        }
                                    } catch (Exception e) {
                                        sysOut("Please use a valid integer!");
                                    }
                                }
                            } catch (Exception e) {
                                sysOut("Options: ssd, hdd");
                            }
                            break;
                        case "case":
                            try {
                                Case chosenCase = caseList.get(Integer.parseInt(command.get(2)) - 1);
                                sysOut("----------\nCase Details: " +
                                        "\nName: " + chosenCase.getName() +
                                        "\nManufacturer: " + chosenCase.getManufacturer() +
                                        "\nSide panel: " + chosenCase.getSidePanel() +
                                        "\nType: " + chosenCase.getType() +
                                        "\nUSB ports: (" + chosenCase.getUsb2Ports() + " USB-2 ports, " + chosenCase.getUsb3Ports() + " USB-3 ports, " + chosenCase.getUsbCPorts() + " USB-C ports)" +
                                        "\nPrice: $" + chosenCase.getPrice());
                            } catch (Exception e) {
                                sysOut("Please use a valid integer!");
                            }
                            break;
                        case "psu":
                            try {
                                PowerSupply psu = powerSupplyList.get(Integer.parseInt(command.get(2)) - 1);
                                sysOut("----------\nPSU Details: " +
                                        "\nName: " + psu.getName() +
                                        "\nRating: " + psu.getRating() +
                                        "\nType: " + psu.getType() +
                                        "\nWattages: ");
                                for (int wattage : psu.getWatts()) {
                                    sysOut(" - " + wattage + "W");
                                }
                            } catch (Exception e) {
                                sysOut("Please use a valid integer!");
                            }
                            break;
                        default:
                            sysOut("Second arg was invalid!");
                            break;
                    }
                } catch (Exception e) {
                    if (e instanceof IndexOutOfBoundsException) {
                        sysOut("----------\nTypes:\ncpu\nmotherboard\ngpu\ndrive\ncase\n----------");
                    }
                }
            } else if (command.get(0).equals("startbuild") || command.get(0).equals("]startbuild")) {
                Object builtPC = pcBuild();
                if (builtPC instanceof Computer) {
                    ((Computer) builtPC).setDay(day);
                    var.computerList.add((Computer) builtPC);
                    break;
                }
            } else if (command.get(0).equals("list")) {
                var.listPCs();
            } else if (command.get(0).equals("sell")) {
                try {
                    sysOut("You are selling PC #" + (Integer.parseInt(command.get(1)) - 1) + ". You will get $" + Math.round(var.getComputerList().get(Integer.parseInt(command.get(1)) - 1).getPrice()*1.15) + ". Are you sure? (Y/N)");
                    String userCommand = scan.nextLine();
                    if (userCommand.equals("y") || userCommand.equals("yes")) {
                        var.setBal(var.getBal() + Math.round(var.getComputerList().get(Integer.parseInt(command.get(1)) - 1).getPrice()*1.15));
                        var.computerList.remove(var.getComputerList().get(Integer.parseInt(command.get(1)) - 1));
                        sysOut("New balance: " + var.getBal());
                    }
                } catch (Exception e) {
                    sysOut(e.toString());
                }
            } else {
                sysOut("First arg was invalid!");
            }
        }
    }

    public Object pcBuild() {
        List<Object> emptyList = new ArrayList<>();
        List<Object> pcPartsList = new ArrayList<>();
        //region CPU
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
        //endregion
        //region Motherboard
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
        //endregion
        //region RAM
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
                RAM[] rams = new RAM[Character.getNumericValue(ramConfig.get(Integer.parseInt(userCommand)).charAt(0))];
                for (int i = 0; i < (rams.length); i++) {
                    rams[i] = new RAM(ramSpeedChoice.substring(0, 4), Integer.parseInt(ramSpeedChoice.substring(ramSpeedChoice.length() - (ramSpeedChoice.length() - 5))), Integer.parseInt(ramConfig.get(Integer.parseInt(userCommand) - 1).substring(ramConfig.get(Integer.parseInt(userCommand) - 1).length() - (ramConfig.get(Integer.parseInt(userCommand) - 1).length() - 2))));
                }
                pcPartsList.add(rams);
            } catch (Exception e) {
                if (e instanceof IndexOutOfBoundsException) {
                    sysOut("Please type a valid integer!");
                }
            }
        }
        //endregion
        //region GPU
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
        //endregion
        //region Drives
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
                sysOut(chosenDrive.getCapacities().indexOf(capacityOpt) + 1 + ". " + capacityOpt + "GB ($" + calculatePriceDrive(chosenDrive, capacityOpt) + ")"); //ADD PRICE
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
        //endregion
        //region Case
        while (pcPartsList.size() != 6) {
            sysOut("**********\nSelect your case: ");
            for (Case chosenCase : caseList) {
                sysOut(caseList.indexOf(chosenCase) + 1 + ". " + chosenCase.getName() + " (" + chosenCase.getManufacturer() + " | $" + chosenCase.getPrice() + ")");
            }
            sysOut("**********");
            String userCommand = scan.nextLine();
            if (userCommand.equals("stop") || userCommand.equals("end")) {
                return emptyList;
            }
            try {
                pcPartsList.add(caseList.get(Integer.parseInt(userCommand) - 1));
            } catch (Exception e) {
                sysOut("Please type a valid integer!");
            }
        }
        //endregion
        //region PSU
        int buildWatts = getWattage(pcPartsList);
        PowerSupply chosenPSU = null;
        List<PowerSupply> powerSupplies = new ArrayList<>();
        for (PowerSupply psu : powerSupplyList) {
            if (psu.hasAbovePower(buildWatts)) {
                powerSupplies.add(psu);
            }
        }
        while (pcPartsList.size() != 7) {
            sysOut("**********\nSelect your power supply: ");
            for (PowerSupply psu : powerSupplies) {
                sysOut(powerSupplies.indexOf(psu) + 1 + ". " + psu.getName() + " (" + psu.getType() + " | " + psu.getRating() + ")");
            }
            sysOut("**********");
            String userCommand = scan.nextLine();
            if (userCommand.equals("stop") || userCommand.equals("end")) {
                return emptyList;
            }
            try {
                chosenPSU = powerSupplies.get(Integer.parseInt(userCommand) - 1);
            } catch (Exception e) {
                sysOut(e.toString());
            }
            List<Integer> chosenWattsList = new ArrayList<>();
            for (int watts : chosenPSU.getWatts()) {
                if (buildWatts <= watts) {
                    chosenWattsList.add(watts);
                }
            }
            sysOut("**********\nChoose the amount of watts: ");
            for (int watts : chosenWattsList) {
                sysOut(chosenWattsList.indexOf(watts) + 1 + ". " + watts + " ($" + chosenPSU.getPrice(watts) + ")");
            }
            sysOut("**********");
            userCommand = scan.nextLine();
            if (userCommand.equals("stop") || userCommand.equals("end")) {
                return emptyList;
            }
            try {
                chosenPSU.setChosenWatts(chosenWattsList.get(Integer.parseInt(userCommand) - 1));
                pcPartsList.add(chosenPSU);
            } catch (Exception e) {
                sysOut("Caught an error!");
            }
        }
        //endregion
        Computer builtComputer = new Computer(var.getDay(), (CPU) pcPartsList.get(0), (Motherboard) pcPartsList.get(1), (RAM[]) pcPartsList.get(2), (GPU[]) pcPartsList.get(3), (List<Drive>) pcPartsList.get(4), (Case) pcPartsList.get(5), (PowerSupply) pcPartsList.get(6));
        builtComputer.sysOutput();
        if (var.getBal() >= builtComputer.getPrice()) {
            sysOut("Would you like to buy this PC? ($" + var.getBal() + " -> $" + (var.getBal() - builtComputer.getPrice()) + ")");
            String userCommand = scan.nextLine();
            if (userCommand.equals("y") || userCommand.equals("yes")) {
                var.setBal(var.getBal() - builtComputer.getPrice());
                sysOut("Computer purchased! View it in your 'list' menu!");
                return builtComputer;
            } else if (userCommand.equals("n") || userCommand.equals("no")) {
                sysOut("Order cancelled. Returned to home.");
                return emptyList;
            }
        } else {
            sysOut("You cannot afford this PC!\nReturned to home.");
        }
        return emptyList;
    }
    //region Mini-methods
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
    public void getCPUDetails(CPU currentCPU) {
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
    public double calculatePriceDrive(Drive drive) {
        if (drive instanceof SSD) {
            if (((SSD) drive).getInterf().equals("NVMe")) {
                return Math.round((((Math.pow(((SSD) drive).getReadSpeed(), 2)) * drive.getChosenCapacity()) / (15000 * ((SSD) drive).getWriteSpeed())) * (Math.pow(0.99999, drive.getChosenCapacity())));
            } else {
                return Math.round((((Math.pow(((SSD) drive).getReadSpeed(), 2)) * drive.getChosenCapacity()) / (5000 * ((SSD) drive).getWriteSpeed())) * (Math.pow(0.99999, drive.getChosenCapacity())));
            }
        } else {
            return Math.round((((HDD) drive).getChosenCapacity()*((HDD) drive).getRpm()) / 400000);
        }
    }
    public double calculatePriceDrive(Drive drive, int cap) {
        if (drive instanceof SSD) {
            if (((SSD) drive).getInterf().equals("NVMe")) {
                return ((((Math.pow(((SSD) drive).getReadSpeed(), 2)) * cap) / (15000 * ((SSD) drive).getWriteSpeed())) * (Math.pow(0.99999, cap)));
            } else {
                return ((((Math.pow(((SSD) drive).getReadSpeed(), 2)) * cap) / (5000 * ((SSD) drive).getWriteSpeed())) * (Math.pow(0.99999, cap)));
            }
        } else {
            return Math.round((cap*((HDD) drive).getRpm()) / 400000);
        }
    }
    public void setCaseList(List<Case> caseList) {this.caseList = caseList;}
    public void setPowerSupplyList(List<PowerSupply> powerSupplyList) {
        this.powerSupplyList = powerSupplyList;
    }
    public int getWattage(List<Object> pcParts) {
        return ((CPU) pcParts.get(0)).getTDP() + ((GPU[]) pcParts.get(3))[0].getTdp() + 75 + ((RAM[]) pcParts.get(2)).length*((RAM[]) pcParts.get(2))[0].getCapacity() + ((List<Drive>) pcParts.get(4)).size()*15;
    }
    //endregion
}