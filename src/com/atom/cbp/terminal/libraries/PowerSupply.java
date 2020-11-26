package com.atom.cbp.terminal.libraries;
import java.util.List;
public class PowerSupply {
    int price;
    int[] watts;
    int chosenWatts;
    String rating, name, type;
    public PowerSupply(String name, String type, String rating, int[] watts) {
        this.name = name;
        this.type = type;
        this.rating = rating;
        this.watts = watts;
    }
    public int getPrice() {
        return price;
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