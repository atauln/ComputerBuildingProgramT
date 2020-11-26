package com.atom.cbp.terminal.libraries;

import com.atom.cbp.terminal.libraries.Drives.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Variables {
    public int day = 0;
    public int bal = 500;
    public List<CPU> CPUList = new ArrayList<>();
    public List<CPU> intelCPUList = new ArrayList<>();
    public List<CPU> amdCPUList = new ArrayList<>();
    public List<Motherboard> motherboardList = new ArrayList<>();
    public List<GPU> gpuList = new ArrayList<>();
    List<SSD> ssdList = new ArrayList<>();
    List<HDD> hddList = new ArrayList<>();
    List<Drive> driveList = new ArrayList<>();
    List<Case> caseList = new ArrayList<>();
    List<PowerSupply> powerSupplyList = new ArrayList<>();

    public void initLists() {
        //INTEL CPUS
        intelCPUList.add(new CPU("Core 2 Duo E8400", 3, 2, "Q1' 2008", 35, 16, "DDR3-1066", 65, "LGA775", "Wolfdale"));
        intelCPUList.add(new CPU("Core i3-2370M", 2.4, 2, "Q1' 2012", 40, 16, "DDR3-1333", 35, "LGA775", "", 4));
        intelCPUList.add(new CPU("Core i3-8145U", 2.1, 2, "Q3' 2018", 100, 64, "DDR4-2400", 15, "BGA1528", "Whiskey Lake", 3.9, 4));
        intelCPUList.add(new CPU("Core i3-10100", 3.6, 4, "Q2' 2020", 125, 128, "DDR4-2666", 65, "LGA1200", "Comet Lake", 4.3, 8));
        intelCPUList.add(new CPU("Core i5-2400", 3.1, 4, "Q1' 2011", 50, 32, "DDR3-1333", 95, "LGA1155", "Sandy Bridge", 3.4));
        intelCPUList.add(new CPU("Core i5-8500", 3, 6, "Q2' 2018", 185, 128, "DDR4-2666", 65, "LGA1151", "Coffee Lake", 4.1));
        intelCPUList.add(new CPU("Core i7-6700", 3.4, 4, "Q3' 2015", 250, 64, "DDR4-2133", 65, "LGA1151", "Skylake", 4.0, 8));
        intelCPUList.add(new CPU("Core i7-8700", 3.2, 6, "Q4' 2017", 325, 128, "DDR4-2666", 65, "LGA1151", "Coffee Lake", 4.6, 12));
        intelCPUList.add(new CPU("Core i9-9900K", 3.6, 8, "Q4; 2018", 400, 128, "DDR4-2666", 95, "LGA1151", "Coffee Lake", 16, 5, true));

        //AMD CPUS
        amdCPUList.add(new CPU("Athlon 3000G", 3.5, 2, "Q4' 2019", 60, 64, "DDR4-2666", 35, "AM4", "Zen", 4, true));
        amdCPUList.add(new CPU("Ryzen 3 1200", 3.1, 4, "Q3' 2017", 125, 64, "DDR4-2666", 65, "AM4", "Zen", 3.4, true));
        amdCPUList.add(new CPU("Ryzen 3 3200G", 3.6, 4, "Q1' 2019", 140, 64, "DDR4-2933", 65, "AM4", "Zen+", 4.0, true));
        amdCPUList.add(new CPU("Ryzen 5 1600", 3.2, 6, "Q1' 2017", 270, 64, "DDR4-2666", 65, "AM4", "Zen", 12, 4.6, true));
        amdCPUList.add(new CPU("Ryzen 5 2400G", 3.6, 4, "Q1' 2018", 175, 64, "DDR4-2933", 65, "AM4", "Zen", 8, 3.9, true));
        amdCPUList.add(new CPU("Ryzen 5 3600", 3.6, 6, "Q1' 2019", 250, 128, "DDR4-3200", 65, "AM4", "Zen 2", 12, 4.2, true));
        amdCPUList.add(new CPU("Ryzen 7 2700X", 3.7, 8, "Q1' 2018", 330, 64, "DDR4-2933", 105, "AM4", "Zen+", 16, 4.3, true));
        amdCPUList.add(new CPU("Ryzen 7 3800X", 3.9, 8, "Q3' 2019", 400, 128, "DDR4-3200", 105, "AM4", "Zen 2", 16, 4.5, true));
        amdCPUList.add(new CPU("Ryzen 9 3900X", 3.8, 12, "Q2' 2019", 500, 64, "DDR4-4133", 105, "AM4", "Zen 2", 24, 4.6, true));
        amdCPUList.add(new CPU("Ryzen Threadripper 2950X", 3.5, 16, "Q3' 2018", 900, 2048, "DDR4-2933", 180, "sTR4", "Zen+", 32, 4.4, true));
        amdCPUList.add(new CPU("Ryzen Threadripper 3970X", 3.7, 32, "Q3' 2019", 2000, 512, "DDR4-3200", 280, "sTR4", "Zen 2", 64, 4.5, true));

        //Complete CPU List
        CPUList.addAll(intelCPUList);
        CPUList.addAll(amdCPUList);


        //Motherboards
        motherboardList.add(new Motherboard("ASUS Prime Z390-A","LGA1151", "ATX", 2, 5, 1, 2, 4, 64, 6, 3, 2, false, false, 180));
        motherboardList.add(new Motherboard("ASRock B450M PRO4", "AM4", "Micro ATX", 2, 5, 1, 2, 4, 64, 4, 2, 2, false, false, 83));
        motherboardList.add(new Motherboard("MSI MAG B550M BAZOOKA", "AM4", "Micro ATX", 2, 4, 0, 2, 4, 128, 4, 1, 2, false, false, 130));


        //GPUs
        gpuList.add(new GPU("NVIDIA Geforce RTX 3080", "Q3' 2020", "GDDR6X", 10, 8704, 1440, 1710, 600, 320));


        //SSDs
        ssdList.add(new SSD("Samsung 860 EVO Series", new ArrayList<>(Arrays.asList(250, 500, 1000, 2000, 4000)), 550, 520, "SATA"));
        ssdList.add(new SSD("T-FORCE VulcanG", new ArrayList<>(Arrays.asList(512, 1000)), 550, 500, "SATA"));
        ssdList.add(new SSD("WD BLUE", new ArrayList<>(Arrays.asList(250, 500, 1000, 2000, 4000)), 560, 530, "SATA"));

        ssdList.add(new SSD("Samsung 970 EVO Plus", new ArrayList<>(Arrays.asList(250, 500, 1000, 2000)), 3500, 3300, "NVMe"));
        ssdList.add(new SSD("WD BLACK SN750", new ArrayList<>(Arrays.asList(250, 500, 1000, 2000)), 3470, 3000, "NVMe"));
        ssdList.add(new SSD("Sabrent ROCKET", new ArrayList<>(Arrays.asList(256, 512, 1000, 2000, 4000)), 3400, 3000, "NVMe"));

        //HDDs
        hddList.add(new HDD("Seagate IronWolf NAS", new ArrayList<>(Arrays.asList(1000, 2000, 3000, 4000, 6000, 8000, 10000, 12000, 14000, 16000)), 7200));
        hddList.add(new HDD("WD Red Plus", new ArrayList<>(Arrays.asList(1000, 2000, 3000, 4000, 6000, 8000, 10000, 12000, 14000)), 5400));
        hddList.add(new HDD("TOSHIBA NAS Systems N300", new ArrayList<>(Arrays.asList(4000, 6000, 8000, 10000, 12000, 14000)), 7200));

        //Complete drive list
        driveList.addAll(ssdList);
        driveList.addAll(hddList);

        //Cases
        caseList.add(new Case("H510", "NZXT", "Tempered Glass", "ATX", 0, 1, 1, 70));
        caseList.add(new Case("275R Airflow", "Corsair", "Tempered Glass", "ATX", 0, 2, 0, 80));

        //Power Supplies
        powerSupplyList.add(new PowerSupply("EVGA BA", "Non-Modular", "80+ BRONZE", new int[]{450, 500, 550, 600, 650, 700, 750, 850}));
        powerSupplyList.add(new PowerSupply("Seasonic S12III", "Non-Modular", "80+ BRONZE", new int[]{500, 550, 650}));
        powerSupplyList.add(new PowerSupply("Corsair RMx Series", "Full Modular", "80+ GOLD", new int[]{550, 650, 750, 850, 1000}));
        powerSupplyList.add(new PowerSupply("Gigabyte P450B", "Non-Modular", "80+ BRONZE", new int[]{450, 550, 650}));
        powerSupplyList.add(new PowerSupply("Gigabyte P750GM", "Full Modular", "80+ GOLD", new int[]{750, 850}));
    }
    public List<CPU> getAmdCPUList() {
        return amdCPUList;
    }
    public List<CPU> getIntelCPUList() {
        return intelCPUList;
    }
    public void setBal(int value) {
        bal = value;
    }
    public int getBal() {
        return bal;
    }
    public void setDay(int value) {
        day = value;
    }
    public int getDay() {
        return day;
    }
    public List<CPU> getCPUList() {
        return CPUList;
    }
    public List<Motherboard> getMotherboardList() {
        return motherboardList;
    }
    public List<GPU> getGpuList() {
        return gpuList;
    }
    public List<SSD> getSsdList() {
        return ssdList;
    }
    public List<HDD> getHddList() {
        return hddList;
    }
    public List<Case> getCaseList() {
        return caseList;
    }
    public List<Drive> getDriveList() {
        return driveList;
    }
    public List<PowerSupply> getPowerSupplyList() {
        return powerSupplyList;
    }
}