package com.atom.cbp.terminal.libraries;
public class Case {
    String name, sidePanel, manufacturer, type;
    int price, usb2Ports, usb3Ports, usbCPorts;
    public Case(String name, String manufacturer, String sidePanel, String type, int usb2Ports, int usb3Ports, int usbCPorts, int price) {
        this.name = name;
        this.sidePanel = sidePanel;
        this.manufacturer = manufacturer;
        this.type = type;
        this.price = price;
        this.usb2Ports = usb2Ports;
        this.usb3Ports = usb3Ports;
        this.usbCPorts = usbCPorts;
    }
    public String getName() {
        return name;
    }
    public String getSidePanel() {
        return sidePanel;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String getType() {
        return type;
    }
    public int getPrice() {
        return price;
    }
    public int getUsb2Ports() {
        return usb2Ports;
    }
    public int getUsb3Ports() {
        return usb3Ports;
    }
    public int getUsbCPorts() {
        return usbCPorts;
    }
    public int getRating() {
        return (int) (1000*Math.pow(usb2Ports + 1, 2)*Math.pow(usb3Ports + 1, 3)*Math.pow(usbCPorts + 1, 4));
    }
}
