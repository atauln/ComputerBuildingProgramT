package com.atom.cbp.terminal.libraries;

public class Computer {
    RAM[] rams;
    CPU cpu;
    Motherboard mobo;

    public Computer(CPU cpu, Motherboard mobo, RAM[] rams) {
        this.rams = rams;
        this.mobo = mobo;
        this.cpu = cpu;
    }
}
