package lafdilibilal.u5_w1_d1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Drink implements MenuItem {
    private String name;
    private double volume;
    private int calories;
    private double price;

    public String toString() {
        return name + " (" + volume + "l)";
    }
}