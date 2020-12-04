package com.atom.cbp.terminal.libraries;

public class Motherboard {

    //General variables
    String socket, size, name;
    int pcieSlots, ramSlots, sataSlots, nvmeSlots, usb2Ports, usb3Ports, usbCPorts, numOutputs, maxMemory, price;
    boolean intWiFi, intBT;

    //Method declaration
    public Motherboard(String name, String socket, String size, int usb2Ports, int usb3Ports, int usbCPorts, int numOutputs, int ramSlots, int maxMemory, int sataSlots, int pcieSlots, int nvmeSlots, boolean intWiFi, boolean intBT, int price) {
        this.name = name;
        this.socket = socket;
        this.size = size;
        this.usb2Ports = usb2Ports;
        this.usb3Ports = usb3Ports;
        this.usbCPorts = usbCPorts;
        this.numOutputs = numOutputs;
        this.pcieSlots = pcieSlots;
        this.ramSlots = ramSlots;
        this.nvmeSlots = nvmeSlots;
        this.intWiFi = intWiFi;
        this.intBT = intBT;
        this.sataSlots = sataSlots;
        this.maxMemory = maxMemory;
        this.price = price;
    }

    //Getter methods
    public String getSocket() {
        return socket;
    }
    public String getSize() {
        return size;
    }
    public int getPcieSlots() {
        return pcieSlots;
    }
    public int getRamSlots() {
        return ramSlots;
    }
    public int getNvmeSlots() {
        return nvmeSlots;
    }
    public boolean isIntWiFi() {
        return intWiFi;
    }
    public boolean isIntBT() {
        return intBT;
    }
    public int getUsb2Ports() {
        return usb2Ports;
    }
    public int getUsb3Ports() {
        return usb3Ports;
    }
    public int getNumOutputs() {
        return numOutputs;
    }
    public int getUsbCPorts() {
        return usbCPorts;
    }
    public String getName() {
        return name;
    }
    public int getSataSlots() {
        return sataSlots;
    }
    public int getMaxMemory() {
        return maxMemory;
    }
    public int getPrice() {
        return price;
    }
    public int getRating() {
        int motherboardRating = (int) (Math.pow(2*this.getUsb2Ports(), 2) + Math.pow(3*this.getUsb3Ports(), 3) + Math.pow(4*this.getUsbCPorts(), 4) + Math.pow(3*this.getNumOutputs(), 4));
        if (this.isIntBT()) {
            motherboardRating *= 2;
        }
        if (this.isIntWiFi()) {
            motherboardRating *= 2;
        }
        return motherboardRating;
    }
}