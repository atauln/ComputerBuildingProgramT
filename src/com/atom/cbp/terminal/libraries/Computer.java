package com.atom.cbp.terminal.libraries;

public class Computer {
    RAM[] rams;
    CPU cpu;
    Motherboard mobo;
    GPU[] gpus;

    public Computer(CPU cpu, Motherboard mobo, RAM[] rams, GPU[] gpus) {
        this.rams = rams;
        this.mobo = mobo;
        this.cpu = cpu;
        this.gpus = gpus;
    }
}
