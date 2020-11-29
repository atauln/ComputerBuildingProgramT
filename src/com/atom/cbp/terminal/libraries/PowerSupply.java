package com.atom.cbp.terminal.libraries;
public class PowerSupply {
    int[] watts;
    int chosenWatts;
    String rating, name, type;
    public PowerSupply(String name, String type, String rating, int[] watts) {
        this.name = name;
        this.type = type;
        this.rating = rating;
        this.watts = watts;
    }
    public double getPrice() {
        double modifier;
        switch (rating) {
            case "80+ BRONZE": {
                modifier = 1.1;
                break;
            }
            case "80+ SILVER": {
                modifier = 1.25;
                break;
            }
            case "80+ GOLD": {
                modifier = 1.5;
                break;
            }
            case "80+ PLATINUM": {
                modifier = 1.8;
                break;
            }
            case "80+ TITANIUM": {
                modifier = 2.3;
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + rating);
        }
        return (Math.pow((0.7*modifier), modifier)*chosenWatts)/10;
    }
    public double getPrice(int amount) {
        double modifier;
        switch (rating) {
            case "80+ BRONZE": {
                modifier = 1.1;
                break;
            }
            case "80+ SILVER": {
                modifier = 1.25;
                break;
            }
            case "80+ GOLD": {
                modifier = 1.5;
                break;
            }
            case "80+ PLATINUM": {
                modifier = 1.8;
                break;
            }
            case "80+ TITANIUM": {
                modifier = 2.3;
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + rating);
        }
        return (Math.pow((0.7*modifier), modifier)*amount)/10;
    }
    public int[] getWatts() {
        return watts;
    }
    public String getRating() {
        return rating;
    }
    public int getChosenWatts() {
        return chosenWatts;
    }
    public String getName() {
        return name;
    }
    public void setChosenWatts(int chosenWatts) {
        this.chosenWatts = chosenWatts;
    }
    public String getType() {
        return type;
    }
    public boolean hasAbovePower(int powerLevel) {
        for (int wattage : watts) {
            if (wattage >= powerLevel) {
                return true;
            }
        }
        return false;
    }
}