package com.atom.cbp.terminal.libraries;

import java.util.ArrayList;
import java.util.List;
import com.atom.cbp.terminal.libraries.CPU;

public class Variables {
    public int day = 0;
    public int bal = 500;
    public List<CPU> intelCPUList = new ArrayList<>();
    public List<CPU> amdCPUList = new ArrayList<>();

    public void initLists() {

        //INTEL CPUS
        intelCPUList.add(new CPU("Core 2 Duo E8400", 3, 2, "Q1' 2008", 35, 16, "DDR3 1066", 65));
        intelCPUList.add(new CPU("Core i3-2370M", 2.4, 2, "Q1' 2012", 40, 16, "DDR3 1333", 35, 4));
        intelCPUList.add(new CPU("Core i3-8145U", 2.1, 2, "Q3' 2018", 100, 64, "DDR4 2400", 15, 3.9, 4));
        intelCPUList.add(new CPU("Core i3-10100", 3.6, 4, "Q2' 2020", 125, 128, "DDR4 2666", 65, 4.3, 8));
        intelCPUList.add(new CPU("Core i5-2400", 3.1, 4, "Q1' 2011", 50, 32, "DDR3 1333", 95, 3.4));
        intelCPUList.add(new CPU("Core i5-8500", 3, 6, "Q2' 2018", 185, 128, "DDR4 2666", 65, 4.1));
        intelCPUList.add(new CPU("Core i7-6700", 3.4, 4, "Q3' 2015", 250, 64, "DDR4 2133", 65, 4.0, 8));
        intelCPUList.add(new CPU("Core i7-8700", 3.2, 6, "Q4' 2017", 325, 128, "DDR4 2666", 65, 4.6, 12));
        intelCPUList.add(new CPU("Core i9-9900K", 3.6, 8, "Q4; 2018", 400, 128, "DDR4 2666", 95, 16, 5, true));

        //AMD CPUS
        amdCPUList.add(new CPU("Athlon 3000G", 3.5, 2, "Q4' 2019", 60, 64, "DDR4 2666", 35, 4, true));
        amdCPUList.add(new CPU("Ryzen 3 1200", 3.1, 4, "Q3' 2017", 125, 64, "DDR4 2666", 65, 3.4, true));
        amdCPUList.add(new CPU("Ryzen 3 3200G", 3.6, 4, "Q1' 2019", 140, 64, "DDR4 2933", 65, 4.0, true));
        amdCPUList.add(new CPU("Ryzen 5 1600", 3.2, 6, "Q1' 2017", 270, 64, "DDR4 2666", 65, 12, 4.6, true));
        amdCPUList.add(new CPU("Ryzen 5 2400G", 3.6, 4, "Q1' 2018", 175, 64, "DDR4 2933", 65, 8, 3.9, true));
        
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
}
