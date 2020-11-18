package com.atom.cbp.terminal.libraries;

import java.util.ArrayList;
import java.util.List;

public class Variables {
    public int day = 0;
    public int bal = 500;
    public List<CPU> CPUList = new ArrayList<>();
    public List<CPU> intelCPUList = new ArrayList<>();
    public List<CPU> amdCPUList = new ArrayList<>();
    public List<Motherboard> motherboardList = new ArrayList<>();
    public List<GPU> gpuList = new ArrayList<>();

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
        gpuList.add(new GPU("NVIDIA Geforce RTX 3080", "Q3' 2020", "GDDR6X", 10, 8704, 1440, 1710, 600));
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
    public List<GPU> getGpuList() { return gpuList;}
}